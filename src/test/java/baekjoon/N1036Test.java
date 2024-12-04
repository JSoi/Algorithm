package baekjoon;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class N1036Test {
    @Test
    void testSingleCharacterToDecimal() {
        int result = 10;
        for (char c = 'A'; c <= 'Z'; c++, result++) {
            int res = N1036.fromBase36ToDecimal(String.valueOf(c)).intValue();
            assertThat(res).isEqualTo(result);
        }
    }

    @Test
    void testDecimalCharacterToDecimal() {
        int result = 0;
        for (char c = '0'; c <= '9'; c++, result++) {
            int res = N1036.fromBase36ToDecimal(String.valueOf(c)).intValue();
            assertThat(res).isEqualTo(result);
        }
    }

    @Test
    void testConvertDecimalToBase36Str() {
        int decimal = 36;
        String res = N1036.fromDecimalToBase36(BigDecimal.valueOf(decimal));
        assertThat(res).isEqualTo("10");
        //
        decimal = 71;
        res = N1036.fromDecimalToBase36(BigDecimal.valueOf(decimal));
        assertThat(res).isEqualTo("1Z");
    }

    @Test
    void testBase36ToDecimal(){
        String base36 = "500";
        int expected = 6480;
        int result = N1036.fromBase36ToDecimal(base36).intValue();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testCharacterConvert() {
        assertThat(N1036.to36Char(35)).isEqualTo('Z');
        assertThat(N1036.to36Char(0)).isEqualTo('0');
    }

}