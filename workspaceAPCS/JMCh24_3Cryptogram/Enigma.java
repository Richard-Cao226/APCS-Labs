
/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author Period - TODO Your Period
   @author Assignment - JM 24.3 Lab: Cryptogram Solver

   @author Sources - TODO list collaborators
 */
public class Enigma
{
    private char[] lookupTable;

    /**
     * Constructor
     * @param numLetters the number of letters
     */
    public Enigma(int numLetters)
    {
        lookupTable = new char[numLetters];
    }

    /**
     * sets substitution
     * @param index index to set
     * @param ch char to set it to
     */
    public void setSubstitution(int index, char ch)
    {
        lookupTable[index] = ch;
    }

    /**
     * decodes text
     * @param text String to decode
     * @return String of decoded text
     */
    public String decode(String text)
    {
        StringBuffer buffer = new StringBuffer(text.length());
        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                buffer.append(Character.toString(lookupTable[Character.
                    getNumericValue(c) - Character.getNumericValue('a')]).
                    toLowerCase());
            }
            else if (Character.isUpperCase(c)) {
                buffer.append(Character.toString(lookupTable[Character.
                    getNumericValue(c) - Character.getNumericValue('A')]));
            }
            else {
                buffer.append(c);
            }
        }

        return buffer.toString();
    }

    /**
     * gets hints for text
     * @param text encoded text
     * @param lettersByFrequency letters in order of frequency
     * @return String of hints
     */
    public String getHints(String text, String lettersByFrequency)
    {
        String hint = "";
        int[] count = countLetters(text);
        int icount = 0;
        int jcount = 0;
        int index = 0;
        for (int i : count) {
            for (int j : count) {
                if (i > j || i == j && icount > jcount) {
                    index = index + 1;
                }
                jcount++;
            }
            hint = hint + lettersByFrequency.substring(index, index + 1);
            index = 0;
            icount++;
            jcount = 0;
        }
        return hint;
    }

    /**
     * counts occurrence of each letter
     * @param text to count
     * @return array of occurrences
     */
    private int[] countLetters(String text)
    {
        text = text.toUpperCase();
        int[] counts = new int[lookupTable.length];
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < text.length(); i++) {
            if (letters.contains(text.substring(i, i + 1))) {
                counts[Character.getNumericValue(text.charAt(i)) - Character.
                    getNumericValue('A')]++;
            }
        }
        return counts;
    }

    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation

    /**
     * returns lookupTable
     * @return char[] lookupTable
     */
    public char[] getLookupTable()
    {
        return lookupTable;
    }

    /**
     * returns count of letters
     * @param text to count
     * @return int[] of counts
     */
    public int[] getCountLetters(String text)
    {
        return countLetters(text);
    }

}