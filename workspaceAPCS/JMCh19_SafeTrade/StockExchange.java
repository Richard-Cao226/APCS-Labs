import java.lang.reflect.*;
import java.util.*;

/**
 * Represents a stock exchange. A <code>StockExchange</code> keeps a
 * <code>HashMap</code> of stocks, keyed by a stock symbol. It has methods to
 * list a new stock, request a quote for a given stock symbol, and to place a
 * specified trade order.
 * @author Richard Cao rcao266
 * @version 4/10/2020
 */
public class StockExchange
{
    private Map<String, Stock> listedStocks;
    
    // TODO complete class
    /**
     * StockExchange constructor
     */
    public StockExchange() {
        listedStocks = new HashMap<String, Stock>();
    }
    /**
     * adds stock to listed stocks
     * @param symbol of stock
     * @param name of company
     * @param price of stock
     */
    public void listStock(String symbol, String name, double price) {
        listedStocks.put(symbol, new Stock(symbol, name, price));
    }
    /**
     * gets quote for stock
     * @param symbol of stock
     * @return quote for stock
     */
    public String getQuote(String symbol) {
        if (!listedStocks.containsKey(symbol)) {
            return symbol + " not found";
        }
        else {
            return listedStocks.get(symbol).getQuote();
        }
    }
    /**
     * places trade order
     * @param order to place
     */
    public void placeOrder(TradeOrder order) {
        if (!listedStocks.containsKey(order.getSymbol())) {
            order.getTrader().receiveMessage(order.getSymbol() + " not found");
        }
        else {
            listedStocks.get(order.getSymbol()).placeOrder(order);
        }
    }

    
    //
    // The following are for test purposes only
    //
    /**
     * returns listed stocks
     * @return listed stocks
     */
    protected Map<String, Stock> getListedStocks()
    {
        return listedStocks;
    }
    
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this StockExchange.
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
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
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
