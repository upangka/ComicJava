package cn.comicjava.ch02.wow.lockobj;

public class Main {
    public static void main(String[] args) {
        final Dwarf dwarf = new Dwarf("矮人");
        final NightElf nightElf = new NightElf("暗夜精灵");

        Object lock = new Object();
        dwarf.setLock(lock);
        nightElf.setLock(lock);
        
       new Thread(() -> dwarf.visit(nightElf), "矮人线程").start();
       new Thread(() -> nightElf.visit(dwarf), "暗夜精灵线程").start();
    }
}
