package cn.comicjava.ch02;

public class DoSomething implements Runnable{

    public void run() {

        System.out.println(Thread.currentThread().getName() + " I'm doing something!");

    }
        
}
