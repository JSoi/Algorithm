package programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class L72414Test {
    L72414 test;
    @BeforeEach
    void init() {
        test = new L72414();
    }

    @Test
    void testTimeToSecond() {
        long second = test.toSecond(1, 1, 1);
        assertThat(second).isEqualTo(3661);
    }

    @Test
    void testStrToSecond() {
        String input = "01:01:01";
        long expected = 3661;
        assertThat(test.strToNum(input)).isEqualTo(expected);
    }
    @Test
    void testNumToStr(){
        long input = 3661;
        String expected = "01:01:01";
        assertThat(test.numToStr(input)).isEqualTo(expected);
    }
}