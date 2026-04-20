package cn.comicjava.ch02.wow.wait;

public class Student extends Person{

    public Student(String name) {
        super(name);
    }

    @Override
    protected void success(){
        System.out.printf("%s: \"抢到座位，开启备考心的一天\"%n",this.getName());
    }
    
}
