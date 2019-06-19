package chow.zidane.ojs.leetcode.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToStringListConverter extends SimpleArgumentConverter {

    @Override
    public List<String> convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
        if (o instanceof String && List.class.isAssignableFrom(aClass)) {
            String s = ((String) o);
            return s.length() == 0 ? Collections.emptyList() : Arrays.asList(s.split("\\s*,\\s*"));
        }
        throw new IllegalArgumentException("only supports converting from String to List");
    }
}
