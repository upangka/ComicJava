package cn.comicjava.ch02.wow.join;

/**
 * 暗夜精灵
 */
public class NightElf extends Hero {
	public NightElf(String name) {
		super(name);
	}

	@Override
	public void chargeIntoBattle(Hero hero) {
        System.out.printf("%s: \"出发吧！进入战斗！\"%n", this.getName());
	}
}