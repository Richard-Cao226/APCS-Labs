import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

/**
 *  A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 *  turn. A jumper can remove another jumper by jumping on them.
 * 
 *  @author  Richard Cao, Soma Tummala
 *  @version 10/23
 *  @author  Period: 3
 *  @author  Assignment: GridWorld_Part3_Jumper
 * 
 *  @author  Sources:
 */
public class Jumper extends Bug implements Edible
{
    /**
     * moves Jumper by two spaces
     */
    public void move() {
        Grid<Actor> grid = getGrid();
        if (grid == null) {
            return;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection()).
            getAdjacentLocation(getDirection());
        if (grid.isValid(next)) {
            moveTo(next);
        }
        else {
            removeSelfFromGrid();
        }
    }

    /**
     * checks if Jumper can move 2 spaces
     * @return boolean can Jumper move
     */
    public boolean canMove() {
        Grid<Actor> grid = getGrid();
        if (grid == null) {
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection()).
            getAdjacentLocation(getDirection());
        if (!grid.isValid(next)) {
            return false;
        }
        Actor neighbor = grid.get(next);
        return neighbor == null || neighbor instanceof Edible;
    }

    /**
     * runs for every step
     */
    public void act() {
        if (canMove()) {
            move();
        }
        else {
            turn();
        }
        
    }
}