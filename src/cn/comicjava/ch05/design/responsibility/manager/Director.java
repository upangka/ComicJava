package cn.comicjava.ch05.design.responsibility.manager;

/**
 * 总监
 */
public class Director extends Manager {

    public Director(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if ("请假".equals(request.type()) && request.number() <= 5)
            System.out.println(this.name + ":" + request.content() + " 数量：" + request.number() + "天，被批准");
        else {
            if (this.superior != null)
                this.superior.requestApplication(request);
        }
    }

}
