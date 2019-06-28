package chow.zidane.ojs.leetcode.converters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class ToStringArrayConverter extends SimpleArgumentConverter {

    @Override
    public Object convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
        if (o instanceof String) {
            String s = ((String) o);

            if (List.class.isAssignableFrom(aClass)) {
                if (s.length() == 0) {
                    return Collections.emptyList();
                }
                return Arrays.asList(s.split("\\s*,\\s*"));
            }

            if (String[].class.isAssignableFrom(aClass)) {
                if (s.length() == 0) {
                    return new String[0];
                }
                return s.split("\\s*,\\s*");
            }
        }
        throw new IllegalArgumentException("only supports converting from String to List");
    }
}
