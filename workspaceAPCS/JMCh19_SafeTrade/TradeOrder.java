import java.lang.reflect.*;

/**
 * Represents a buy or sell order for trading a given number of shares of a
 * specified stock.
 * @author Richard Cao rcao266
 * @version 4/10/2020
 */
public class TradeOrder
{
    private Trader trader;
    private String symbol;
    private boolean buyOrder;
    private boolean marketOrder;
    private int numShares;
    private double price;

    // TODO complete class
    /**
     * TradeOrder constructor
     * @param trader for order
     * @param symbol of stock
     * @param buyOrder is buy
     * @param marketOrder is market
     * @param numShares number of shares
     * @param price of stock
     */
    public TradeOrder(Trader trader, String symbol, boolean buyOrder, 
        boolean marketOrder, int numShares, double price) {
        this.trader = trader;
        this.symbol = symbol;
        this.buyOrder = buyOrder;
        this.marketOrder = marketOrder;
        this.numShares = numShares;
        this.price = price;
    }
    /**
     * returns trader
     * @return trader for order
     */
    public Trader getTrader() {
        return trader;
    }
    /**
     * returns symbol
     * @return symbol for stock
     */
    public String getSymbol() {
        return symbol;
    }
    /**
     * returns whether or not it is buy order
     * @return whether or not it is buy order
     */
    public boolean isBuy() {
        return buyOrder;
    }
    /**
     * returns whether or not it is sell order
     * @return whether or not it is sell order
     */
    public boolean isSell() {
        return !buyOrder;
    }
    /**
     * is market price
     * @return is market price
     */
    public boolean isMarket() {
        return marketOrder;
    }
    /**
     * is limit price
     * @return is limit price
     */
    public boolean isLimit() {
        return !marketOrder;
    }
    /**
     * returns number of shares
     * @return number of shares
     */
    public int getShares() {
        return numShares;
    }
    /**
     * returns price of stock
     * @return price of stock
     */
    public double getPrice() {
        return price;
    }
    /**
     * subtracts shares
     * @param shares to subtract
     */
    public void subtractShares(int shares) {
        if (shares > numShares) {
            throw new IllegalArgumentException();
        }
        numShares -= shares;
    }

    //
    // The following are for test purposes only
    //
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this TradeOrder.
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
