package cn.comicjava.ch02.wow.deadlock;

public class Main {
    public static void main(String[] args) {
        final Dwarf dwarf = new Dwarf("矮人");
        final NightElf nightElf = new NightElf("暗夜精灵");
        
       new Thread(() -> dwarf.visit(nightElf)).start();
       new Thread(() -> nightElf.visit(dwarf)).start();
    }
}
