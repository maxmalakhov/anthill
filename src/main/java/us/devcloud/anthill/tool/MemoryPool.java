package us.devcloud.anthill.tool;

/**
 * Created by max on 01/05/14.
 */
public class MemoryPool {

    public static long current() {
        // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory();
        return heapSize;
    }

    public static long capacity() {
        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.
        // Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();
        return heapMaxSize;
    }

    public static long free() {
        // Get amount of free memory within the heap in bytes. This size will increase
        // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory();
        return heapFreeSize;
    }
}
