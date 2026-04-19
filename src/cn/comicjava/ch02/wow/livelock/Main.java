package cn.comicjava.ch02.wow.livelock;

public class Main {
    public static void main(String[] args) {
        final Dwarf dwarf = new Dwarf("矮人");
        final NightElf nightElf = new NightElf("暗夜精灵");
        
       new Thread(() -> dwarf.visit(nightElf), "矮人线程").start();
       new Thread(() -> nightElf.visit(dwarf), "暗夜精灵线程").start();
    }
}
