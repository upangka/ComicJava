package cn.comicjava.ch02;

public class Main {
    public static void main(String[] args) {
        new Thread(new DoSomething()).start();
        new DoSomethingToo().start();
    }
}
