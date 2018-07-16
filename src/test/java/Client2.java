import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client2 {
    public static void main(String[] args) throws IOException, InterruptedException {

        int i = 0;
        while (i < 10) {
            Socket socket = new Socket("127.0.0.1", 8877);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            InputStream inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//包装成字符流，提高效率
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//缓冲区

            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            try {
                bw.write(time); // 发送当前时间的字符串
                bw.newLine(); // 需要换行符做readLine()
                bw.flush();
                i++;
                System.out.println("已发送数据！");

                String info="";
                String temp=null;//临时变量
                while((temp=bufferedReader.readLine())!=null){
                    info+=temp;
                    System.out.println("客户端接收服务端发送信息："+info);
                }
                System.out.println("socket通信已完成！");
//                Thread.sleep(1000);
            } catch (Exception e) {
                os.close();
                osw.close();
                bw.close();
                inputStream.close();
                inputStreamReader.close();
                bufferedReader.close();

                System.out.println("Connection Close");
                System.out.println(e);
                break;
            }
        }
    }
}