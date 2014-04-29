package us.devcloud.anthill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import us.devcloud.anthill.config.SpringConfig;
import us.devcloud.anthill.core.*;
import us.devcloud.anthill.network.Sender;

/**
 * Hello world!
 *
 */
public class App {

    final static Logger logger = LoggerFactory.getLogger(App.class);
    final static ApplicationContext spring = new AnnotationConfigApplicationContext(SpringConfig.class);

    public static Sender sender() {
        return spring.getBean(Sender.class);
    }
    public static Engine engine() {
        return spring.getBean(Engine.class);
    }
    public static Worker worker() {
        return spring.getBean(Worker.class);
    }
    public static Worker worker(String name, Target target) {
        return (Worker) spring.getBean(Worker.class.getName(), name, target);
    }

    public static void main(String[] args) {
        App app = new App();
        app.engine().run();
    }
}
