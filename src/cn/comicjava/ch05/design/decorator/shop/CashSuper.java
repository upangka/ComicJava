package cn.comicjava.ch05.design.decorator.shop;

/**
 * 装饰器者
 */
public class CashSuper implements ISale{

    private ISale component;

    public void decorate(ISale component){
        this.component = component;
    }

    @Override
    public double acceptCash(double price, int num) {
        double result = 0;
        if(component != null){
            result = component.acceptCash(price, num);
        }
        return result;
    }
    
}
