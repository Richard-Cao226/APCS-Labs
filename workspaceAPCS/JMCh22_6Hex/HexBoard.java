/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author  Period - TODO Your Period
   @author  Assignment - JM Ch22.6 - Hex

   @author  Sources - TODO list collaborators
 */
public class HexBoard extends CharMatrix
{
    public HexBoard(int rows, int cols)
    {
        super(rows, cols);
    }

    public boolean isBlack(int r, int c)
    {
        return isInBounds(r, c) && charAt(r, c) == 'b';
    }

    public boolean isWhite(int r, int c)
    {
        return isInBounds(r, c) && charAt(r, c) == 'w';
    }

    public  boolean isGray(int r, int c)
    {
        return isInBounds(r, c) && charAt(r, c) == 'x';
    }

    public void setBlack(int r, int c)
    {
        setCharAt(r, c, 'b');
    }

    public void setWhite(int r, int c)
    {
        setCharAt(r, c, 'w');
    }

    public void setGray(int r, int c)
    {
        setCharAt(r, c, 'x');
    }

    /**
     *  Returns true if there is a contiguous chain of black stones
     *  that starts in col 0 and ends in the last column of the board;
     *  otherwise returns false.
     */
    public boolean blackHasWon()
    {
        areaFill(0, 0);
        areaFill(1, 0);
        areaFill(2, 0);
        areaFill(3, 0);
        areaFill(4, 0);
        areaFill(5, 0);
        boolean win = false;
        for (int r = 0; r < 6; r++) {
            if (isGray(r, 5)) {
                win = true;
            }
        }
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                if (isGray(r, c)) {
                    setBlack(r, c);
                }
            }
        }
        return win;
    }

    /**
     *  Fills the contiguous area that contains r,c with gray color.
     *  Does nothing if r, c is out of bounds or is not black.
     */
    public void areaFill(int r, int c)
    {
        if (isInBounds(r, c) && isBlack(r, c)) {
            setGray(r, c);
            areaFill(r - 1, c - 1);
            areaFill(r - 1, c);
            areaFill(r, c - 1);
            areaFill(r, c + 1);
            areaFill(r + 1, c);
            areaFill(r + 1, c + 1);
        }
    }

    public String toString()
    {
        String s = "";

        for (int r = 0; r < numRows(); r++)
        {
            for (int c = 0; c < numCols(); c++)
            {
                if (isBlack(r, c))
                    s += 'b';      
                else if (isWhite(r, c))
                    s += 'w';
                else if (isGray(r, c))
                    s += 'x';
                else
                    s += '.';
            }
            s += '\n';
        }
        return s;
    }

    //****************************************************************

    private boolean isInBounds(int row, int col)
    {
        return row >= 0 && row < 6 && col >= 0 && col < 6;
    }
}
