package cn.comicjava.ch05.design.decorator.finery;

public class Person implements ICharacter {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("装扮的" + name);
    }
}
