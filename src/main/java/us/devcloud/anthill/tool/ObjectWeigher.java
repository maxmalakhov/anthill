package us.devcloud.anthill.tool;

import java.lang.instrument.Instrumentation;

/**
 * Created by max on 01/05/14.
 */
public class ObjectWeigher {
    private static Instrumentation inst;

    public static void premain(String args, Instrumentation _inst) {
        inst = _inst;
    }

    public static long weigh(Object o) {
        return inst.getObjectSize(o);
    }
}
