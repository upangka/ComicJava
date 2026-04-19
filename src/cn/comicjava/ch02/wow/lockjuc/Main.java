package cn.comicjava.ch02.wow.lockjuc;

public class Main {
    public static void main(String[] args) {
        final Dwarf dwarf = new Dwarf("矮人");
        final NightElf nightElf = new NightElf("暗夜精灵");
        
        new Thread(() -> dwarf.visit(nightElf), "任务1").start();
        new Thread(() -> nightElf.visit(dwarf), "任务2").start();
    }
}
