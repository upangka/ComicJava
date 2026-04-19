package cn.comicjava.ch02.numbergames;

public class Main {
    
    public static void main(String[] args) {
        int limit = 100;
        new Thread(new EvenNumberPrinter(limit), "偶数线程").start();
        new Thread(new OddNumberPrinter(limit), "奇数线程").start();
    }
}