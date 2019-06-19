package chow.zidane.ojs.leetcode.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToIntegerListsConverter extends SimpleArgumentConverter {

    @Override
    protected List<List<Integer>> convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
        if (o instanceof String && List.class.isAssignableFrom(aClass)) {
            String input = (String) o;
            return input.length() == 0 ? Collections.emptyList() : Arrays.stream((input).split("\\s*\\|\\s*"))
                        .map(s -> Arrays.stream(s.split("\\s*,\\s*"))
                                .mapToInt(Integer::parseInt)
                                .boxed()
                                .collect(Collectors.toList()))
                        .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("only convert String to List<List<Integer>>");
    }
}
