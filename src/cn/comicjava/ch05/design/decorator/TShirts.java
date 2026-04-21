package cn.comicjava.ch05.design.decorator;

public class TShirts extends Finery{
    
    @Override
    public void show(){
        System.out.print("大T桖");
        super.show();
    }
}
