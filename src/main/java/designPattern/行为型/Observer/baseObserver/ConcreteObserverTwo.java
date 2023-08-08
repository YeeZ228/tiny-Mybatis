package designPattern.行为型.Observer.baseObserver;

public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo update.");
    }
}
