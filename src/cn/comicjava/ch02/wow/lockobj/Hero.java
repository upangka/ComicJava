package cn.comicjava.ch02.wow.lockobj;

public class Hero {
    private String name;
    private Object lock;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Object getLock() {
        return lock;
    }

    public void setLock(Object lock) {
        this.lock = lock;
    }

    public void visit(Hero hero) {

        synchronized (this.getLock()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s: \"我们在%s那儿见面，那我就先出发了。\"%n", this.getName(), hero.getName());
            hero.receiveVisit(this);
        }

    }

    public void receiveVisit(Hero hero) {
        synchronized (this.getLock()) {
            System.out.printf("%s: \"我们在我家见面了。\"%n", this.getName());
        }
    }
}
