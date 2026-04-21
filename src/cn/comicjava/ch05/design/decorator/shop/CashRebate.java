package cn.comicjava.ch05.design.decorator.shop;

/**
 * 打折活动
 */
public class CashRebate extends CashSuper{
    private double rebate;

    /**
     * 打折，根据折扣率收费
     * @param rebate 比如0.8
     */
    public CashRebate(double rebate){
        if(rebate < 0 || rebate > 1){
            throw new IllegalArgumentException("折扣率必须在0-1之间");
        }
        this.rebate = rebate;
    }

    @Override
    public double acceptCash(double price, int num) {
        double result =  price * num * rebate;
        return super.acceptCash(result, 1);
    }
}
