package chow.zidane.ojs.leetcode.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class ToDoubleArrayConverter extends SimpleArgumentConverter {

    private static final Pattern PATTERN = Pattern.compile("\\s*,\\s*");

    @Override
    protected Object convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
        if (o instanceof String) {
            String input = (String) o;
            if (double[].class.isAssignableFrom(aClass)) {
                if (input.length() == 0) return new int[0];
                return PATTERN.splitAsStream(input)
                        .mapToDouble(Double::parseDouble)
                        .toArray();
            }

            if (List.class.isAssignableFrom(aClass)) {
                if (input.length() == 0) return Collections.emptyList();
                return PATTERN.splitAsStream(input)
                        .mapToDouble(Double::parseDouble)
                        .boxed()
                        .collect(Collectors.toList());
            }

            if (double[][].class.isAssignableFrom(aClass)) {
                if (input.length() == 0) return new double[0][];
                return Arrays.stream((input).split("\\s*\\|\\s*"))
                        .map(s -> Arrays.stream(s.split("\\s*,\\s*")).mapToDouble(Double::parseDouble).toArray())
                        .toArray(double[][]::new);
            }
        }
       throw new IllegalArgumentException("only convert String to double[], double[][] or List<Double>");
    }
}
