package us.devcloud.anthill.core;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

/**
 * Created by max on 29/04/14.
 */
@Component
@Configurable
public class WorkerFactory implements FactoryBean<Worker> {

    @Override
    public Worker getObject() throws Exception {
        return new Worker();
    }

    @Override
    public Class<?> getObjectType() {
        return Worker.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
