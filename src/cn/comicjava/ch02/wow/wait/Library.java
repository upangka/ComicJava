package cn.comicjava.ch02.wow.wait;

public class Library {
    private String name;
    private volatile boolean open = false;

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen(){
        return this.open;
    }

    public void setOpen(boolean open){
        this.open = open;
        if(open){
            System.out.printf("%s开馆了！！！%n",this.getName());
        }
    }
    
}