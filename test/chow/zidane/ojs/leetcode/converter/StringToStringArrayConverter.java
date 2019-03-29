package chow.zidane.ojs.leetcode.converter;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToStringArrayConverter extends SimpleArgumentConverter {

    @Override
    public List<String> convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
        return o instanceof String && List.class.isAssignableFrom(aClass) ? Arrays.asList(((String) o).split("\\s*,\\s*")) : null;
    }
}
