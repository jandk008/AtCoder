package chow.zidane.ojs.leetcode;

import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
    static boolean validate(final Character[][] board) {
        final Set<String> checked = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!checked.add("checked" + c + "row" + i) ||
                            !checked.add("checked" + c + "column" + j) ||
                            !checked.add("checked" + c + "block" + i / 3 + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
