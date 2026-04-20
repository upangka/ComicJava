package cn.comicjava.ch03.v1_notify_wait;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Coffee> coffees = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            new Consumer("消费者(%d)".formatted(i), 2, coffees).start();
        }
        new Producer("瑞幸",3, coffees).start();
    }
}
