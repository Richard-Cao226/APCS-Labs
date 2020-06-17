/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author  Period - TODO Your Period
   @author  Assignment - TODO Assignment Name

   @author  Sources - TODO list collaborators
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    //   using the Mergesort algorithm
    public static void sort(double[] a)
    {
        int n = a.length;
        for (int i = n/2; i >= 1; i--)
            reheapDown(a, i, n);
        while (n > 1)
        {
        // swap a[0] with a[n-1]:
            double temp = a[0];
            a[0] = a[n-1];
            a[n-1] = temp;
            n--;
            reheapDown(a, 1, n);
        }
    }

    // Should be private - made public for testing
    public static void reheapDown(double[] a, int rootHeapNum, int lastHeapNum)
    {
        int rootInd = rootHeapNum - 1;
        while (rootInd * 2 + 1 < lastHeapNum) {
            int leftInd = rootInd * 2 + 1;
            int rightInd = rootInd * 2 + 2;
            if (rightInd == lastHeapNum)
                if (a[leftInd] < a[rootInd]) {
                    break;
                }
                else if (a[leftInd] >= a[rootInd]) {
                    double temp = a[leftInd];
                    a[leftInd] = a[rootInd];
                    a[rootInd] = temp;
                    rootInd *= 2;
                    rootInd += 1;
                    break;
                }
            if (a[rootInd] >= a[leftInd] && a[rootInd] >= a[rightInd]) {
                break;
            }
            if (a[rightInd] < a[leftInd]) {
            	double temp = a[leftInd];
                a[leftInd] = a[rootInd];
                a[rootInd] = temp;
                rootInd *= 2;
                rootInd += 1;
            }
            else if (a[rightInd] < a[leftInd]){
            	double temp = a[rightInd];
                a[rightInd] = a[rootInd];
                a[rootInd] = temp;
                rootInd += 2;
                rootInd *= 2;
            }
        }
    }
}
