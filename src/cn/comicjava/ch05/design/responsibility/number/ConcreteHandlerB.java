package cn.comicjava.ch05.design.responsibility.number;

public class ConcreteHandlerB extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println("%s[10,20) 处理请求 【%d】".formatted(this.getClass().getSimpleName(), request));
            return;
        }

        if (successor != null) {
            successor.handleRequest(request);
        }
    }

}
