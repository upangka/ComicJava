package cn.comicjava.ch05.design.responsibility.number;

public class Main {
    public static void main(String[] args) {
        int[] requests = {12, 5, 28, 19, 7, 24, 3, 16};

        // 构建责任链
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        Handler handlerC = new ConcreteHandlerC();

        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        for (int request : requests) {
            handlerA.handleRequest(request);
        }
    }
}
