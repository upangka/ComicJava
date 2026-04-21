package cn.comicjava.ch05.design.responsibility.manager;

public class Main {
    public static void main(String[] args) {
        System.out.println("**********************************************");       


        CommonManager manager = new CommonManager("经理");
        Director director = new Director("总监");
        GeneralManager generalManager = new GeneralManager("总经理");
        manager.setSuperior(director);
        director.setSuperior(generalManager);

        Request request = new Request("请假","小菜请假",1);
        manager.requestApplication(request);

        Request request2 = new Request("请假","小菜请假",3);
        manager.requestApplication(request2);

        Request request3 = new Request("加薪","小菜请求加薪",5000);
        manager.requestApplication(request3);

        Request request4 = new Request("加薪","小菜请求加薪",10000);
        manager.requestApplication(request4);
 
        System.out.println();
        System.out.println("**********************************************");
    }
}
