package us.devcloud.anthill.buffer;

/**
 * Created by max on 20/04/14.
 */
public class BufferArray<E> {
    private final Object[] array;

    BufferArray(int capacity) {
        array = new Object[capacity<0?0:capacity];
    }
}
