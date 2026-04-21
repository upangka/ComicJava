package cn.comicjava.ch05.design.proxy;

public class MyProxy implements IGiveGift {
    private final String name = "戴励";
    private Pursuit gg;
    private SchoolGirl mm;
    private int count = 0;

    public MyProxy(SchoolGirl mm) {
        this.gg = new Pursuit("卓贾");
        this.mm = mm;
        gg.setMm(mm);
    }

    @Override
    public void giveDolls() {
        System.out.printf("%s帮%s:%n", name, gg.getName());
        this.gg.giveDolls();
        checkLove();
    }

    @Override
    public void giveFlowers() {
        System.out.printf("%s帮%s:%n", name, gg.getName());
        this.gg.giveFlowers();
        checkLove();
    }

    @Override
    public void giveChocolate() {
        System.out.printf("%s帮%s:%n", name, gg.getName());
        this.gg.giveChocolate();
        checkLove();
    }

    private void checkLove() {
        this.count++;
        if (count >= 3) {
            System.out.printf("%s: 对不起好兄弟(%s),我爱上了她(%s)%n",
                    this.name,
                    this.gg.getName(),
                    this.mm.name());
        }
    }

}
