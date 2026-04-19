package cn.comicjava.ch02.wow.join;

public abstract class Hero {
    private String name;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 将自己投入战斗
     * @param hero
     */
    public abstract void chargeIntoBattle(Hero hero);
}
