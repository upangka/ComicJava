package cn.comicjava.ch03.v1_notify_wait;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread {
    private List<Coffee> coffees;
    private Object monitor;
    private int limit;
    private List<String> coffeeNames = new ArrayList<>() {
        {
            add("加浓美式");
            add("茉莉花香拿铁");
            add("橙C美式");
            add("葡萄冰萃美式");
            add("卡布奇诺");

        }
    };

    public Producer(String name, int limit, List<Coffee> coffees) {
        super(name);
        this.limit = limit;
        this.coffees = coffees;
        this.monitor = coffees;
    }

    @Override
    public void run() {
        int id = 0;
        while (true) {
            synchronized (this.monitor) {
                if (coffees.size() >= this.limit) {
                    try {
                        System.out.printf("--%s 生产太多了，进入休息---%n", this.getName());
                        monitor.wait();
                        System.out.printf("---%s 恢复，继续生产咖啡---%n", this.getName());
                    } catch (InterruptedException e) {
                    }
                }

                Coffee coffee = new Coffee(++id, coffeeNames.get(id % coffeeNames.size()));
                coffees.add(coffee);
                System.out.printf("%s 生产%s %n", this.getName(), coffee.name());
                monitor.notifyAll();
            }
        }

    }
}
