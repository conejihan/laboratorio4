package hangman.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
        OriginallScore n = new OriginallScore();
        boolean test = false;
        int prueba = n.calculateScore(0, 1, 5);
        if (prueba <= 100 && prueba >= 0) {
            test = true;
        }
        assertEquals(true, test);
    }
    @Test
    public void noDeberiaSerMenora0() {
         OriginallScore n = new OriginallScore();
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