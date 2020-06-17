import info.gridworld.actor.Bug;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Richard Cao
   @version TODO 8/29

   @author  Period - TODO 3
   @author  Assignment - GridWorld Part 2, Random bugs - CircleBug

   @author  Sources - TODO list collaborators
 */
public class CircleBug extends Bug
{
    // TODO instance variables
	private int steps;
    private int sideLength;

    public CircleBug( int n )
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
            steps = 0;
        }
    }
}