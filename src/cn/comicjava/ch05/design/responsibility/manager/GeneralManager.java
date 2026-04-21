package cn.comicjava.ch05.design.responsibility.manager;

/**
 * 总经理
 */
public class GeneralManager extends Manager {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {

        if ("请假".equals(request.type())) {
            System.out.println(this.name + ":" + request.content() + " 数量：" + request.number() + "天，被批准");
        } else if ("加薪".equals(request.type()) && request.number() <= 5000) {
            System.out.println(this.name + ":" + request.content() + " 数量：" + request.number() + "元，被批准");
        } else if ("加薪".equals(request.type()) && request.number() > 5000) {
            System.out.println(this.name + ":" + request.content() + " 数量：" + request.number() + "元，再说吧");
        }
    }

}
