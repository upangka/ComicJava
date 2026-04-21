package cn.comicjava.ch05.design.responsibility.number;

public class ConcreteHandlerA extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 0 && request < 10) {
            System.out.println("%s[0,10) 处理请求 【%d】".formatted(this.getClass().getSimpleName(), request));
            return;
        }

        if (successor != null) {
            successor.handleRequest(request);
        }
    }

}
