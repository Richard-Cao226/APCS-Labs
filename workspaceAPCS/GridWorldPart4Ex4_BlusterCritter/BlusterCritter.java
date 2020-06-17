import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

import java.awt.Color;

/**
 *  TODO Write a one-sentence summary of your class here
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Richard Cao
 *  @version 11/12
 *  @author  Period: 3
 *  @author  Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 *
 *  @author  Sources: TODO I received help from ...
 */
public class BlusterCritter extends Critter
{
    private int c;

    /**
     * Constructor
     * @param c courage
     */
    public BlusterCritter( int c )
    {
        this.c = c;
    }

    /**
     * TODO Write your method description here
     * <br />
     * Postcondition: The state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location loc = getLocation();
        for (int i = loc.getRow() - 2; i <= loc.getRow() + 2; i++) {
            for (int j = loc.getCol() - 2; j <= loc.getCol() + 2; j++) {
                Location check = new Location(i, j);
                if (gr.isValid(check) && !loc.equals(check)) {
                    if (gr.get(check) != null) {
                        actors.add(gr.get(check));
                    }
                }
            }
        }
        return actors;
    }

    /**
     * TODO Write your method description here
     * <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * 
     * @param actors the actors to be processed
     */
    public void processActors( ArrayList<Actor> actors )
    {
        int critters = 0;
        for (int i = 0; i < actors.size(); i++) {
            if (actors.get(i) instanceof Critter) {
                critters++;
            }
        }
        if (critters < c) {
            lighten();
        }
        else if (critters > c) {
            darken();
        }
    }

    /**
     * TODO Write your method description here
     */
    private void darken()
    {
        Color color = getColor();
        int red = (int) (color.getRed() * (1 - 0.05));
        int green = (int) (color.getGreen() * (1 - 0.05));
        int blue = (int) (color.getBlue() * (1 - 0.05));
        setColor(new Color(red, green, blue));
    }

    /**
     * TODO Write your method description here
     */
    private void lighten()
    {
        Color color = getColor();
        int red = (int) (color.getRed() * (1 + 0.05));
        int green = (int) (color.getGreen() * (1 + 0.05));
        int blue = (int) (color.getBlue() * (1 + 0.05));
        if (red > 255) {
            red = 255;
        }
        if (green > 255) {
            green = 255;
        }
        if (blue > 255) {
            blue = 255;
        }
        setColor(new Color(red, green, blue));
    }
}
