package chow.zidane.ojs.leetcode;

import java.util.List;

class StackBoxes {

    static int findMaxHeight(final List<Box> boxes) {
        boxes.sort((o1, o2) -> o2.height - o1.height);

        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            final int height = boxes.get(i).height;
            final int topHeight = findTopHeight(boxes, i);
            maxHeight = Math.max(maxHeight, height + topHeight);
        }
        return maxHeight;
    }

    private static int findTopHeight(final List<Box> boxes, final int i) {
        if (i == boxes.size() - 1) {
            return 0;
        }
        int maxHeight = 0;
        for (int j = i + 1; j < boxes.size(); j++) {
            if (canPut(boxes, i, j)) {
                final int height = boxes.get(j).height;
                final int topHeight = findTopHeight(boxes, j);
                maxHeight = Math.max(maxHeight, height + topHeight);
            }
        }
        return maxHeight;
    }

    private static boolean canPut(final List<Box> boxes, final int i, final int j) {
        final Box bottom = boxes.get(i);
        final Box top = boxes.get(j);

        return bottom.height >= top.height && bottom.width >= top.width;
    }
}
