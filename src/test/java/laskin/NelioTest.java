package laskin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NelioTest {

    private final Laskin laskin = new Laskin();
    private final double DELTA = 0.001;

    @ParameterizedTest(name = "Square of {0} is {1}")
    @CsvSource({ "0, 0", "1, 1", "2, 4", "3, 9", "4, 16", "5, 25", "10, 100" })
    void testSquare(int number, int expected) {
        laskin.square(number);
        assertEquals(expected, laskin.getResult(), DELTA);
    }
}
