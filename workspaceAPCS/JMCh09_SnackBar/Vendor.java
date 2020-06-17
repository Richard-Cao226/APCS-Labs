import java.lang.reflect.*;

/**
   This class implements a vendor that sells one kind of item.
   A vendor carries out sales transactions.

   @author  TODO Your Name
   @version TODO Date

   @author Period - TODO Your Period
   @author Assignment - Java Methods Ch09 - SnackBar

   @author Sources - TODO list collaborators
 */
public class Vendor
{
    // Fields:
    private int stock;
    private int price;
    private int deposit;
    private int change;
    private static double totalSales;

    //  Constructor
    //  Parameters:
    //    int price of a single item in cents
    //    int number of items to place in stock
    /**
     * constructor
     * @param price of product
     * @param stock initial
     */
    public Vendor(int price, int stock) 
    {
        this.price = price;
        this.stock = stock;
        deposit = 0;
        change = 0;
    }

    //  Sets the quantity of items in stock.
    //  Parameters:
    //    int number of items to place in stock
    //  Return:
    //    None
    /**
     * sets stock
     * @param stock to set
     */
    public void setStock(int stock)
    {
        this.stock = stock;
    }

    //  Returns the number of items currently in stock.
    //  Parameters:
    //    None
    //  Return:
    //    int number of items currently in stock
    /**
     * return stock
     * @return stock
     */
    public int getStock()
    {
        return stock;
    }

    //  Adds a specified amount (in cents) to the deposited amount.
    //  Parameters:
    //    int number of cents to add to the deposit
    //  Return:
    //    None
    /**
     * adds money
     * @param money to add
     */
    public void addMoney(int money)
    {
        if (stock > 0) {
            deposit += money;
        }
    }

    //  Returns the currently deposited amount (in cents).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current deposit
    /**
     * returns deposit
     * @return deposit
     */
    public int getDeposit()
    {
        return deposit;
    }

    //  Implements a sale.  If there are items in stock and
    //  the deposited amount is greater than or equal to
    //  the single item price, then adjusts the stock
    //  and calculates and sets change and returns true;
    //  otherwise refunds the whole deposit (moves it into change)
    //  and returns false.
    //  Parameters:
    //    None
    //  Return:
    //    boolean successful sale (true) or failure (false)
    /**
     * makes sale
     * @return whether sale succeeded or not
     */
    public boolean makeSale()
    {
        if (stock > 0 && deposit >= price) {
            stock--;
            change = deposit - price;
            totalSales += price / 100.0;
            deposit = 0;
            return true;
        }
        else {
            change = deposit;
            deposit = 0;
            return false;
        }
    }

    //  Returns and zeroes out the amount of change (from the last
    //  sale or refund).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current change
    /**
     * return change
     * @return change
     */
    public int getChange()
    {
        return change;
    }
    
    /**
     * returns total sales
     * @return totalSales
     */
    public static double getTotalSales() {
        double temp = totalSales;
        totalSales = 0;
        return temp;
    }

    /**
        Intended only for debugging.
        
        <p>A generic toString implementation that uses reflection to print
        names and values of all fields <em>declared in this class</em>.
        Note that superclass fields are left out of this implementation.</p>
        
        @return  a string representation of this Vendor.
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
                str += separator + field.getName() + ":" + field.get( this );
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
