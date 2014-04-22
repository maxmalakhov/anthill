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
public class App 
{
    final static Logger logger = LoggerFactory.getLogger(App.class);

    public void run() {
        WorkerFactory factory = new WorkerFactory<Target>(FactoryType.DEFAULT);
        factory.submit(new Worker<Target>());
    }
}
