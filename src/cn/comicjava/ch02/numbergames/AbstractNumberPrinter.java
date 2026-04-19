package cn.comicjava.ch02.numbergames;

public abstract class AbstractNumberPrinter implements NumberPrinter, Runnable {

    private int limit;

    public AbstractNumberPrinter(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        synchronized (AbstractNumberPrinter.class) {
            for (int i = 0; i < limit; i++) {
                if (acceptNumber(i)) {
                    printNumber(i);
                }
            }
        }

    }

    protected abstract boolean acceptNumber(int number);

    @Override
    public void printNumber(int number) {
        System.out.println(Thread.currentThread().getName() + " " + number);
    }

}