package us.devcloud.anthill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.devcloud.anthill.core.FactoryType;
import us.devcloud.anthill.core.Target;
import us.devcloud.anthill.core.Worker;
import us.devcloud.anthill.core.WorkerFactory;

/**
 * Hello world!
 *
 */
public class App {

    final static Logger logger = LoggerFactory.getLogger(App.class);

    public void run() {
        WorkerFactory factory = new WorkerFactory(FactoryType.FIXED);
        Target target = new Target();
        logger.debug(target.toString());
        try {

            factory.start(new Worker("worker1", target));
            factory.start(new Worker("worker2", target));
            factory.start(new Worker("worker3", target));
            factory.stop();

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            logger.debug(target.toString());
        }
    }
}
