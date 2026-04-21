package cn.comicjava.ch05.design.decorator.shop;

/**
 * 正常收费
 */
public class CashNormal implements ISale{
    @Override
    public double acceptCash(double price,int num) {
        return price * num;
    }
}