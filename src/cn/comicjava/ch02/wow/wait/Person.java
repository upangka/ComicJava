package cn.comicjava.ch02.wow.wait;

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void rushToOccupySeat(Library library) {
        synchronized (library) {
            while (!library.isOpen()) {
                System.out.printf("未到9:00,%s还没开门,%s等待中%n", library.getName(), this.getName());
                try {
                    library.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        this.success();
    }

    protected abstract void success();
}
