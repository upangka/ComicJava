package cn.comicjava.ch05.design.proxy;

public class JDKProxyTest {
    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl("李娇娇");
        Pursuit pursuit = new Pursuit("卓贾");
        pursuit.setMm(schoolGirl);
        IGiveGift daiLi = JDKProxyFactory.createProxy(schoolGirl, pursuit);
        daiLi.giveChocolate();
        daiLi.giveDolls();
        daiLi.giveFlowers();
    }
}
