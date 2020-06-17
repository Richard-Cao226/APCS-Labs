

/**
   Implements a sorted list of words

   @author  TODO Your Name
   @version TODO Date

   @author Period - TODO Your Period
   @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order

   @author Sources - TODO list collaborators
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    /**
     * Constructor
     */
    public SortedWordList() {
        super();
    }
    
    /**
     * Constructor
     * @param capacity c
     */
    public SortedWordList(int capacity) {
        super(capacity);
    }
    
    /**
     * Contains
     * @param s s
     * @return boolean
     */
    public boolean contains(String s) {
        int left = 0;
        int right = size() - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (s.equals(get(middle))) {
                return true;
            }
            else if (s.compareToIgnoreCase(get(middle)) < 0) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return false;
    }
    
    /**
     * index Of
     * @param s s
     * @return integer
     */
    public int indexOf(String s) {
        int left = 0;
        int right = size() - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (s.equals(get(middle))) {
                return middle;
            }
            else if (s.compareToIgnoreCase(get(middle)) < 0) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return -1;
    }

    /**
     * set
     * @param i i
     * @param word w
     * @return String
     */
    public String set(int i, String word) {
        if (size() == 1) {
            super.set(0, word);
            return word;
        }
        else if (i == size() - 1) {
            if (word.compareToIgnoreCase(get(i - 1)) > 0) {
                super.set(i, word);
                return word;
            }
            else {
                throw new IllegalArgumentException("word =" + word + "i =" + i);
            }
        }
        else if (i == 0 && word.compareToIgnoreCase(get(i + 1)) > 0) {
            throw new IllegalArgumentException("word =" + word + "i =" + i);
        }
        else if (i == 0 && word.compareToIgnoreCase(get(i + 1)) < 0) {
            super.set(i, word);
            return word;
        }
        else if (word.compareToIgnoreCase(get(i - 1)) < 0 || word.
            compareToIgnoreCase(get(i + 1)) > 0 || word.
            equalsIgnoreCase(get(i - 1)) || word.
            equalsIgnoreCase(get(i + 1))) {
            throw new IllegalArgumentException("word =" + word + "i =" + i);
        }
        else {
            super.set(i, word);
            return word;
        }
    }
    
    /**
     * add
     * @param i i
     * @param word w
     */
    public void add(int i, String word) {
        if (i == 0 && word.compareToIgnoreCase(get(i)) > 0) {
            throw new IllegalArgumentException("word =" + word + "i =" + i);
        }
        else if (i == 0 && word.compareToIgnoreCase(get(i)) < 0) {
            super.add(0, word);
        }
        else if (i == size()) {
            super.add(word);
        }
        else if (word.compareToIgnoreCase(get(i - 1)) < 0 || word.
            compareToIgnoreCase(get(i + 1)) > 0 || word.
            equalsIgnoreCase(get(i - 1)) || word.
            equalsIgnoreCase(get(i + 1))) {
            throw new IllegalArgumentException("word =" + word + "i =" + i);
        }
        else {
            super.add(i, word);
        }
    }
    
    /**
     * add
     * @param word w
     * @return boolean
     */
    public boolean add(String word) {
        if (contains(word)) {
            return false;
        }
        else if (size() == 0) {
            super.add(word);
            return true;
        }
        else if (size() == 1) {
            if (word.compareToIgnoreCase(get(0)) < 0) {
                super.add(0, word);
                return true;
            }
            else {
                super.add(word);
                return true;
            }
        }
        else if (size() == 2) {
            if (word.compareToIgnoreCase(get(0)) < 0) {
                super.add(0, word);
                return true;
            }
            else if (word.compareToIgnoreCase(get(1)) < 0) {
                super.add(1, word);
                return true;
            }
            else {
                super.add(word);
                return true;
            }
        }
        else {
            int left = 0;
            int right = size() - 1;
            if (word.compareToIgnoreCase(get(size() - 1)) > 0) {
                super.add(word);
            }
            while (left <= right) {
                int middle = (left + right) / 2;
                if (word.compareToIgnoreCase(get(middle)) > 0 && 
                    word.compareToIgnoreCase(get(middle + 1)) < 0) {
                    super.add(middle + 1, word);
                    return true;
                }
                else if (word.compareToIgnoreCase(get(middle)) < 0) {
                    right = middle - 1;
                }
                else {
                    left = middle + 1;
                }
            }
            return false;
        }
    }
    
    /**
     * merge
     * @param additionalWords a
     */
    public void merge(SortedWordList additionalWords) {
        int end = size() - 1;
        int spaces = 0;
        for (int i = 0; i < additionalWords.size(); i++) {
            if (!contains(additionalWords.get(i))) {
                super.add("");
                spaces++;
            }
        }
        for (int i = additionalWords.size() - 1; i >= 0 && end >= 0; i--) {
            if (!contains(additionalWords.get(i)) && get(end).
                compareToIgnoreCase(additionalWords.get(i)) < 0) {
                super.set(end + spaces, additionalWords.get(i));
                spaces--;
            }
            else {
                if (!contains(additionalWords.get(i))) {
                    super.set(end + spaces, get(end));
                    super.set(end, "");
                    end--;
                    if (end < 0) {
                        super.set(0, additionalWords.get(i));
                        break;
                    }
                    i++;
                }
            }
        }
    }
}
