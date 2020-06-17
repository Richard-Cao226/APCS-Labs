import java.util.*;
import java.lang.Character;
/**
 * Java Methods Chapter 10
 * Exercises 2, 6 - 11, 14 - 15, 20 & 22 
 * 
 * @author Richard Cao
 * @version 10/14
 * 
 * @author Period - 3
 * @author Assignment - Ch10Exercises
 * 
 * @author Sources - Richard Cao
 */
public class JMCh10Exercises
{
    Scanner scan;

    /**
     * Constructs a Scanner for input from the console.
     */
    public JMCh10Exercises()
    {
        scan = new Scanner( System.in );
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str  input for the various methods
     */
    public JMCh10Exercises( String str )
    {
        scan = new Scanner( str );
    }

    // 10-2(a)
    /**
     * checks if string ends with star
     * @param s input string
     * @return boolean ends with star
     */
    public boolean endsWithStar( String s )
    {
        if (!s.isEmpty() && s.charAt(s.length() - 1) == '*') {
            return true;
        }
        else {
            return false;
        }
    }

    // 10-2(b)
    /**
     * checks if string ends with 2 stars
     * @param s input string
     * @return boolean ends with 2 stars
     */
    public boolean endsWith2Stars( String s )
    {
        if (s.length() >= 2 && s.charAt(s.length() - 1) == '*' && s.charAt(s.
            length() - 2) == '*') {
            return true;
        }
        else {
            return false;
        }
    }

    // 10-6
    /**
     * moves first character to end
     * @param s input strings
     * @return string with first character at end
     */
    public String scroll( String s )
    {
        return s.substring(1,s.length()) + s.substring(0,1);
    }

    // 10-7
    /**
     * puts first name before last name
     * @param name input string
     * @return string name
     */
    public String convertName( String name )
    {
        String newName = name.trim();
        String lastName = "";
        boolean commaFound = false;
        String firstName = "";
        for (int i = 0; i < newName.length(); i++) {
            if (commaFound) {
                firstName += newName.substring(i, i + 1);
            }
            if (name.charAt(i) != ',' && !commaFound) {
                lastName += newName.substring(i, i + 1);
            }
            else {
                commaFound = true;
            }
        }
        return (firstName + " " + lastName).trim();
    }
    
    // 10-8
    /**
     * changes 0's to 1's and 1's to 0's
     * @param str input string
     * @return new negated string
     */
    public String negate( String str )
    {
        String out = str.replace('0', '2');
        out = out.replace('1', '0');
        out = out.replace('2', '1');
        return out;
    }

    // 10-9
    /**
     * checks if all characters are same
     * @param s input string
     * @return boolean is all same
     */
    public boolean isConstant( String s )
    {
        if (s.equals(s.substring(1, s.length()) + s.substring(0, 1))) {
            return true;
        }
        else {
            return false;
        }
    }

    // 10-10
    /**
     * removes comment
     * @param str input string
     * @return new string
     */
    public String removeComment( String str )
    {
        int firstInd = 0;
        int secondInd = str.length();
        if(str.contains("/*") && str.contains("*/")) {
            firstInd = str.indexOf("/*");
            secondInd = str.lastIndexOf("*/");
            return str.substring(0, firstInd) + str.substring(secondInd + 2, str
                   .length());
        }
        else {
            return str;
        }
    }

    // 10-11
    /**
     * removes first occurrence of s2
     * @param s string
     * @param s2 string to remove
     * @return new string
     */
    public String cutOut( String s, String s2 )
    {
        return s.substring(0, s.indexOf(s2)) + s.substring(s.indexOf(s2) + s2.
               length(), s.length());
    }

    // 10-14
    /**
     * removes html tags
     * @param str input string
     * @return string without html tags
     */
    public String removeHtmlTags( String str )
    {
        String tag = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '>') {
                break;
            }
            if (i >= 1 && str.charAt(i - 1) == '<') {
                tag += str.substring(i, i + 1);
            }
        }
        str = str.replace("<" + tag + ">", "");
        str = str.replace("</" + tag + ">", "");
        return str;
    }

    // 10-15
    /**
     * checks if string only has digits
     * @param s input string
     * @return does string only have digits
     */
    public boolean onlyDigits( String s )
    {
        String digits = "0123456789";
        boolean onlyDigits = true;
        for (int i = 0; i < s.length(); i++) {
            if (!digits.contains(s.substring(i, i + 1))) {
                onlyDigits = false;
                break;
            }
        }
        return onlyDigits;
    }

    // 10-20
    /**
     * checks if ISBN is valid
     * @param isbn input ISBN
     * @return is ISBN valid
     */
    public static boolean isValidISBN( String isbn )
    {
        int value = 0;
        if (isbn.charAt(9) == 'X') {
            value = 10;
        }
        else {
            value = Character.digit(isbn.charAt(9), 10);
        }
        if ((10 * Character.digit(isbn.charAt(0), 10) + 9 * Character.digit(isbn.
            charAt(1), 10) + 8 * Character.digit(isbn.charAt(2), 10) + 7 * 
            Character.digit(isbn.charAt(3), 10) + 6 * Character.digit(isbn.
            charAt(4), 10) + 5 * Character.digit(isbn.charAt(5), 10) + 4 * 
            Character.digit(isbn.charAt(6), 10) + 3 * Character.digit(isbn.
            charAt(7), 10) + 2 * Character.digit(isbn.charAt(8), 10) + value) % 
            11 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // 10-22
    /**
     * shuffles string
     * @param s input string
     * @return shuffled string
     */
    public String shuffle( String s )
    {
        StringBuffer temp = new StringBuffer(s);
        int n = temp.length() - 1;
        char hold = ' ';
        int ind = 0;
        while (n > 1) {
            ind = (int)(Math.random() * n);
            hold = temp.charAt(ind);
            temp.setCharAt(ind, temp.charAt(n));
            temp.setCharAt(n, hold);
            n--;
        }
        return temp.toString();
    }

    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes
     * each method.
     * 
     * @param args command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        JMCh10Exercises exercise = new JMCh10Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) 10-2(a) endsWithStar( String s )" );
            System.out.println( "   (2) 10-2(b) endsWith2Stars( String s )" );
            System.out.println( "   (3) 10-6 scroll( String s )" );
            System.out.println( "   (4) 10-7 convertName( String name )" );
            System.out.println( "   (5) 10-8 negate( String str )" );
            System.out.println( "   (6) 10-9 isConstant( String s )" );
            System.out.println( "   (7) 10-10 removeComment( String str )" );
            System.out.println( "   (8) 10-11 cutOut( String s, String s2 )" );
            System.out.println( "   (9) 10-14 removeHtmlTags( String str )" );
            System.out.println( "   (A) 10-15 onlyDigits( String s )" );
            System.out.println( "   (B) 10-20 isValidISBN( String isbn )" );
            System.out.println( "   (C) 10-22 shuffle( String s )" ); 
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        String end1Star = "**endsWith**Star*";
                        System.out.println("endsWithStar(" + end1Star + ") = " +
                            exercise.endsWithStar(end1Star));
                        String ends0Star = "**endsWith**Star*No";
                        System.out.println("endsWithStar(" + ends0Star + ") = " +
                            exercise.endsWithStar(ends0Star));
                        break;
                    case '2':
                        String end2Str = "**endsWith**2Stars**";
                        System.out.println("endsWith2Stars(" + end2Str + ") = " +
                            exercise.endsWith2Stars(end2Str));
                        String endsWith1Star = "**endsWith**2Stars*";
                        System.out.println("endsWith2Stars(" + endsWith1Star + ") = " +
                            exercise.endsWith2Stars(endsWith1Star));
                        break;
                    case '3':
                        String scrollStr = "bdfhjlnprtvxz";
                        System.out.println("scroll(\"" + scrollStr + "\") --> " + 
                            "\"" + exercise.scroll(scrollStr) + "\"");
                        break;
                    case '4':
                        String convStr = "von Neumann, John";
                        System.out.println("convertName(\"" + convStr + "\") --> " +
                            "\"" + exercise.convertName(convStr) + "\"");
                        break;
                    case '5':
                        String negStr = "1001110001010101110";
                        System.out.println("negate(\"" + negStr + "\") --> " +
                            "\"" + exercise.negate(negStr) + "\"");
                        break;
                    case '6':
                        String constStr1 = "0000000000000000000";
                        String constStr2 = "1001110001010101110";
                        System.out.println("isConstant(\"" + constStr1 + "\") = " +
                            exercise.isConstant( constStr1 ) );
                        System.out.println("isConstant(\"" + constStr2 + "\") = " +
                             exercise.isConstant( constStr2 ) );
                        break;
                    case '7':
                        String comment = "/* this should be gone */ int a = 0;";
                        String notComment = "/* this should stay /* int a = 0;";
                        System.out.println("removeComment(\"" + comment + "\") --> " +
                            "\"" + exercise.removeComment( comment ) + "\"");
                        System.out.println("removeComment(\"" + notComment + "\") --> " +
                            "\"" + exercise.removeComment( notComment ) + "\"");
                        break;
                    case '8':
                        String cutstr = "Hi-ho, hi-ho";
                        String cutOutstr = "-ho";
                        System.out.println("cutOut(\"" + cutstr + "\", \"" + cutOutstr + "\") --> " +
                            "\"" + exercise.cutOut( cutstr, cutOutstr ) + "\"");
                        break;
                    case '9':
                        String htmlStr = "Strings are <b>immutable</b>";
                        System.out.println("removeHtmlTags(\"" + htmlStr + "\") --> " +
                            "\"" + exercise.removeHtmlTags(htmlStr) + "\"");
                        break;
                    case 'A':
                    case 'a':
                        String digitStr = "123456789";
                        String dStr = "1234V5678";
                        System.out.println("onlyDigits(\"" + digitStr + "\") = " +
                            exercise.onlyDigits(digitStr) );
                        System.out.println("onlyDigits(\"" + dStr + "\") = " +
                            exercise.onlyDigits(dStr) );
                        break;
                    case 'B':
                    case 'b':
                        String validISBN = "096548534X";
                        String invalidISBN = "1234567890";
                        System.out.println("isValidISBN(\"" + validISBN + "\") = " +
                            exercise.isValidISBN(validISBN) );
                        System.out.println("isValidISBN(\"" + invalidISBN + "\") = " +
                            exercise.isValidISBN(invalidISBN) );
                        break;
                    case 'C':
                    case 'c':
                        String str = "The quick brown fox";
                        System.out.println("shuffle(\"" + str +  "\") --> " +
                            "\"" + exercise.shuffle( str ) + "\"");
                        System.out.println("shuffle(\"" + str +  "\") --> " +
                             "\"" + exercise.shuffle( str ) + "\"");
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}