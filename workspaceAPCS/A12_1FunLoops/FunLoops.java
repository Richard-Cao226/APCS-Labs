/**
   A class to solve various loop problems
  
   @author  Richard Cao
   @version 9/20

   Period - 3
   Assignment - A12.1 - FunLoops

   Sources - Richard Cao
 */
public class FunLoops
{
    /**
     * 
     * @param n number of magic squares
     */
    public void magicsquare( int n )
    {
        System.out.println("Magic Squares");
        long sum = 0;
        long num = 1;
        long addTo = 1;
        for (int i = 1; i <= n; i++) {
            while (sum != num * num) {
                sum = (long)((1 + addTo) * (addTo / 2.0));
                if (sum > num * num) {
                    num++;
                }
                else {
                    addTo++;
                }
            }
            System.out.println(i + ": " + sum);
            num++;
        }
    }
    
    /**
     * 
     * @param a first number
     * @param b second number
     * @return least common multiple
     */
    public int lcm( int a, int b )
    {
        int aFact = 0;
        int bFact = 0;
        int gcf = 0;
        boolean gcfFound = false;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                aFact = a / i;
            }
            for (int j = 1; j <= b; j++) {
                if (b % j == 0) {
                    bFact = b / j;
                    if (bFact == aFact) {
                        gcf = aFact;
                        gcfFound = true;
                        break;
                    }
                }
            }
            if (gcfFound) {
                break;
            }
        }
        return (a / gcf) * b;
    }

    /**
     * 
     * @param args not used
     */
    public static void main(String[] args)
    {
        FunLoops fun = new FunLoops();

        fun.magicsquare(4);
        System.out.println();
    
        System.out.println("LCM (15, 18) = " + fun.lcm(15, 18));
        System.out.println("LCM (40, 12) = " + fun.lcm(40, 12));
        System.out.println("LCM (2, 7) = " + fun.lcm(2, 7));
        System.out.println("LCM (100, 5) = " + fun.lcm(100, 5));
        System.out.println();
    
        fun.magicsquare(10);
    }
}

