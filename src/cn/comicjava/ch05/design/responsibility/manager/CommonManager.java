package cn.comicjava.ch05.design.responsibility.manager;

/**
 * 普通经理
 */
public class CommonManager extends Manager {

    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if ("请假".equals(request.type()) && request.number() <= 2)
            System.out.println(this.name + ":" + request.content() + " 数量：" + request.number() + "天，被批准");
        else {
            if (this.superior != null)
                this.superior.requestApplication(request);
        }
    }

}
