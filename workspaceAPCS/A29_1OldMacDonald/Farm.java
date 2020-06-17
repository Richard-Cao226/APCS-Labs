import java.util.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.
  
   @author  Richard Cao
   @version 10/24

   Period - 3
   Assignment - A29.1 Old MacDonald

   Sources - TODO list collaborators
 */
public class Farm
{
   private Animal[] a = new Animal[3];

   public Farm()
   {      
      a[0] = new NamedCow("cow", "Elsie", "moo");
      a[1] = new Chick("chick", "cheep", "cluck");
      a[2] = new Pig("pig", "oink");
   }

   public void animalSounds()
   {
      for (int i = 0; i < a.length; i++)
      {
         System.out.println(a[i].getType() + " goes " + a[i].getSound());
      }
      System.out.println("The cow is known as " + ((NamedCow)a[0]).getName());
   }
}

