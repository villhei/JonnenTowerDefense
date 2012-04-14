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
public class LocationTest {
    
    public LocationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void isLocationCorrect() {
        Location loc = new Location(5,1);
        assertEquals(5, loc.getHorPos());
        assertEquals(1, loc.getVerPos());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
