/**
 * test class
 * @author Richard
 * @version 10/24
 */
class OldMacDonald
{
    /**
     * main method
     * @param args default
     */
    public static void main(String[] args)
    {
        Cow c = new Cow("cow", "moo");
        System.out.println( c.getType() + " goes " + c.getSound() );
        Chick chick = new Chick("chick", "cluck");
        System.out.println( chick.getType() + " goes " + chick.getSound() );
        Pig pig = new Pig("pig", "oink");
        System.out.println( pig.getType() + " goes " + pig.getSound() );
        Farm farm = new Farm();
        farm.animalSounds();
    }
}

