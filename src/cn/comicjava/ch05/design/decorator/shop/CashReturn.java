package cn.comicjava.ch05.design.decorator.shop;

/**
 * 返利活动
 * 比如满300返100
 */
public class CashReturn extends CashSuper {
    private double moneyCondition = 0.0d;
    private double moneyReturn = 0.0d;

    /**
     * 比如满300返100
     * 
     * @param moneyCondition 300
     * @param moneyReturn    100
     */
    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double price, int num) {
        double result = price * num;
        if (result >= moneyCondition) {
            result = result - Math.floor((result / moneyCondition)) * moneyReturn;
        }
        // 已经计算好所有商品的价格，数量变成1
        return super.acceptCash(price, 1);
    }
}
