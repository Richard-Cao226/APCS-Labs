import java.util.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author Period - TODO Your Period
   @author Assignment - JM24.6 - Search Engine

   @author Sources - TODO list collaborators
 */
public class SearchEngine
{
    // Instance variable(s)
    private String myURL; // holds the name for the "url" (file name)
    private Map<String, List<String>> myIndex; // holds the word index

    // Constructor(s)
    /**
     * Constructor
     * @param url of text
     */
    public SearchEngine(String url) {
        myURL = url;
        myIndex = new HashMap<String, List<String>>(20000);
        
    }


    // Methods
    /**
     * Get URL
     * @return String myURL
     */
    public String getURL() {
        return myURL;
    }
    
    /**
     * Adds a line
     * @param line to add
     */
    public void add(String line) {
        Set<String> set = parseWords(line);
        for (String s : set) {
            if (myIndex.containsKey(s)) {
                LinkedList<String> temp = (LinkedList<String>)myIndex.get(s);
                temp.add(line);
                myIndex.put(s, temp);
            }
            else {
                LinkedList<String> temp = new LinkedList<String>();
                temp.add(line);
                myIndex.put(s, temp);
            }
        }
    }
    
    /**
     * Gets lines with word
     * @param word to find
     * @return list of lines
     */
    public List<String> getHits(String word) {
        if (myIndex.containsKey(word)) {
            return myIndex.get(word);
        }
        else {
            return null;
        }
    }
    
    /**
     * Splits line into words
     * @param line to split
     * @return set of words
     */
    private Set<String> parseWords(String line) {
        String[] arr = line.split("\\W+");
        TreeSet<String> set = new TreeSet<String>();
        for (String s : arr) {
            if (!s.equals("")) {
                set.add(s.toLowerCase());
            }
        }
        return set;
    }


    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation
    /**
     * Gets Index
     * @return a Hashmap
     */
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
