package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class CourseScheduleTest {

    @ParameterizedTest
    @CsvSource( {"'2','1,0'","'4','0,1|1,2|1,3|'","'3','0,1|0,2|1,2'","'4','0,1|1,2|1,3|3,2'"})
    void isCompletable(int numberOfCourses, @ConvertWith(ToIntegerArrayConverter.class) int[][] schedule) {
        assertTrue(CourseSchedule.isCompletable(numberOfCourses, schedule));
    }

    @ParameterizedTest
    @CsvSource( {"'2','0,1|1,0'", "'3','0,2|1,2|2,0'","'4','0,1|1,2|1,3|3,0'","'3','1,0|1,2|0,1'"})
    void isNotCompletable(int numberOfCourses, @ConvertWith(ToIntegerArrayConverter.class) int[][] schedule) {
        assertFalse(CourseSchedule.isCompletable(numberOfCourses, schedule));
    }
}
