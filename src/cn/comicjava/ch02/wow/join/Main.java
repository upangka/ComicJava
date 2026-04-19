package cn.comicjava.ch02.wow.join;

/**
 * 暗夜精灵: "起——来——！！！！"
 * 暗夜精灵: "出发吧！进入战斗！"
 * 【小矮人 (有点晚)】: "哈——欠，唉，早上好，我来了，我来了。"
 */
public class Main {
    public static void main(String[] args) {
        final Dwarf dwarf = new Dwarf("小矮人");
        final NightElf nightElf = new NightElf("暗夜精灵");


        final Thread dwarfThread = new Thread(() -> {
            dwarf.chargeIntoBattle(nightElf);
        });

        final Thread elfThread = new Thread(() -> {
            try {
                dwarfThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nightElf.chargeIntoBattle(dwarf);
        });

        dwarfThread.start();
        elfThread.start();

    }
}
