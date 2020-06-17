import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;

/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Richard Cao, Soma Tummala
 *  @version 10/23
 *  @author  Period: 3
 *  @author  Assignment: GridWorld_Part3_Jumper
 *
 *  @author  Sources:
 */
public class JumperRunner
{
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        Jumper jumper = new Jumper();
        jumper.setColor( Color.ORANGE );
        world.add( new Location( 5, 5 ), jumper );
        world.show();
    }
}