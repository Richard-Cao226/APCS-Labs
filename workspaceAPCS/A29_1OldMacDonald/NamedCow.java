/**
 * NamedCow class
 * @author Richard
 * @version 10/24
 */
class NamedCow extends Cow
{
    private String myName;
    /**
     * Constructor with 2 parameters
     * @param name name of cow
     * @param sound cow sound
     */
    public NamedCow(String name, String sound) {
        super("cow", sound);
        myName = name;
    }
    /**
     * Constructor with 3 parameters
     * @param type type of cow
     * @param name name of cow
     * @param sound cow sound
     */
    public NamedCow(String type, String name, String sound) {
        super(type, sound);
        myName = name;
    }
    /**
     * returns name of cow
     * @return myName name of cow
     */
    public String getName() {
        return myName;
    }
}
