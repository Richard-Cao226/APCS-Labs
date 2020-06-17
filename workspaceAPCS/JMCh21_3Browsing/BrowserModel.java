import java.util.Stack;

/**
 * Browser Model
 * @author rcao266
 * @version 1/17
 */
public class BrowserModel
{
    private BrowserView view;
    private Stack<Integer> backStk;
    private Stack<Integer> forwardStk;
    private int topLine;

    
    /**
     * constructor
     * @param view browser view
     */
    public BrowserModel(BrowserView view) {
        this.view = view;
        view.update(topLine);
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
    }

    /**
     * back
     */
    public void back() {
        forwardStk.push(topLine);
        if (hasBack()) {
            topLine = backStk.pop();
        }
        view.update(topLine);
    }
    
    /**
     * forward
     */
    public void forward() {
        backStk.push(topLine);
        if (hasForward()) {
            topLine = forwardStk.pop();
        }
        view.update(topLine);
    }
    
    /**
     * home
     */
    public void home() {
        backStk.push(topLine);
        topLine = 0;
        view.update(topLine);
    }
    
    /**
     * follow link
     * @param n line
     */
    public void followLink(int n) {
        backStk.push(topLine);
        topLine = n;
        view.update(topLine);
    }
    
    /**
     * has back
     * @return has back
     */
    public boolean hasBack() {
        return !backStk.empty();
    }
    
    /**
     * has forward
     * @return has forward
     */
    public boolean hasForward() {
        return !forwardStk.empty();
    }


    // The following are for test purposes only
    /**
     * get back stack
     * @return back stack
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }

    /**
     * get forward stack
     * @return forward stack
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }

    /**
     * get top line
     * @return top line
     */
    public int getTopLine()
    {
        return topLine;
    }
}

