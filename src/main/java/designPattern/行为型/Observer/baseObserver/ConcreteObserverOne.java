package designPattern.行为型.Observer.baseObserver;

public class ConcreteObserverOne implements Observer {

    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverOne update.");
    }
}
