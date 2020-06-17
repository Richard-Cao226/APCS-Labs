import info.gridworld.actor.*;
import info.gridworld.grid.*;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *  Jumper tests:.
 *  test01 - jumper next to edge of grid - should turn
 *  test02 - jumper 2 from edge of grid - should turn
 *  test03 - jumper 3 from edge of grid - should jump
 *  test04 - jumper 2 from other jumper - should jump
 *  test05 - jumper 1 from other jumper - should jump over
 *  test06 - jumper 2 from edge of grid - should jump and no flower
 *  test07 - TODO Description
 *
 *  @author  Richard Cao, Soma Tummala
 *  @version 10/23
 *
 *  @author  Period: 3
 *  @author  Assignment - GridWorld Part 3 Jumper
 *
 *  @author  Sources:
 */
public class JUJumperTest
{
    /*
     * Variables used by the test methods.
     */
    private Grid<Actor> grid;
    private ActorWorld world;
    private Jumper jumper1;
    private Jumper jumper2;

    /**
     * Invoked before each test to instantiate the objects
     * used for every test.
     */
    @Before public void initialize()
    {
        grid = new BoundedGrid<Actor>(8, 8);
        world = new ActorWorld(grid);
        jumper1 = new Jumper();
        jumper2 = new Jumper();
    }

    /**
     * test01 - jumper next to edge of grid - should turn
     */
    @Test
    public void jumperNextToEdgeOfGridShouldTurn()
    {
        Location loc = new Location(0, 3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * test02 - jumper 2 from edge of grid - should turn.
     */
    @Test
    public void jumper2FromEdgeOfGridShouldTurn()
    {
        Location loc = new Location(1, 3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * test03 - jumper 3 from edge of grid - should jump
     */
    @Test
    public void jumper3FromEdgeOfGridShouldJump()
    {
    	Location loc = new Location(2, 3);
    	Location newLoc = new Location(0,3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(newLoc, jumper1, Location.NORTH));
    }

    /**
     * test04 - jumper 2 from other jumper - should jump
     */
    @Test
    public void jumper2FromOtherJumperShouldJump()
    {
    	Location loc = new Location(2, 3);
    	Location newLoc = new Location(0,3);
        world.add(loc, jumper1);
        world.add(newLoc, jumper2);
        jumper1.act();

        assertTrue(testOccupied(newLoc, jumper1, Location.NORTH));
        assertTrue(jumper2.getLocation() == null);
    }

    /**
     * test05 - jumper 1 from other jumper - should jump over
     */
    @Test
    public void jumper1FromOtherJumperShouldJumpOver()
    {
    	Location loc = new Location(2, 3);
    	Location loc2 = new Location(1,3);
    	Location newLoc = new Location(0,3);
        world.add(loc, jumper1);
        world.add(loc2, jumper2);
        jumper1.act();

        assertTrue(testOccupied(newLoc, jumper1, Location.NORTH));
        assertTrue(testOccupied(loc2, jumper2, Location.NORTH));
    }

    /**
     * test06 - jumper 2 from edge of grid - should jump and no flower
     */
    @Test
    public void jumper2FromEdgeOfGridShouldJumpAndNoFlower()
    {
    	Location loc = new Location(2, 3);
    	Location midLoc = new Location(1,3);
    	Location newLoc = new Location(0,3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(newLoc, jumper1, Location.NORTH));
        assertTrue(testEmpty(loc));
        assertTrue(testEmpty(midLoc));
    }

    /**
     * test07 - TODO Description
     */
    @Test
    public void test07()
    {
        
    }

    /**
     * Test helper method to test for empty location.
     *
     * @param loc null location if empty
     * @return true if all assertions pass
     */
    private boolean testEmpty(Location loc)
    {
        Actor empty = grid.get( loc );
        assertNull( "<<<<< " + loc + " should be empty. >>>>>", empty );

        return true;
    }

    /**
     * Test helper method to test that object is in a location, and has
     * a consistent loc, and direction dir.
     *
     * @param loc location that should be occupied
     * @param a   actor that should be in location loc
     * @param dir direction this actor should be facing
     * @return true if all assertions pass
     */
    private boolean testOccupied(Location loc, Actor a, int dir)
    {
        Actor found = grid.get( loc );
        assertSame( "<<<<< " + loc + " should contain the actor. >>>>>",
            a, found );
        assertEquals( "<<<<< Loc should be " + loc + " >>>>>",
            loc, found.getLocation() );
        assertEquals( "<<<<< Dir should be " + dir + " >>>>>",
            dir, found.getDirection() );

        return true;
    }
}