import java.util.TreeMap;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO the date

   @author Period - TODO Your Period
   @author Assignment - TODO Assignment Name

   @author Sources - TODO list collaborators
 */
public class MorseCode
{
    private static final char DOT = '.';
    private static final char DASH = '-';

    private static TreeMap<Character, String> codeMap;
    private static TreeNode<Character> decodeTree;

    public static void start()
    {
        codeMap = new TreeMap<Character, String>();

        // put a space in the root of the decoding tree
        decodeTree = new TreeNode<Character>(' ', null, null);  // autoboxing

        addSymbol('A', ".-");
        addSymbol('B', "-...");
        addSymbol('C', "-.-.");
        addSymbol('D', "-..");
        addSymbol('E', ".");
        addSymbol('F', "..-.");
        addSymbol('G', "--.");
        addSymbol('H', "....");
        addSymbol('I', "..");
        addSymbol('J', ".---");
        addSymbol('K', "-.-");
        addSymbol('L', ".-..");
        addSymbol('M', "--");
        addSymbol('N', "-.");
        addSymbol('O', "---");
        addSymbol('P', ".--.");
        addSymbol('Q', "--.-");
        addSymbol('R', ".-.");
        addSymbol('S', "...");
        addSymbol('T', "-");
        addSymbol('U', "..-");
        addSymbol('V', "...-");
        addSymbol('W', ".--");
        addSymbol('X', "-..-");
        addSymbol('Y', "-.--");
        addSymbol('Z', "--..");
        addSymbol('0', "-----");
        addSymbol('1', ".----");
        addSymbol('2', "..---");
        addSymbol('3', "...--");
        addSymbol('4', "....-");
        addSymbol('5', ".....");
        addSymbol('6', "-....");
        addSymbol('7', "--...");
        addSymbol('8', "---..");
        addSymbol('9', "----.");
        addSymbol('.', ".-.-.-");
        addSymbol(',', "--..--");
        addSymbol('?', "..--..");
    }

    /**
     *  Inserts a letter and its Morse code string into the encoding map
     *  and calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol(char letter, String code)
    {
        codeMap.put(letter, code);
        treeInsert(letter, code);
    }

    /**
     *  Inserts a letter and its Morse code string into the
     *  decoding tree.  Each dot-dash string corresponds to a path
     *  in the tree from the root to a node: at a "dot" go left, at
     *  a "dash" go right.  The node at the end of the path holds
     *  the symbol for that code string.
     */
    private static void treeInsert(char letter, String code)
    {
        TreeNode<Character> node = decodeTree;
        for (char c : code.toCharArray()) {
            if (c == DOT) {
                if (node.getLeft() == null) {
                    node.setLeft(new TreeNode(' '));
                }
                node = node.getLeft();
            } else if (c == DASH) {
                if (node.getRight() == null) {
                    node.setRight(new TreeNode(' '));
                }
                node = node.getRight();
            }
        }
        node.setValue(letter);
    }

    /**
     *   Converts text into a Morse code message.  Adds a space after
     *   a dot-dash sequence for each letter.  Other spaces in the text
     *   are transferred directly into the encoded message.
     *
     *   @return the encoded message.
     */
    public static String encode(String text)
    {
        text = text.toUpperCase();
        StringBuffer morse = new StringBuffer(400);
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                morse.append(" ");
            } else {
                String code = codeMap.get(c);
                morse.append(code + " ");
            }
            
        }
        return morse.toString();
    }

    /**
     *   Converts a Morse code message into a text string.  Assumes
     *   that dot-dash sequences for each letter are separated by one
     *   space.  Additional spaces are transferred directly into text.
     *
     *   @return the plain text message.
     */
    public static String decode(String morse)
    {
        StringBuffer text = new StringBuffer(100);
        String code = "";
        for (int i = 0; i < morse.length(); i++) {
            if (morse.charAt(i) != ' ') {
                code += morse.charAt(i);
            }
            else {
                TreeNode<Character> node = decodeTree;
                for (char c : code.toCharArray()) {
                
                    if (c == DOT) {
                        node = node.getLeft();
                    }
                    else if (c == DASH) {
                        node = node.getRight();
                    }
                }
                text.append(node.getValue());
                code = "";
            }
        }

        return text.toString();
    }

    //--------------------------------------------------------------------
    // For test purposes only. Not to be used in completing the assignment

    public TreeMap<Character, String> getCodeMap()
    {
        return codeMap;
    }

    public TreeNode<Character> getDecodeTree()
    {
        return decodeTree;
    }
}
