package us.devcloud.anthill.tool;

/**
 * Created by max on 01/05/14.
 */
public enum ByteUnit {
    BYTE("b", 1),
    KILO_BYTE("Kb", 1024),
    MEGA_BYTE("Mb", 1024*1024);

    private String name;
    private int scale;

    ByteUnit(String name, int scale) {
        this.name = name;
        this.scale = scale;
    }

    public long convert(long value) {
        return value / this.scale;
    }

    public boolean check(long value) {
        return value > this.scale;
    }

    public String format(long value) {
        return this.convert(value) + " " +this.name;
    }

    public static String auto(long value) {
        if(MEGA_BYTE.check(value)) {
            return MEGA_BYTE.format(value);
        } else if(KILO_BYTE.check(value)) {
            return KILO_BYTE.format(value);
        } else {
            return BYTE.format(value);
        }
    }
}
