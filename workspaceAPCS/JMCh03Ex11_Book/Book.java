/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what
 *       abstraction it represents, and how to use it.
 *
 *  @author  TODO Richard Cao
 *  @version TODO 8/27
 *  @author  Period: TODO 3
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: TODO list collaborators
 */
public class Book
{
    // TODO implement data fields
    private int numPages, currentPage;
    
    // TODO implement constructor
    public Book(int num) {
        numPages = num;
        currentPage = 1;
    }
    
    // TODO implement methods
    public int getNumPages() {
        return numPages;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    public void nextPage() {
        if(currentPage < numPages) {
            currentPage++;
        }
    }
}
