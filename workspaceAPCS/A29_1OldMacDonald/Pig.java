/**
 * Pig class
 * @author Richard
 * @version 10/24
 */
class Pig implements Animal
{
    private String myType;
    private String mySound;

    /**
    Initializes a newly created Pig object so that it represents an Animal
    of the specified type that makes the specified sound.
    @param type the type of Pig
    @param sound the sound the Pig makes
    */
    public Pig(String type, String sound)
    {
        myType = type;
        mySound = sound;
    }

    /**
     * returns Pig sound
     * @return mySound Pig sound
     */
    public String getSound()
    {
        return mySound;
    }

    /**
     * returns Pig type
     * @return myPig Pig sound
     */
    public String getType()
    {
        return myType;
    }
}