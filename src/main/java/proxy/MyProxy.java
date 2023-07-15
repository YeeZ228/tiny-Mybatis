package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {
    public static Star createProxy(final BigStar bigStar) {
        final Star starProxy = (Star) Proxy.newProxyInstance(
                MyProxy.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("sing")) {
                            System.out.println("sing proxy");
                        } else {
                            System.out.println("dance proxy");
                        }
                        return method.invoke(bigStar, args);
                    }
                }
        );
        return starProxy;
    }
}
