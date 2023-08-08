package designPattern.行为型.Observer.baseObserver;

/**
 * 同步阻塞、异步非阻塞、进程内、进程间的实现方式
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Message message);
}
