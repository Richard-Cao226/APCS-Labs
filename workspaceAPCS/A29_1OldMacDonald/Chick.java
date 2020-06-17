import java.util.Random;
/**
 * Chick class
 * @author Richard
 * @version 10/24
 */
class Chick implements Animal
{
    private String myType;
    private String mySound1;
    private String mySound2;

    /**
    Initializes a newly created Chick object so that it represents an Animal
    of the specified type that makes the specified sound.
    @param type the type of Chick
    @param sound the sound the Chick makes
    */
    public Chick(String type, String sound)
    {
        myType = type;
        mySound1 = sound;
    }
    
    /**
     * Makes Chick object with two sounds
     * @param type type of Chick
     * @param sound1 first sound
     * @param sound2 second sound
     */
    public Chick(String type, String sound1, String sound2) {
        myType = type;
        mySound1 = sound1;
        mySound2 = sound2;
    }

    /**
     * returns Chick sound
     * @return mySound Chick sound
     */
    public String getSound()
    {
        if (mySound2 == null) {
            return mySound1;
        }
        else {
            Random rand = new Random();
            if (rand.nextInt(2) == 0) {
                return mySound1;
            }
            else {
                return mySound2;
            }
        }
    }

    /**
     * returns Chick type
     * @return myType Chick type
     */
    public String getType()
    {
        return myType;
    }
}