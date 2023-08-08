package designPattern.行为型.Observer.baseObserver;

public class Demo {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.registerObserver(new ConcreteObserverOne());
        concreteSubject.registerObserver(new ConcreteObserverTwo());
        concreteSubject.notifyObservers(new Message());
        concreteSubject.removeObserver(new ConcreteObserverTwo());
    }
}
