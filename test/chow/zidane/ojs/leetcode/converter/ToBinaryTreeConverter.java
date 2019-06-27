package chow.zidane.ojs.leetcode.converter;

import chow.zidane.ojs.leetcode.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class ToBinaryTreeConverter extends SimpleArgumentConverter {

    @Override
    protected TreeNode convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
        if (o instanceof String && TreeNode.class.isAssignableFrom(aClass)) {
            return decompressBinaryTree(((String) o).split("\\s*,\\s*"));
        } else {
            throw new IllegalArgumentException("only convert String to TreeNode");
        }
    }

    private TreeNode decompressBinaryTree(String[] strings) {
        if (strings.length == 0 || strings[0].equals("*")) {
            return null;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strings[index++]));
        queue.add(root);
        while (!queue.isEmpty() && index < strings.length) {
            TreeNode current = queue.poll();
            if (!strings[index].equals("*")) {
                TreeNode left = new TreeNode(Integer.parseInt(strings[index]));
                current.setLeft(left);
                queue.add(left);
            }
            if (++index == strings.length) {
                break;
            }
            if (!strings[index].equals("*")) {
                TreeNode right = new TreeNode(Integer.parseInt(strings[index]));
                current.setRight(right);
                queue.add(right);
            }
            index++;
        }

        return root;
    }
}
