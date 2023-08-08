package designPattern.行为型.Observer.EventBus;

import com.sun.crypto.provider.Preconditions;
import designPattern.行为型.Observer.baseObserver.Observer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObserverAction {
    private Observer target;
    private Method method;

    public ObserverAction(Observer target, Method method) {
        if (target != null) this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
