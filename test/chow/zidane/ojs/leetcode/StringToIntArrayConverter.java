package chow.zidane.ojs.leetcode;

import java.util.regex.Pattern;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToIntArrayConverter extends SimpleArgumentConverter {

    private static final Pattern PATTERN = Pattern.compile("\\s*,\\s*");

    @Override
    protected Object convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
        if (o instanceof String && int[].class.isAssignableFrom(aClass)) {
            return PATTERN.splitAsStream((String) o).mapToInt(Integer::parseInt).toArray();
        } else {
            throw new IllegalArgumentException("only convert String to int[]");
        }
    }
}
