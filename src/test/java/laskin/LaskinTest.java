package laskin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LaskinTest extends AbstractParent {
    private Laskin laskin;
    private final double DELTA = 0.001;

    @BeforeEach
    void setUp() {
        super.initTestSystem(); // Optional, demonstrates calling parent method explicitly
        laskin = new Laskin();
        laskin.currentON(); // Ensure the calculator is "on" before each test
    }

    @AfterEach
    void tearDown() {
        super.cleanTestSystem(); // Optional, demonstrates calling parent method explicitly
        laskin.currentOFF(); // Optionally "turn off" the calculator after each test if you decide to implement state changes in currentOFF method later
    }

    @Test
    void testAdd() {
        laskin.add(5);
        assertEquals(5, laskin.getResult(), DELTA);
    }

    @Test
    void testSubtract() {
        laskin.add(10); // Set to 10 first
        laskin.subtract(2);
        assertEquals(8, laskin.getResult(), DELTA);
    }

    @Test
    void testProduct() {
        laskin.add(10); // Set to 10 first
        laskin.product(2);
        assertEquals(20, laskin.getResult(), DELTA);
    }

    @Test
    void testDivide() {
        laskin.add(20); // Set to 20 first
        laskin.divide(4);
        assertEquals(5, laskin.getResult(), DELTA);
    }

    @Test
    void testDivideByZero() {
        laskin.add(10); // Set to 10 first
        assertThrows(IllegalArgumentException.class, () -> laskin.divide(0), "Dividing by zero should throw IllegalArgumentException.");
    }

    @Test
    void testDivideByZeroThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> laskin.divide(0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }


    @Test
    void testSquare() {
        laskin.square(4);
        assertEquals(16, laskin.getResult(), DELTA);
    }

    @Test
    void testSquareRoot() {
        laskin.squareroot(16);
        assertEquals(4, laskin.getResult(), DELTA);
    }

    @Test
    void testSquareRootNegative() {
        assertThrows(IllegalArgumentException.class, () -> laskin.squareroot(-16), "Square root of a negative should throw IllegalArgumentException.");
    }

    @Test
    void testSetZero() {
        laskin.add(10); // Non-zero state
        laskin.setZero();
        assertEquals(0, laskin.getResult(), DELTA);
    }

    @Test
    void testCurrentONOFF() {
        laskin.setZero();
        laskin.add(100); // Change state
        laskin.currentOFF();
        laskin.currentON(); // This should reset to 0 if currentON resets the state
        assertEquals(0, laskin.getResult(), DELTA, "currentON should reset the result to 0.");
    }

    // Add parameterized tests for square method to ensure coverage for various inputs
    @ParameterizedTest
    @CsvSource({
            "2, 4",
            "3, 9",
            "-3, 9",
            "0, 0"
    })
    void testSquareParameterized(double input, double expected) {
        laskin.square(input);
        assertEquals(expected, laskin.getResult(), DELTA, "Square operation failed for input: " + input);
    }
}
