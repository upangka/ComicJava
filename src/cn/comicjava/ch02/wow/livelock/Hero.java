package cn.comicjava.ch02.wow.livelock;

import java.util.Random;

public class Hero {
    private String name;
    private boolean isThirsty;
    private Random random = new Random();

    public Hero(String name) {
        this.name = name;
        this.isThirsty = true;
    }

    public String getName() {
        return name;
    }

    public boolean isThirsty() {
		return isThirsty;
	}


    public void drink(Beer beer, Hero drinkingPartner) {
        int courtesyCount = 0;  // 礼让次数计数
		while (this.isThirsty()) {
			if (beer.getOwner() != this) {
				continue;
			} else if (drinkingPartner.isThirsty()) {
                if (courtesyCount < 3) {
                    // 礼让不超过 3 次
                    System.out.printf("%s: \"你先喝吧，我的朋友！\"%n", name);
                    beer.setOwner(drinkingPartner);
                    courtesyCount++;
                } else {
                    // 礼让 3 次后强制喝
                    System.out.printf("%s: \"不客气了，我先喝！\"%n", name);
                    beer.drink();
                    this.isThirsty = false;
                    System.out.printf("%s: \"真好喝！\"%n", name);
                    beer.setOwner(drinkingPartner);
                }
			} else {
				beer.drink();
				this.isThirsty = false;
				System.out.printf("%s: \"真好喝！\"%n", name);
				beer.setOwner(drinkingPartner);
			}
		}
	}

    
}
