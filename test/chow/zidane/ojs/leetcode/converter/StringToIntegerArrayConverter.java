package chow.zidane.ojs.leetcode.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToIntegerArrayConverter extends SimpleArgumentConverter {

    private static final Pattern PATTERN = Pattern.compile("\\s*,\\s*");

    @Override
    protected Object convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
        if (o instanceof String) {
            String input = (String) o;
            if (int[].class.isAssignableFrom(aClass)) {
                if (input.length() == 0) return new int[0];
                return PATTERN.splitAsStream(input)
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            if (List.class.isAssignableFrom(aClass)) {
                if (input.length() == 0) return Collections.emptyList();
                return PATTERN.splitAsStream(input)
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());
            }

            if (int[][].class.isAssignableFrom(aClass)) {
                if (input.length() == 0) return new int[0][];
                return Arrays.stream((input).split("\\s*\\|\\s*"))
                        .map(s -> Arrays.stream(s.split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray())
                        .toArray(int[][]::new);
            }
        }
       throw new IllegalArgumentException("only convert String to int[] or int[][]");
    }
}
