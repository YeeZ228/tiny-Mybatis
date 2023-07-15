package proxy;

public class BigStar implements Star{
    public String sing(String song) {
        return "唱" + song;
    }

    public void dance() {
        System.out.println("跳舞");
    }
}
