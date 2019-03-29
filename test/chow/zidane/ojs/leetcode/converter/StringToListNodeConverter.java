package chow.zidane.ojs.leetcode.converter;

import chow.zidane.ojs.leetcode.ListNode;
import java.util.Arrays;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.platform.commons.util.StringUtils;

public class StringToListNodeConverter extends SimpleArgumentConverter {

    @Override
    protected ListNode convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
        if (o instanceof String && ListNode.class.isAssignableFrom(aClass)) {
            final String s = (String) o;
            if (StringUtils.isBlank(s)) {
                return null;
            }
            final ListNode[] nodes = Arrays.stream(s.split(","))
                    .mapToInt(Integer::parseInt)
                    .mapToObj(ListNode::new)
                    .toArray(ListNode[]::new);
            for (int i = 0; i < nodes.length - 1; i++) {
                nodes[i].next = nodes[i + 1];
            }
            return nodes[0];
        } else {
            throw new IllegalArgumentException("Only be able to convert ListNode");
        }
    }
}
