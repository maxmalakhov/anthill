package us.devcloud.anthill.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by max on 20/04/14.
 */
public class WorkerFactory {

    final static Logger logger = LoggerFactory.getLogger(WorkerFactory.class);


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

    public void start(Worker worker) {
        try {
            executor.execute(new Thread(worker, worker.getName()));
        } catch (Exception e) {
            logger.debug("Interrupted",e.getMessage());
        }
    }

    public void stop() {
        executor.shutdown();
    }
}
