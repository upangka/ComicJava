package cn.comicjava.ch02.wow.livelock;

public class Hero {
    private String name;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void visit(Hero hero){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: \"我们在%s那儿见面，那我就先出发了。\"%n", this.getName(), hero.getName());
        hero.receiveVisit(this);
    }

    public synchronized void receiveVisit(Hero hero){
        System.out.printf("%s: \"我们在我家见面了。\"%n", this.getName());
    }
}
