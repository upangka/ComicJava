package cn.comicjava.ch02.wow.join;

/**
 * 矮人
 */
public class Dwarf extends Hero{
    public Dwarf(String name) {
		super(name);
	}

	@Override
	public void chargeIntoBattle(Hero hero) {
		System.out.printf("%s: \"起——来——！！！！\"%n", hero.getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("【%s (有点晚)】: \"哈——欠，唉，早上好，我来了，我来了。\"%n", this.getName());
	}
}
