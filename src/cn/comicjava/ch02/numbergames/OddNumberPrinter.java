package cn.comicjava.ch02.numbergames;

public class OddNumberPrinter extends AbstractNumberPrinter {

    public OddNumberPrinter(int limit) {
        super(limit);
    }

    @Override
    protected boolean acceptNumber(int number) {
        return number % 2 != 0;
    }
}
