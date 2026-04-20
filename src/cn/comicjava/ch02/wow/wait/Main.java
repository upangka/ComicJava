package cn.comicjava.ch02.wow.wait;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Student stu = new Student("小明");
        Worker worker = new Worker("菲利普");
        Library gzLib = new Library("广州图书馆");

        Thread stuThread = new Thread(() -> stu.rushToOccupySeat(gzLib));
        Thread workThread = new Thread(() -> worker.rushToOccupySeat(gzLib));

        stuThread.start();
        workThread.start();

        Thread.sleep(1000);

        synchronized(gzLib){
            gzLib.setOpen(true);
            gzLib.notifyAll();
        }
    }
}
