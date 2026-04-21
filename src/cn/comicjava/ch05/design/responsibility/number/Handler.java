package cn.comicjava.ch05.design.responsibility.number;

/**
 * 抽象处理类
 */
public abstract class Handler {
    // 继任者
    protected Handler successor;

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }

    public abstract void handleRequest(int request);
}
