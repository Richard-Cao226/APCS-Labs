import info.gridworld.actor.Bug;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author  Period - TODO Your Period
   @author  Assignment - GridWorld Part 2, Exercise 2 - SpiralBug

   @author  Sources - TODO list collaborators
 */
public class SpiralBug extends Bug
{
    // TODO instance variables
	private int steps;
    private int sideLength;

    public SpiralBug( int n )
    {
        // TODO complete constructor
    	steps = 0;
        sideLength = n;
    }

    public void act()
    {
        // TODO complete act method
    	if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            sideLength++;
            steps = 0;
        }
    }
}