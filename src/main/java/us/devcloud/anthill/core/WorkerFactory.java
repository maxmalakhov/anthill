package us.devcloud.anthill.core;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by max on 20/04/14.
 */
public class WorkerFactory<T> {

    private final static int DEFAULT_CAPACITY = 5;
    private final ExecutorService executor;

    public WorkerFactory(FactoryType type) {
        switch (type) {
            case FIXED: executor = Executors.newFixedThreadPool(DEFAULT_CAPACITY); break;
            case SINGLE: executor = Executors.newSingleThreadExecutor(); break;
            case CACHED: executor = Executors.newCachedThreadPool(); break;
            case STEALING: executor = Executors.newWorkStealingPool(DEFAULT_CAPACITY); break;
            default: executor = Executors.newSingleThreadExecutor();
        }
    }

    public Future<T> submit(Callable<T> task) {
        Future<T> future = executor.submit(task);
        return future;
    }
}
