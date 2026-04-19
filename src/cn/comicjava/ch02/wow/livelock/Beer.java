package cn.comicjava.ch02.wow.livelock;

public class Beer {
	private Hero owner;

	public Beer(Hero hero) {
		this.owner = hero;
	}

	public synchronized Hero getOwner() {
		return owner;
	}

	public synchronized void setOwner(Hero hero) {
		this.owner = hero;
	}

	public synchronized void drink() {
		System.out.printf("%s 喝了啤酒\n", owner.getName());
	}
}