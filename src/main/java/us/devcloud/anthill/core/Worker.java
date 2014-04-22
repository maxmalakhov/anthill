package us.devcloud.anthill.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * Created by max on 19/04/14.
 */
public class Worker<T> implements Callable<T> {

    final static Logger logger = LoggerFactory.getLogger(Worker.class);

    private WorkerType type;
    private WorkerState state;

    @Override
    public T call() throws Exception {
        System.out.println("### Started");
        logger.debug("Started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.debug("Interrupted");
            System.out.println("### Interrupted");
        }
        logger.debug("Stopped");
        System.out.println("### Stopped");

        return null;
    }
}
