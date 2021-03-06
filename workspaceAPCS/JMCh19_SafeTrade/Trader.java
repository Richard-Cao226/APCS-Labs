import java.lang.reflect.*;
import java.util.*;

/**
 * Represents a stock trader.
 * @author Richard Cao rcao266
 * @version 4/10/2020
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;
    private String screenName;
    private String password;
    private TraderWindow myWindow;
    private Queue<String> mailbox;

    // TODO complete class
    /**
     * Trader constructor
     * @param brokerage for trader
     * @param name of trader
     * @param pswd of trader
     */
    public Trader(Brokerage brokerage, String name, String pswd) {
        this.brokerage = brokerage;
        screenName = name;
        password = pswd;
        mailbox = new PriorityQueue<String>();
    }
    /**
     * returns trader name
     * @return trader name
     */
    public String getName() {
        return screenName;
    }
    /**
     * returns trader password
     * @return trader password
     */
    public String getPassword() {
        return password;
    }
    /**
     * compares two traders
     * @param other trader
     * @return difference between names
     */
    public int compareTo(Trader other) {
        return screenName.compareToIgnoreCase(other.getName());
    }
    /**
     * determines if traders are equal
     * @param other trader
     * @return if traders are equal
     */
    public boolean equals(Object other) {
        return screenName.equalsIgnoreCase(((Trader)other).getName());
    }
    /**
     * opens trader window
     */
    public void openWindow() {
        TraderWindow window = new TraderWindow(this);
        myWindow = window;
        while (!mailbox.isEmpty()) {
            myWindow.showMessage(mailbox.remove());
        }
    }
    /**
     * does trader have messages
     * @return does trader have messages
     */
    public boolean hasMessages() {
        return !mailbox.isEmpty();
    }
    /**
     * receives message
     * @param msg to receive
     */
    public void receiveMessage(String msg) {
        mailbox.add(msg);
        if (myWindow != null) {
            while (!mailbox.isEmpty()) {
                myWindow.showMessage(mailbox.remove());
            }
        }
    }
    /**
     * gets stock quote
     * @param symbol of stock
     */
    public void getQuote(String symbol) {
        brokerage.getQuote(symbol, this);
    }
    /**
     * places trade order
     * @param order to place
     */
    public void placeOrder(TradeOrder order) {
        brokerage.placeOrder(order);
    }
    /**
     * quits trade window
     */
    public void quit() {
        brokerage.logout(this);
        myWindow = null;
    }


    //
    // The following are for test purposes only
    //
    /**
     * returns mailbox for trader
     * @return mailbox for trader
     */
    protected Queue<String> mailbox()
    {
        return mailbox;
    }
    
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                if ( field.getType().getName().equals( "Brokerage" ) ) {
                    str += separator + field.getType().getName() + " "
                        + field.getName();
                }
                else {
                    str += separator + field.getType().getName() + " "
                        + field.getName() + ":" + field.get( this );
                }
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
