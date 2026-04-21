package cn.comicjava.ch05.design.decorator.finery;


public class Main {
    public static void main(String[] args) {
        Person pkmer = new Person("Pkmer");

        TShirts tShirts = new TShirts();
        BigTrouser bigTrouser = new BigTrouser();
        Sneakers sneakers = new Sneakers();
        
        System.out.println("---------第一种装扮---------------");
        tShirts.decorator(pkmer);
        bigTrouser.decorator(tShirts);
        sneakers.decorator(bigTrouser);
        sneakers.show();


        System.out.println("---------第二种装扮---------------");
        LeatherShoes leatherShoes = new LeatherShoes();
        Tie tie = new Tie();
        Suit suit = new Suit();

        leatherShoes.decorator(pkmer);
        tie.decorator(leatherShoes);
        suit.decorator(tie);
        suit.show();
    }
}
