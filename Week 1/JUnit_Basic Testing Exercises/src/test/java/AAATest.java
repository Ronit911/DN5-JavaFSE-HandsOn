import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AAATest {

    private int testValue;

    @Before
    public void setup() {
        // Setup method
        testValue = 5;
        System.out.println("Setting up the test... testValue initialized to " + testValue);
    }

    @Test
    public void testAAAPattern() {
        // Arrange
        int expectedResult = 10;
        int incrementBy = 5;

        // Act
        testValue += incrementBy;

        // Assert
        assertEquals(expectedResult, testValue);
    }

    @After
    public void teardown() {
        // Teardown method
        testValue = 0;
        System.out.println("Tearing down the test... testValue reset to " + testValue);
    }
}
