package us.devcloud.anthill.core;

import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 20/04/14.
 */
public class Target {
    private final List<MyInt> array;

    public Target() {
        array = Arrays.asList(new MyInt(1), new MyInt(2), new MyInt(3));
    }

    public List<MyInt> getArray() {
        return array;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for(MyInt i : array) {
            result.append(","+i.getI());
        }
        return result.toString();
    }
}
