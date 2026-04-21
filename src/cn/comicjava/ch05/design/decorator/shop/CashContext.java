package cn.comicjava.ch05.design.decorator.shop;
/**
 * 购物车现金上下文，用于处理不同类型的折扣和计算策略
 */
public class CashContext {
    private final ISale cs;
    
    public CashContext(int cashType) {
        cs = switch (cashType) {
            case 1 -> new CashNormal();  // 正常收费
            case 2 -> new CashRebate(0.8d);  // 打8折
            case 3 -> new CashRebate(0.7d);  // 打7折
            case 4 -> new CashReturn(300d, 100d);  // 满300返100
            case 5 -> {  // 先打8折,再满300返100
                CashNormal cn = new CashNormal();
                CashReturn cashReturn = new CashReturn(300d, 100d);
                CashRebate cashRebate = new CashRebate(0.8d);
                cashReturn.decorate(cn);   // 用满300返100算法包装基本的原价算法
                cashRebate.decorate(cashReturn);  // 打8折算法装饰满300返100算法
                yield cashRebate;  // 将包装好的算法组合引用传递给cs对象
            }
            case 6 -> {  // 先满200返50，再打7折
                CashNormal cashNormal = new CashNormal();
                CashRebate cashRebate = new CashRebate(0.7d);
                CashReturn cashReturn = new CashReturn(200d, 50d);
                cashRebate.decorate(cashNormal);  // 用打7折算法包装基本的原价算法
                cashReturn.decorate(cashRebate);  // 满200返50算法装饰打7折算法
                yield cashReturn;  // 将包装好的算法组合引用传递给cs对象
            }
            default -> throw new IllegalArgumentException("不支持的现金类型: " + cashType);
        };
    }

    public double getResult(double price,int num){
        return cs.acceptCash(price, num);
    }
}
