package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidParenthesesTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "()", "(()())", "()[]{}", "(())", "{[]}"})
    void testTrueCase(String s) {
        assertTrue(ValidParentheses.is(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"(}", ")(", "[([)", "()[{]}", "([)]", "(", "(){"})
    void testFalseCase(String s) {
        assertFalse(ValidParentheses.is(s));
    }

}
