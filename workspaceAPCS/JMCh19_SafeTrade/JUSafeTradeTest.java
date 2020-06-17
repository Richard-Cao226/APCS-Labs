import java.text.DecimalFormat;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 * SafeTrade tests:
 *   TradeOrder
 *   PriceComparator
 *   Trader
 *   Brokerage
 *   StockExchange
 *   Stock
 *
 * @author TODO Name of principal author
 * @author TODO Name of group member
 * @author TODO Name of group member
 * @version TODO date
 * @author Assignment: JM Chapter 19 - SafeTrade
 * 
 * @author Sources: TODO sources
 *
 */
public class JUSafeTradeTest
{
    // --Test TradeOrder
    /**
     * TradeOrder tests:
     *   TradeOrderConstructor - constructs TradeOrder and then compare toString
     *   TradeOrderGetTrader - compares value returned to constructed value
     *   TradeOrderGetSymbol - compares value returned to constructed value
     *   TradeOrderIsBuy - compares value returned to constructed value
     *   TradeOrderIsSell - compares value returned to constructed value
     *   TradeOrderIsMarket - compares value returned to constructed value
     *   TradeOrderIsLimit - compares value returned to constructed value
     *   TradeOrderGetShares - compares value returned to constructed value
     *   TradeOrderGetPrice - compares value returned to constructed value
     *   TradeOrderSubtractShares - subtracts known value & compares result
     *     returned by getShares to expected value
     */
    private String symbol = "GGGL";
    private boolean buyOrder = true;
    private boolean marketOrder = true;
    private int numShares = 123;
    private int numToSubtract = 24;
    private double price = 123.45;

    @Test
    public void tradeOrderConstructor()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        String toStr = to.toString();

        assertTrue( "<< Invalid TradeOrder Constructor >>",
                    toStr.contains( "TradeOrder[Trader trader:null" )
                        && toStr.contains( "java.lang.String symbol:" + symbol )
                        && toStr.contains( "boolean buyOrder:" + buyOrder )
                        && toStr.contains( "boolean marketOrder:" + marketOrder )
                        && toStr.contains( "int numShares:" + numShares )
                        && toStr.contains( "double price:" + price ) );
    }
    
    @Test
    public void TradeOrderToString()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertNotNull( to.toString() );
    }

    @Test
    public void tradeOrderGetTrader()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertNull( "<< TradeOrder: " + to.getTrader() + " should be null >>",
                    to.getTrader() );
    }

    @Test
    public void tradeOrderGetSymbol()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertEquals( "<< TradeOrder: " + to.getTrader() + " should be "
            + symbol + " >>", symbol, to.getSymbol() );
    }

    @Test
    public void tradeOrderIsBuy()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );

        assertTrue( "<< TradeOrder: " + to.isBuy() + " should be " + buyOrder
            + " >>", to.isBuy() );
    }

    @Test
    public void tradeOrderIsSell()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertFalse( "<< TradeOrder: " + to.isSell() + " should be "
            + !buyOrder + " >>", to.isSell() );
    }

    @Test
    public void tradeOrderIsMarket()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertTrue( "<< TradeOrder: " + to.isMarket() + " should be "
            + marketOrder + " >>", to.isMarket() );
    }

    @Test
    public void tradeOrderIsLimit()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );

        assertFalse( "<< TradeOrder: " + to.isLimit() + " should be "
            + !marketOrder + ">>", to.isLimit() );
    }

    @Test
    public void tradeOrderGetShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertTrue( "<< TradeOrder: " + to.getShares() + " should be "
            + numShares + ">>", numShares == to.getShares()
            || ( numShares - numToSubtract ) == to.getShares() );
    }

    @Test
    public void tradeOrderGetPrice()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertEquals( "<< TradeOrder: " + to.getPrice() + " should be " + price
            + ">>", price, to.getPrice(), 0.0 );
    }

    @Test
    public void tradeOrderSubtractShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        to.subtractShares( numToSubtract );
        assertEquals( "<< TradeOrder: subtractShares(" + numToSubtract
            + ") should be " + ( numShares - numToSubtract ) + ">>", numShares
            - numToSubtract, to.getShares() );
    }
    
    // --Test TraderWindow Stub
    @Test
    public void traderWindowConstructor()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
    }

    @Test
    public void traderWindowShowMessage()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
        tw.showMessage( null );
    }

    //  --Test PriceComparator
    @Test
    public void priceComparatorConstructor() {
        PriceComparator pc = new PriceComparator();
        assertNotNull(pc);
    }
    
    @Test
    public void priceComparatorCompare() {
        double price2 = 10.45;
        PriceComparator pc = new PriceComparator();
        Trader trader = new Trader(new Brokerage(new StockExchange()), "trader", "pswd");
        TradeOrder to1 = new TradeOrder(trader, symbol, buyOrder, marketOrder, numShares, price);
        TradeOrder to2 = new TradeOrder(trader, symbol, buyOrder, marketOrder, numShares, price);
        assertEquals("<< PriceComparator: when both are market orders compare(order1, order2) should return 0", 0, pc.compare(to1, to2));
        to2 = new TradeOrder(trader, symbol, buyOrder, !marketOrder, numShares, price);
        assertEquals("<< PriceComparator: when only first order is market order compare(order1, order2) should return -1", -1, pc.compare(to1,  to2));
        to1 = new TradeOrder(trader, symbol, buyOrder, !marketOrder, numShares, price);
        to2 = new TradeOrder(trader, symbol, buyOrder, marketOrder, numShares, price);
        assertEquals("<< PriceComparator: when only second order is market order compare(order1, order2) should return 1", 1, pc.compare(to1, to2));
        to2 = new TradeOrder(trader, symbol, buyOrder, !marketOrder, numShares, price2);
        assertEquals("<< PriceComparator: when both are limit orders and ascending, order1 price is " + price + " and order2 price is " + price2 + ", compare(order1, order2) should return " + (int)(Math.round((to1.getPrice() - to2.getPrice())*100)), (int)(Math.round((to1.getPrice() - to2.getPrice())*100)), pc.compare(to1,  to2));
        PriceComparator pc1 = new PriceComparator(false);
        assertEquals("<< PriceComparator: when both are limit orders and descending, order1 price is " + price + " and order2 price is " + price2 + ", compare(order1, order2) should return " + (int)(Math.round((to2.getPrice() - to1.getPrice())*100)), (int)(Math.round((to2.getPrice() - to1.getPrice())*100)), pc1.compare(to1,  to2));
    }
    @Test
    public void priceComparatorToString() {
        PriceComparator pc = new PriceComparator();
        assertNotNull(pc.toString());
    }
    
    // --Test Trader
    private String screenName = "name";
    private String password = "pswd";
    private Brokerage brokerage = new Brokerage(new StockExchange());
    private TraderWindow myWindow;
    private Queue<String> mailbox = new PriorityQueue<String>();
    
    @Test
    public void traderConstructor() {
        Trader trader = new Trader(brokerage, screenName, password);
        assertNotNull(trader);
    }
    @Test
    public void traderGetName() {
        Trader trader = new Trader(brokerage, screenName, password);
        assertEquals( "<< Trader: getName() should be " + screenName, screenName, trader.getName());
    }
    @Test
    public void traderGetPassword() {
        Trader trader = new Trader(brokerage, screenName, password);
        assertEquals( "<< Trader: getPassword() should be " + password, password, trader.getPassword());
    }
    @Test
    public void traderCompareTo() {
        Trader trader1 = new Trader(brokerage, screenName, password);
        Trader trader2 = new Trader(brokerage, screenName, password);
        assertEquals("<< Trader: compareTo() should be 0 when both traders have same name", 0, trader1.compareTo(trader2));
    }
    @Test
    public void traderEquals() {
        Trader trader1 = new Trader(brokerage, screenName, password);
        Trader trader2 = new Trader(brokerage, screenName, password);
        assertTrue("<< Trader: equals() should be true when traders have same name", trader1.equals(trader2));
    }
    @Test
    public void traderToString() {
        Trader t = new Trader(brokerage, screenName, password);
        assertNotNull(t.toString());
    }
    
    
    // --Test Brokerage
    private Map<String, Trader> traders = new TreeMap<String, Trader>();;
    private Set<Trader> loggedTraders = new TreeSet<Trader>();;
    private StockExchange exchange = new StockExchange();
    private String screenName1 = "name";
    private String password1 = "pswd";
    @Test
    public void brokerageConstructor() {
        Brokerage brokerage = new Brokerage(exchange);
        assertNotNull(brokerage);
    }
    @Test
    public void brokerageAddUser() {
        Brokerage brokerage = new Brokerage(exchange);
        assertEquals("<< Brokerage: addUser() should be -1 when name too short", -1, brokerage.addUser("s", password));
        assertEquals("<< Brokerage: addUser() should be -1 when name too long", -1, brokerage.addUser("sssssssssss", password));
        assertEquals("<< Brokerage: addUser() should be -2 when password too short", -2, brokerage.addUser("good", "s"));
        assertEquals("<< Brokerage: addUser() should be -2 when password too long", -2, brokerage.addUser("good", "sssssssssss"));
        brokerage.addUser(screenName1, password1);
        assertEquals("<< Brokerage: addUser() should be -3 when already has user", -3, brokerage.addUser(screenName1, password1));
        assertEquals("<< Brokerage: addUser() should be 0 when successful", 0, brokerage.addUser("some", password));
    }
    @Test
    public void brokerageLogin() {
        Brokerage brokerage = new Brokerage(exchange);
        assertEquals("<< Brokerage: login() should be -1 when user not added", -1, brokerage.login(screenName, password));
        brokerage.addUser(screenName, password);
        assertEquals("<< Brokerage: login() should be -2 when wrong password", -2, brokerage.login(screenName, "wrong"));
        brokerage.login(screenName, password);
        assertEquals("<< Brokerage: login() should be -3 when already logged", -3, brokerage.login(screenName, password));
        brokerage.addUser("name1", "pass");
        assertEquals("<< Brokerage: login() should be 0 when successful", 0, brokerage.login("name1", "pass"));
    }
    @Test
    public void brokerageLogout() {
        Brokerage brokerage = new Brokerage(exchange);
        brokerage.addUser(screenName, password);
        brokerage.login(screenName, password);
        brokerage.logout(new Trader(brokerage, screenName, password));
        assertEquals("<< Brokerage: login() should be 0 if trader was logged out", 0, brokerage.login(screenName, password));
    }
    @Test
    public void brokerageToString() {
        Brokerage brokerage = new Brokerage(exchange);
        assertNotNull(brokerage.toString());
    }
    
    // --Test StockExchange
    @Test
    public void stockExchangeConstructor() {
        StockExchange exchange = new StockExchange();
        assertNotNull(exchange);
    }
    @Test
    public void stockExchangeGetQuote() {
        StockExchange exchange = new StockExchange();
        String symbol = "GGGL";
        assertEquals("<< StockExchange: getQuote() should be " + symbol + " not found when stock not listed", symbol + " not found", exchange.getQuote(symbol));
    }
    @Test
    public void stockExchangeToString() {
        StockExchange se = new StockExchange();
        assertNotNull(se.toString());
    }
    
    // --Test Stock
    private String stockSymbol = "GGGL";
    private String companyName = "Giggle.com";
    private double loPrice = 50, hiPrice = 50, lastPrice = 50;
    private int volume = 0;
    private PriorityQueue<TradeOrder> buyOrders = new PriorityQueue<TradeOrder>(11, new PriceComparator(false)), sellOrders = new PriorityQueue<TradeOrder>(11, new PriceComparator());
    public static DecimalFormat money = new DecimalFormat( "0.00" );
    
    @Test
    public void stockConstructor() {
        Stock stock = new Stock(stockSymbol, companyName, 50);
        assertNotNull(stock);
    }
    @Test
    public void stockGetQuote() {
        Stock stock = new Stock(stockSymbol, companyName, 50);
        assertEquals("<< Stock: if buy and sell are empty", companyName + " (" + stockSymbol + ")\nPrice: " + 
                money.format(lastPrice) + " hi: " + money.format(hiPrice) + 
                " lo: " + money.format(loPrice) + " vol: " + volume + "\n" + "Ask: none " + "Bid: none", stock.getQuote());
        Trader trader = new Trader(new Brokerage(new StockExchange()), "name", "password");
        String symbol = "GGGL";
        int numShares = 5;
        double price = 10;
        TradeOrder to = new TradeOrder(trader, symbol, true, true, numShares, price);
        stock.placeOrder(to);
        assertEquals("<< Stock: if sell is empty", companyName + " (" + stockSymbol + ")\nPrice: " + 
                money.format(lastPrice) + " hi: " + money.format(hiPrice) + 
                " lo: " + money.format(loPrice) + " vol: " + volume + "\n" + "Ask: none " + "Bid: " + to.getPrice() + " size: " + to.getShares(), stock.getQuote());
        
    }
    @Test
    public void stockToString() {
        Stock s = new Stock(stockSymbol, companyName, 50);
        assertNotNull(s.toString());
    }

    
    // Remove block comment below to run JUnit test in console
/*
    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( JUSafeTradeTest.class );
    }
    
    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "JUSafeTradeTest" );
    }
*/
}

