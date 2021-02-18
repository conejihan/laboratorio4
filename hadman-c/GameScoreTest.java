

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class GameScoreTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GameScoreTest
{
    
    /**
     * Default constructor for test class GameScoreTest
     */
    public GameScoreTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    @Test
    public void deberiaEstarEntre0y100() {
        OriginalScore n = new OriginalScore();
        boolean test = false;
        int prueba = n.calculateScore(0, 1, 5);
        if (prueba <= 100 && prueba >= 0) {
            test = true;
        }
        assertEquals(true, test);
    }
    @Test
    public void noDeberiaSerMenora0() {
         OriginalScore n = new OriginalScore();
        boolean test = false;
        int prueba = n.calculateScore(0, 1, 5);
        if (prueba >= 0) {
            test = true;
        }
        assertEquals(true, test);
    }
    @Test
    public void deberiaEstarEntre0y500() {
        PowerScore p = new PowerScore();
        boolean test = false;
        int prueba = p.calculateScore(1, 0, 5);
        if (prueba <= 500 && prueba >= 0) {
            test = true;
        }
        assertEquals(true, test);
    }
    
  
}
