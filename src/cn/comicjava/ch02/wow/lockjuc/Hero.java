package cn.comicjava.ch02.wow.lockjuc;

import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class Hero {
    private String name;
    private Lock lock = new ReentrantLock();

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean meetAt(Hero hero) {
        boolean iSayWeMeetAtHisPlace = false;
        boolean heSaysWeMeetAtHisPlace = false;
        try {
            iSayWeMeetAtHisPlace = lock.tryLock();
            heSaysWeMeetAtHisPlace = hero.getLock().tryLock();
        } finally {
            if (!(iSayWeMeetAtHisPlace && heSaysWeMeetAtHisPlace)) {
                if (iSayWeMeetAtHisPlace) {
                    lock.unlock();
                }
                if (heSaysWeMeetAtHisPlace) {
                    hero.getLock().unlock();
                }
            }
        }
        // ⚠️ 注意：返回 true 时锁仍在持有状态，需要调用者释放
        return iSayWeMeetAtHisPlace && heSaysWeMeetAtHisPlace;
    }

    public Lock getLock() {
        return lock;
    }

    public void unlockBoth(Hero hero) {
        try {
            hero.getLock().unlock(); // 先释放 hero 的锁
        } finally {
            lock.unlock(); // 最后释放自己的锁
        }
    }

    public void visit(Hero hero) {
        if (meetAt(hero)) {
            try {
                System.out.printf("(%s)%s: \"我们在%s那儿见面，那我就先出发了。\"%n", getThreadName(), this.getName(), hero.getName());
                hero.receiveVisit(this);
            } finally {
                unlockBoth(hero);
            }
        } else {
            System.out.printf("(%s)%s: \"抱歉，我在忙，下次再约吧。\"%n", getThreadName(), this.getName());
        }

    }

    public void receiveVisit(Hero hero) {
        System.out.printf("(%s)%s: \"我们在我家见面了。\"%n", getThreadName(), this.getName());
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }
}
