package chow.zidane.ojs.leetcode;

import java.util.HashSet;
import java.util.Set;

class EscapeLargeMaze {

    private static final int MAX = 1000000;

    static boolean isPossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2) return true;
        Set<Long> blocks = new HashSet<>();
        for (int[] b : blocked) {
            blocks.add(hash(b));
        }

        return isEscapable(blocks, source, target, source, new HashSet<>())
                && isEscapable(blocks, target, source, target, new HashSet<>());
    }

    private static boolean isEscapable(Set<Long> blocked, int[] source, int[] target, int[] current, Set<Long> visited) {
        int x = current[0];
        int y = current[1];
        long hashCode = hash(current);

        if (x < 0 || y < 0 || x == MAX || y == MAX || blocked.contains(hashCode) || visited.contains(hashCode)) {
            return false;
        }
        visited.add(hashCode);

        if (x == target[0] && y == target[1] || Math.abs(x - source[0]) > blocked.size() || Math.abs(y - source[1]) > blocked.size()) {
            return true;
        }

        return isEscapable(blocked, source, target, new int[] {x + 1, y}, visited)
                || isEscapable(blocked, source, target, new int[] {x, y + 1}, visited)
                || isEscapable(blocked, source, target, new int[] {x - 1, y}, visited)
                || isEscapable(blocked, source, target, new int[] {x, y - 1}, visited);
    }

    private static long hash(int[] position) {
        return position[0] * MAX + position[1];
    }

}
