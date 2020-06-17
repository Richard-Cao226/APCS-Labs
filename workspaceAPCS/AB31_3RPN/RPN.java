import java.util.*;

/**
 * RPN Calculator
 *
 * @author TODO Your Name
 * @version TODO Date
 * @author Period: TODO Your Period
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: TODO List Collaborators
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );
    
    private Stack<Integer> myStack;
    private Queue<String> myQ;

    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }
    
    /**
     *  **** Used for testing - Do Not Remove ***
     *  
     *  Constructs an RPN Calculator and then redirects the Scanner input
     *  to the supplied string.
     *  
     *  @param console  replaces console input
     */
    public RPN(String console)
    {
        this();
        scan = new Scanner( console );
    }

    /**
     * TODO Write your method description here.
     */
    public void calculate()
    {
        while (scan.hasNextLine()) {
            String in = scan.nextLine();
            if (in.equals("q") || in.equals("Q")) {
                while (myQ.peek() != null) {
                    System.out.print(myQ.remove() + " ");
                }
                System.out.println("= " + myStack.pop());
            }
            else if (in.equals("+")) {
                add();
            }
            else if (in.equals("-")) {
                subtract();
            }
            else if (in.equals("*")) {
                multiply();
            }
            else if (in.equals("/")) {
                divide();
            }
            else {
                int num = Integer.parseInt(in);
                myQ.add("" + num);
                myStack.push(num);
            }
        }
    }
    
    public void add() {
        myQ.add("+");
        int add1 = myStack.pop();
        int add2 = myStack.pop();
        int sum = add1 + add2;
        myStack.push(sum);
    }
    
    public void subtract() {
        myQ.add("-");
        int sub1 = myStack.pop();
        int sub2 = myStack.pop();
        int diff = sub2 - sub1;
        myStack.push(diff);
    }
    
    public void multiply() {
        myQ.add("*");
        int mult1 = myStack.pop();
        int mult2 = myStack.pop();
        int prod = mult1 * mult2;
        myStack.push(prod);
    }
    
    public void divide() {
        myQ.add("/");
        int div1 = myStack.pop();
        int div2 = myStack.pop();
        int quot = div2 / div1;
        myStack.push(quot);
    }

    // TODO: additional helper methods 
    
    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args  command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}