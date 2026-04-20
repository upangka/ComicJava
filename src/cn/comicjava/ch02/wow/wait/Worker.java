package cn.comicjava.ch02.wow.wait;

public class Worker extends Person {

    public Worker(String name) {
        super(name);
    }
    
    @Override
    protected void success(){
        System.out.printf("%s: \"抢到座位了，打开电脑看看招聘/改改简历\"%n", this.getName());
    }
}
