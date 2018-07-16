package com.signv.listener;

public class MyThread extends Thread{
    public int num = 0;
    public int flag = 0;
    public void setNum(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setFlag(int flag){
        this.flag = flag;
    }

}
