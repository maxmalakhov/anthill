package us.devcloud.anthill.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.devcloud.anthill.App;

/**
 * Created by max on 29/04/14.
 */
@Component
public class Engine {
    final static Logger logger = LoggerFactory.getLogger(Engine.class);

    public void run() {
        ThreadFactory factory = new ThreadFactory(FactoryType.FIXED);
        Target target = new Target();
        logger.debug(target.toString());
        try {

//            factory.start(new Worker("worker1", target));
//            factory.start(new Worker("worker2", target));
//            factory.start(new Worker("worker3", target));
//            factory.start(App.worker("worker1", target));
//            factory.start(App.worker("worker2", target));
//            factory.start(App.worker("worker3", target));
            factory.start(App.worker().addName("worker1").addTarget(target));
            factory.start(App.worker().addName("worker2").addTarget(target));
            factory.start(App.worker().addName("worker3").addTarget(target));
            factory.stop();

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            logger.debug(target.toString());
        }
    }
}
