package cn.comicjava.ch05.design.responsibility.manager;

public abstract class Manager {
    protected String name;
    // 上级
    protected Manager superior;

    public Manager(String name){
        this.name = name;
    }

    public void setSuperior(Manager superior){
        this.superior = superior;
    }

    public abstract void requestApplication(Request request);
}
