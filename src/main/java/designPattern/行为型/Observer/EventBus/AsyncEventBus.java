package designPattern.行为型.Observer.EventBus;

import java.util.concurrent.Executor;

public class AsyncEventBus extends EventBus{

    public AsyncEventBus(Executor executor) {
        super(executor);
    }

}
