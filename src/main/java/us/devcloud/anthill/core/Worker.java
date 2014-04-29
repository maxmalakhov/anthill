package us.devcloud.anthill.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by max on 19/04/14.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Worker implements Runnable {

    final static Logger logger = LoggerFactory.getLogger(Worker.class);

    private String name;
    private WorkerType type;
    private WorkerState state;
    private Target target;

    public Worker() {

    }

    public Worker(String name, Target target) {
        this.name = name;
        this.target = target;
    }

    @Override
    public void run() {
        logger.debug("Started");
        try {
            for(MyInt i : target.getArray()) {
                handle(i);
            }
        } catch (InterruptedException e) {
            logger.debug("Interrupted", e.getMessage());
        }
        logger.debug("Stopped");

    }

    private void handle(MyInt i) throws InterruptedException {
        Thread.sleep(10);

//        ReadWriteLock lock = new ReentrantReadWriteLock();
//        lock.readLock().lock();
//        lock.readLock().unlock();

//        synchronized (i) { // locked a Single element of the collection for operations
        synchronized (target) { // locked the Entire collection for operations

//          synchronized (target) { // locked the object for Read operations only
            read(i); // read operation
//        }
//          synchronized (target) { // locked the object for Write operations
            update(i); // write operation
        }
    }

    private void read(MyInt i) {
        logger.debug(name+" ~ "+i.getI());
    }

    private void update(MyInt i) {
        i.setI(i.getI()*i.getI());
    }

    public String getName() {
        return name;
    }

    public Worker addTarget(Target target) {
        this.target = target;
        return this;
    }

    public Worker addName(String name) {
        this.name = name;
        return this;
    }
}
