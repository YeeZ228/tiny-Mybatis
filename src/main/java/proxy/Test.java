package proxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar();
        Star starProxy = MyProxy.createProxy(bigStar);
        System.out.println(starProxy.sing("good"));
    }
}
