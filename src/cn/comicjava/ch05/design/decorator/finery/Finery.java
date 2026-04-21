package cn.comicjava.ch05.design.decorator.finery;

public class Finery implements ICharacter{
    private ICharacter component;

    public void decorator(ICharacter component) {
        this.component = component;
    }

    @Override
    public void show() {
        if(component != null){
            component.show();
        }
    }
}
