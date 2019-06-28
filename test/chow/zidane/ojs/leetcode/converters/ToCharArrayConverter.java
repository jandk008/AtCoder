package chow.zidane.ojs.leetcode.converters;

import java.util.Arrays;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class ToCharArrayConverter extends SimpleArgumentConverter {

    @Override
    public Character[][] convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
        return Arrays.stream(((String) o).split(","))
                .map(s -> s.chars().mapToObj(c -> (char) c).toArray(Character[]::new))
                .toArray(Character[][]::new);
    }
}
