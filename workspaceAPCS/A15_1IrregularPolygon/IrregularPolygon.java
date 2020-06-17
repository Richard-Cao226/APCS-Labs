import java.awt.geom.*;
import java.util.*;
import gpdraw.*;

/**
 * TODO Write a one-sentence summary of your class here.
 * TODO Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 *
 * @author  Richard Cao
 * @version 11/6
 *
 * @author  Period - 3
 * @author  Assignment - TODO Assignment Name
 * 
 * @author  Sources - TODO list collaborators
 */
public class IrregularPolygon
{
    private DrawingTool pen;
    private ArrayList<Point2D.Double> myPolygon;

    //constuctors
    /**
     * Constructor
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }

    // public methods
    /**
     * add a point
     * @param aPoint point to add
     */
    public void add( Point2D.Double aPoint )
    {
        myPolygon.add(aPoint);
    }

    /**
     * calculate perimeter
     * @return sum the perimeter
     */
    public double perimeter()
    {
        if (myPolygon.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < myPolygon.size(); i++) {
            if (i < myPolygon.size() - 1) {
                sum += Math.sqrt(Math.pow(myPolygon.get(i).getX() - myPolygon.
                    get(i + 1).getX(), 2) + Math.pow(myPolygon.get(i).getY() - 
                    myPolygon.get(i + 1).getY(), 2));
            }
            else {
                sum += Math.sqrt(Math.pow(myPolygon.get(i).getX() - myPolygon.
                        get(0).getX(), 2) + Math.pow(myPolygon.get(i).getY() - 
                        myPolygon.get(0).getY(), 2));
            }
            
        }
        return sum;
    }

    /**
     * calculate area
     * @return sum the area
     */
    public double area()
    {
        if (myPolygon.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < myPolygon.size(); i++) {
            if (i < myPolygon.size() - 1) {
                sum += myPolygon.get(i).getX() * myPolygon.get(i + 1).getY();
                sum -= myPolygon.get(i).getY() * myPolygon.get(i + 1).getX();
            }
            else {
                sum += myPolygon.get(i).getX() * myPolygon.get(0).getY();
                sum -= myPolygon.get(i).getY() * myPolygon.get(0).getX();
            }
        }
        return Math.abs(sum / 2);
    }

    /**
     * draw the polygon
     */
    public void draw()
    {
        if (myPolygon.isEmpty()) {
            return;
        }
        pen.up();
        pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
        pen.down();
        for (int i = 1; i < myPolygon.size(); i++) {
            pen.move(myPolygon.get(i).getX(), myPolygon.get(i).getY());
        }
        pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
    }
}
