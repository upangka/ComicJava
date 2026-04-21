package cn.comicjava.ch05.design.responsibility.number;

public class ConcreteHandlerC extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 20 && request < 30) {
            System.out.println("%s[20,30) 处理请求 【%d】".formatted(this.getClass().getSimpleName(), request));
            return;
        }

        if (successor != null) {
            successor.handleRequest(request);
        }
    }

}
