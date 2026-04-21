package cn.comicjava.ch05.design.proxy;

public class MyproxyTest {
    public static void main(String[] args) {
        SchoolGirl girl = new SchoolGirl("李娇娇");
        MyProxy proxy = new MyProxy(girl);
        proxy.giveFlowers();
        proxy.giveChocolate();
        proxy.giveFlowers();
    }
}
