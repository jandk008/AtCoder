package chow.zidane.ojs.leetcode.converters;

import chow.zidane.ojs.leetcode.Box;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class ToBoxConverter extends SimpleArgumentConverter {

    @Override
    protected List<Box> convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
        if (o instanceof String && List.class.isAssignableFrom(aClass)) {
            return Arrays.stream(((String) o).split("\\s*\\|\\s*")).map(s -> convertToBox(s.split(","))).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("only convert String to int[]");
        }
    }

    private Box convertToBox(final String[] s) {
        return new Box(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
    }
}
