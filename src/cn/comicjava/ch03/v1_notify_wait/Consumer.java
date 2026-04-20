package cn.comicjava.ch03.v1_notify_wait;

import java.util.ArrayList;
import java.util.List;

public class Consumer extends Thread {
    private List<Coffee> coffees;
    private int count;
    private Object monitor;

    public Consumer(String name, int count, List<Coffee> coffees) {
        super(name);
        this.count = count;
        this.coffees = coffees;
        this.monitor = coffees;
    }

    @Override
    public void run() {
        int drinked = 1;
        while (count >= drinked) {
            synchronized (monitor) {
                while (coffees.isEmpty()) {
                    try {
                        System.out.printf("店内繁忙，%s 等待中%n", this.getName());
                        monitor.wait();
                    } catch (InterruptedException e) {
                    }
                }

                Coffee coffee = this.coffees.remove(0);
                System.out.printf("%s 畅饮第(%d)杯 %s%n", this.getName(), drinked, coffee.name());
                drinked++;
                monitor.notifyAll();
            }

            try {
                // 模拟不要那么快
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        System.out.printf("%s 离店%n", this.getName());
    }
}
