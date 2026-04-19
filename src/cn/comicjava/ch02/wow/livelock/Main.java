package cn.comicjava.ch02.wow.livelock;

public class Main {
    public static void main(String[] args) {
        final Dwarf dwarf = new Dwarf("矮人");
        final NightElf nightElf = new NightElf("暗夜精灵");
        final Beer beer = new Beer(dwarf);
       
        new Thread(() -> dwarf.drink(beer, nightElf)).start();
        new Thread(() -> nightElf.drink(beer, dwarf)).start();

    }
}
