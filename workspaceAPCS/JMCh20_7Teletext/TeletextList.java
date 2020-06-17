// Implements the list of messages for teletext

import java.awt.Graphics;

/**
 * Teletext Class
 * @author Richard
 * @version 1/8
 */
public class TeletextList
{
    private ListNode2<String> heading;
    private ListNode2<String> topNode;

    /**
     * Creates a circular list of headlines. First creates a circular list
     * with one node, "Today's headlines:". Saves a reference to that node in
     * heading. Adds a node holding an empty string before heading and another
     * node holding an empty string after heading. Appends all the strings
     * from headlines to the list, after the blank line that follows heading,
     * preserving their order. Sets topNode equal to heading.
     * 
     * @param headlines  Strings to add to circular list
     */
    public TeletextList(String[] headlines)
    {
        ListNode2<String> headline = new ListNode2<String>("Today's headlines:",
            null, null);
        heading = headline;
        ListNode2<String> space1 = new ListNode2<String>("", null, heading);
        heading.setPrevious(space1);
        ListNode2<String> space2 = new ListNode2<String>("", heading, space1);
        heading.setNext(space2);
        space1.setPrevious(space2);
        ListNode2<String> node = space2;
        for (int i = 0; i < headlines.length; i++) {
            ListNode2<String> add = new ListNode2<String>(headlines[i], node, 
                space1);
            node.setNext(add);
            space1.setPrevious(add);
            node = add;
        }
        space1.setPrevious(node);
        topNode = heading;
    }

    /**
     * Inserts a node with msg into the headlines list after the blank /line
     * that follows heading.
     * 
     * @param msg  String to add to headlines list
     */
    public void insert(String msg)
    {
        ListNode2<String> prev = heading.getNext();
        ListNode2<String> next = heading.getNext().getNext();
        ListNode2<String> newNode = new ListNode2<String>(msg, prev, next);
        prev.setNext(newNode);
        next.setPrevious(newNode);
    }

    /**
     * Deletes the node that follows topNode from the headlines list, unless
     * that node happens to be heading or the node before or after heading that
     * holds a blank line.
     */
    public void delete()
    {
        if (topNode.getNext() != heading && topNode.getNext() != heading.
            getPrevious() && topNode.getNext() != heading.getNext()) {
            ListNode2<String> nextNode = topNode.getNext().getNext();
            topNode.setNext(nextNode);
            nextNode.setPrevious(topNode);
        }
    }

    /**
     * Scrolls up the headlines list, advancing topNode to the next node.
     */
    public void scrollUp()
    {
        topNode = topNode.getNext();
    }

    /*
     * Adds a new node with msg to the headlines list before a given node.
     * Returns a referenece to the added node.
     */
    /**
     * Add Before
     * @param node before
     * @param msg to add
     * @return added node
     */
    private ListNode2<String> addBefore( ListNode2<String> node, String msg )
    {
        ListNode2<String> newNode = new ListNode2<String>(msg, node.
            getPrevious(), node);
        node.getPrevious().setNext(newNode);
        node.setPrevious(newNode);
        return newNode;
    }

    /*
     * Adds a new node with msg to the headlines list after a given node.
     * Returns a referenece to the added node.
     */
    /**
     * Add After
     * @param node after
     * @param msg to add
     * @return added node
     */
    private ListNode2<String> addAfter(ListNode2<String> node, String msg)
    {
        ListNode2<String> newNode = new ListNode2<String>(msg, node, node.
            getNext());
        node.setNext(newNode);
        node.getNext().setPrevious(newNode);
        return newNode;
    }

    /*
     * Removes a given node from the list.
     */
    /**
     * remove
     * @param node to remove
     */
    private void remove(ListNode2<String> node)
    {
        ListNode2<String> prev = node.getPrevious();
        ListNode2<String> next = node.getNext();
        prev.setNext(next);
        next.setPrevious(prev);
    }

    /*
     * Draws nLines headlines in g, starting with topNode at x, y and
     * incrementing y by lineHeight after each headline.
     */
    /**
     * Draw
     * @param g graphics
     * @param x coordinate
     * @param y coordinate
     * @param lineHeight height of line
     * @param nLines number of lines
     */
    public void draw( Graphics g, int x, int y, int lineHeight, int nLines )
    {
        ListNode2<String> node = topNode;
        for ( int k = 1; k <= nLines; k++ )
        {
            g.drawString( node.getValue(), x, y );
            y += lineHeight;
            node = node.getNext();
        }
    }

    /**
     * Returns a string representation of this TeletextList.
     * 
     * @return a string representation of this TeletextList.
     */
    public String toString()
    {
        String str = getClass().getName() + "[";
        String separator = "";

        for ( ListNode2<String> node = heading; node.getNext() != heading;
              node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}
