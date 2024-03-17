package laskin;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExtraTest {

    private static Laskin laskin;
    private final double DELTA = 0.001;

    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll - Executes once before all test methods in this class");
        laskin = new Laskin();
        laskin.currentON();
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll - Executed after all test methods in this class.");
        laskin.currentOFF();
        laskin = null; // Ensure cleanup
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - Executes before each test method in this class");
        laskin.setZero();
    }

    @Test
    @DisplayName("Testing square functionality with a positive number")
    void testSquarePositive() {
        laskin.square(5);
        assertEquals(25, laskin.getResult(), DELTA, "Square of 5 should be 25.");
    }

    @Test
    @DisplayName("Testing square root functionality with a positive number")
    void testSquareRootPositive() {
        laskin.squareroot(25);
        assertEquals(5, laskin.getResult(), DELTA, "Square root of 25 should be 5.");
    }

    @Test
    @DisplayName("Testing exception for square root of a negative number")
    void testSquareRootNegativeException() {
        assertThrows(IllegalArgumentException.class, () -> laskin.squareroot(-1), "Square root of a negative number should throw IllegalArgumentException.");
    }

    // Add any additional tests that might cover edge cases or missed functionalities.
}
