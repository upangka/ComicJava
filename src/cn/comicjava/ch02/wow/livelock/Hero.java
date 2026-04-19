package cn.comicjava.ch02.wow.livelock;

public class Hero {
    private String name;
    private boolean isThirsty;

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
		while (this.isThirsty()) {
			if (beer.getOwner() != this) {
				continue;
			} else if (drinkingPartner.isThirsty()) {
				System.out.printf("%s: \"你先喝吧，我的朋友！\"%n", name);
				beer.setOwner(drinkingPartner);
			} else {
				beer.drink();
				this.isThirsty = false;
				System.out.printf("%s: \"真好喝！\"%n", name);
				beer.setOwner(drinkingPartner);
			}
		}
	}

    
}
