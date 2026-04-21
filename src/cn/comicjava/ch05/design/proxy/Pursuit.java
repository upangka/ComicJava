package cn.comicjava.ch05.design.proxy;

public class Pursuit implements IGiveGift {
    private SchoolGirl mm;
    private final String name;

    public Pursuit(String name) {
        this.name = name;
    }

    public void setMm(SchoolGirl mm){
        this.mm = mm;
    }

    public String getName(){
        return this.name;
    }

    public void giveDolls() {
        System.out.println(this.mm.name() + ",你好！送你洋娃娃。");
    }

    public void giveFlowers() {
        System.out.println(this.mm.name() + ",你好！送你鲜花。");
    }

    public void giveChocolate() {
        System.out.println(this.mm.name() + ",你好！送你巧克力。");
    }

}
