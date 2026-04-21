package cn.comicjava.ch05.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyFactory {
    public static IGiveGift createProxy(SchoolGirl mm, Pursuit gg) {
        return (IGiveGift) Proxy.newProxyInstance(
                gg.getClass().getClassLoader(),
                gg.getClass().getInterfaces(),
                new InvocationHandler() {
                    private int count = 0;
                    private final String name = "戴励";

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        count++;
                        System.out.printf("%s帮%s:%n", this.name, gg.getName());
                        Object result = method.invoke(gg, args);
                        if (count >= 3) {
                            System.out.printf("%s: 对不起好兄弟(%s),我爱上了她(%s)%n",
                                    this.name, gg.getName(), mm.name());
                        }
                        return result;
                    }
                });
    }
}
