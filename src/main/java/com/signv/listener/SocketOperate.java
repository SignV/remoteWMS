package com.signv.listener;

import com.signv.domain.OutInStatistics;
import com.signv.service.EpcService;
import com.signv.service.OutInStatisticsService;
import com.signv.service.RepositoryService;
import com.signv.utils.ByteUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

/**
 * 多线程处理socket接收的数据
 * @author zhangzhongwen
 *
 */
@Component
public class SocketOperate extends Thread implements ApplicationContextAware {
    private ServerSocket serverSocket;
    private Socket socket;
    private static ApplicationContext applicationContext;
    public static Map<String,MyRunnable> runnables = new HashMap<String, MyRunnable>();

    public void run()
    {
        try {
            serverSocket = new ServerSocket(8877);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //开启线程 进行socket通信
        MyRunnable runnable = new MyRunnable() {
            public void run() {
                while (true){
                    try {
                        socket = serverSocket.accept();
                        InputStream in = socket.getInputStream();
                        OutputStream out = socket.getOutputStream(); //开启输出流，服务器发送命令帧信息
                        byte[] temp = new byte[1];
                        byte[] data;
                        boolean startFlag = true;
                        boolean openFlag = false;
                        while (startFlag) {
                            boolean closeFlag = true;
                            try {
                                Thread.sleep(1000);
                                System.out.println("仓库管理模块已关闭，等待开启中...");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (this.getNum() == 1) {
                                System.out.println("开启仓库管理模块...");
                                startFlag = false;
                                this.setNum(3);
                                if(openFlag){
                                    byte[] order1 = new byte[]{(byte) 0xBB, 0x00, 0x01, 0x00, 0x01, 0x7E};
                                    out.write(order1);
                                    openFlag = false;
                                }
                                while (closeFlag && (in.read(temp)) != -1  ) {
                                    System.out.println("接收数据中...");
                                    if (this.getNum() == 2) {
                                        byte[] closeOrder = new byte[]{(byte) 0xBB, 0x00, 0x02, 0x00, 0x02, 0x7E};
                                        out.write(closeOrder);
                                        this.setNum(3);
                                    }
                                    data = temp;
                                    String header = ByteUtils.byte2hex(data);
                                    System.out.println(data + "转化之后" + header + "结尾");
                                    if (header.equals("bb")) {
                                        System.out.println("帧头BB正确，进入指令解析");
                                        byte[] typeCommandPL = new byte[3];
                                        in.read(typeCommandPL);//读取三个字节，即读取第四位的参数长度
                                        int type = typeCommandPL[0];//读取帧类型 00命令帧 01通知帧 02响应帧
                                        int command = typeCommandPL[1];//读取指令代码
                                        int parameterLength = typeCommandPL[2];//读取参数长度
                                        byte[] dataTail = new byte[parameterLength + 2];
                                        in.read(dataTail);
                                        //读取参数
                                        byte[] parameter = new byte[parameterLength];
                                        for (int i = 0; i < parameterLength; i++) {
                                            parameter[i] = dataTail[i];
                                        }
                                        if (type == 1) {
                                            System.out.println("获取到通知帧01");
                                            switch (command) {
                                                case 1: {
                                                    System.out.println("仓库管理模块准备完毕");
                                                    int reNum = parameter[0];
                                                    System.out.println(reNum + "号仓库准备完毕");
                                                    //服务器发送命令帧开启仓库管理工作
                                                    byte[] order1 = new byte[]{(byte) 0xBB, 0x00, 0x01, 0x00, 0x01, 0x7E};
                                                    out.write(order1);
                                                    System.out.println("发送命令帧开启仓库管理工作");
                                                    break;
                                                }
                                                case 2: {
                                                    System.out.println("仓库管理模块日常测试通知");
                                                    //服务器发送命令帧开启仓库管理工作
                                                    byte[] order2 = new byte[]{(byte) 0xBB, 0x00, (byte) 0xCC, 0x00, (byte) 0xCC, 0x7E};
                                                    out.write(order2);
                                                    System.out.println("发送命令帧回复");
                                                    break;
                                                }
                                                case 3: {
                                                    System.out.println("温湿度数据通知帧");         //温度湿度有三个参数
                                                    int para1 = parameter[0];   //（表示该仓库的几号传感器）
                                                    int para2 = parameter[1];   //（表示十进制温度）
                                                    int para3 = parameter[2];   //（表示十进制湿度）
                                                    RepositoryService repositoryService = applicationContext.getBean(RepositoryService.class);
                                                    boolean flag = repositoryService.respositorySocket(para1, para2, para3);
                                                    if (!flag) {//温湿度异常时 开启蜂鸣器 通知管理员 一段时间后再关闭
                                                        byte[] order3 = new byte[]{(byte) 0xBB, 0x00, 0x04, 0x00, 0x04, 0x7E};
                                                        out.write(order3);
                                                        System.out.println("温湿度异常！发送命令帧开启蜂鸣器");
                                                        try {
                                                            new Thread().sleep(3000);
                                                        } catch (InterruptedException e) {
                                                            e.printStackTrace();
                                                        }
                                                        byte[] order4 = new byte[]{(byte) 0xBB, 0x00, 0x05, 0x00, 0x05, 0x7E};
                                                        out.write(order4);
                                                        System.out.println("温湿度异常！发送命令帧关闭蜂鸣器");
                                                    }
                                                    break;
                                                }
                                                case 4: {
                                                    System.out.println("正在进行货物出入库");
                                                    String goodsEPC = ByteUtils.byte2hex(parameter).toUpperCase();//获取参数串 表示出库的货物EPC码
                                                    System.out.println("货物EPC码：" + goodsEPC);
                                                    EpcService epcService = applicationContext.getBean(EpcService.class);
                                                    boolean flag = epcService.epcSocket(goodsEPC);
                                                    if (!flag) {//EPC码异常时 开启蜂鸣器 通知管理员 一段时间后再关闭
                                                        byte[] order5 = new byte[]{(byte) 0xBB, 0x00, 0x04, 0x00, 0x04, 0x7E};
                                                        out.write(order5);
                                                        System.out.println("货物EPC码异常！发送命令帧开启蜂鸣器");
                                                        try {
                                                            new Thread().sleep(3000);
                                                        } catch (InterruptedException e) {
                                                            e.printStackTrace();
                                                        }
                                                        byte[] order6 = new byte[]{(byte) 0xBB, 0x00, 0x05, 0x00, 0x05, 0x7E};
                                                        out.write(order6);
                                                        System.out.println("货物EPC码异常！发送命令帧关闭蜂鸣器");
                                                    }
                                                    System.out.println(flag);
                                                    break;
                                                }
                                            }
                                        } else if (type == 2) {
                                            System.out.println("获取到响应帧02");
                                            switch (command) {
                                                case 1: {
                                                    System.out.println("开启仓库管理模块工作");//该模块无参数直接进行读取下一个命令
                                                    break;
                                                }

                                                case 2: {
                                                    System.out.println("关闭仓库管理模块工作");//关闭仓库管理模块 并做相应标志处理
                                                    startFlag = true;       //开始仓库线程工作
                                                    closeFlag = false;      //关闭仓库管理模块工作
                                                    openFlag = true;        //开启仓库管理模块工作
                                                    break;
                                                }

                                                case 3: {
                                                    System.out.println("入库货物指令");         //该模块无参数直接进行读取下一个命令
                                                    break;
                                                }
                                                case 4: {
                                                    System.out.println("开启仓库管理模块蜂鸣器指令"); //该模块无参数直接进行读取下一个命令
                                                    break;
                                                }
                                                case 5: {
                                                    System.out.println("关闭仓库管理模块蜂鸣器指令"); //该模块无参数直接进行读取下一个命令
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        out.flush();
                        out.close();
                        socket.close();
                        System.out.println("socket stop.....");
                    }catch(IOException ex){

                    }finally{

                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        runnables.put("this",runnable);
    }

    public void closeSocketServer(){
        try {
            if(null!=serverSocket && !serverSocket.isClosed())
            {
                serverSocket.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SocketOperate.applicationContext = applicationContext;
    }
}