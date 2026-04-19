package cn.comicjava.ch02;

public class DoSomethingToo extends Thread{
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " I'm doing something too!");
    }
}