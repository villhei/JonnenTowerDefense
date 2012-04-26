/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author jonnaira
 */
public class GameTest {
    
    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    DefaultMonster inRangeMonster;
    DefaultMonster notInRangeMonster;
    DefaultTower testTower;
    Game game;
    
    @Before 
    public void setUp() throws InterruptedException {
        game = new Game();
        
        inRangeMonster = new DefaultMonster(5);
        inRangeMonster.setLocation(1, 2);
        
        notInRangeMonster = new DefaultMonster(5);
        notInRangeMonster.setLocation(1, 8);
        
        testTower = new DefaultTower(5, 5, 5, new Location(1,1));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testIfInRange() {
        assertTrue(game.isInRange(inRangeMonster, testTower));
        
        assertFalse(game.isInRange(notInRangeMonster, testTower));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
