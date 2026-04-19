package cn.comicjava.ch02.numbergames;

public class EvenNumberPrinter extends AbstractNumberPrinter{
    
    public EvenNumberPrinter(int limit) {
        super(limit);
    }

    @Override
    protected boolean acceptNumber(int number) {
        return number % 2 == 0;
    }
}
