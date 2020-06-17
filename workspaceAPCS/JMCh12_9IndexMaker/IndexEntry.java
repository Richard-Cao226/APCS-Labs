import java.util.ArrayList;

/**
 * IndexEntry class
 * @author Richard Cao
 * @version 11/8
 */
public class IndexEntry
{
    private String word;
    private ArrayList<Integer> numsList;

    // Constructs an IndexEntry for a given word
    // (converted to upper case); sets numsList
    // to an empty ArrayList.
    /**
     * constructor
     * @param word of entry
     */
    public IndexEntry(String word)
    {
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }

    // Returns the word of this IndexEntry object.
    /**
     * returns word
     * @return word of entry
     */
    public String getWord()
    {
        return word;
    }

    // If num is not already in the list, adds num
    // at the end of this IndexEntry's list
    // of numbers.
    /**
     * adds num
     * @param num line of word
     */
    public void add(int num)
    {
        Integer numObj = new Integer(num);
        if (!numsList.contains(numObj)) {
            numsList.add(numObj);
        }
    }

    // Converts this IndexEntry into a string in the
    // following format: the word followed by a space, followed by
    // numbers separated by a comma and a space.
    /**
     * converts to string
     * @return out string
     */
    public String toString()
    {
        String out = word;
        for (int i = 0; i < numsList.size(); i++) {
            if (i != numsList.size() - 1) {
                out += " " + numsList.get(i) + ",";
            }
            else {
                out += " " + numsList.get(i);
            }
        }
        return out;
    }
}
