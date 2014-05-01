package us.devcloud.anthill.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.devcloud.anthill.tool.ByteUnit;
import us.devcloud.anthill.tool.MemoryPool;
import us.devcloud.anthill.tool.ObjectWeigher;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by max on 20/04/14.
 */
@Component
public class EventBus {
    final static Logger LOG = LoggerFactory.getLogger(EventBus.class);

    private final static int DEFAULT_CAPACITY = 100;

    private final static BlockingQueue queue = new ArrayBlockingQueue(DEFAULT_CAPACITY);

    EventBus() {
        LOG.debug("Current {}", ByteUnit.auto(MemoryPool.current()));
        LOG.debug("Queue {}", ByteUnit.auto(ObjectWeigher.weigh(queue)));
    }
}
