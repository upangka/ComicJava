package cn.comicjava.ch05.design.decorator;

public class Main {
    public static void main(String[] args) {
        Person pkmer = new Person("Pkmer");

        TShirts tShirts = new TShirts();
        tShirts.decorator(pkmer);

        BigTrouser bigTrouser = new BigTrouser();
        bigTrouser.decorator(tShirts);

        Sneakers sneakers = new Sneakers();
        sneakers.decorator(bigTrouser);
        
        System.out.println("---------第一种装扮---------------");
        sneakers.show();
    }
}
