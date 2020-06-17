import java.util.*;

/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - TODO Assignment Name
 * 
 * @author Sources - TODO list collaborators
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;
    
    /**
     * constructor
     */
    public MailServer() {
        actors = new HashSet<Actor>();
    }
    
    /**
     * sign up
     * @param actor a
     */
    public void signUp(Actor actor) {
        actors.add(actor);
    }
    
    /**
     * dispatch
     * @param msg m
     */
    public void dispatch(Message msg) {
        if (msg.getRecipient() == null) {
            for (Actor actor : actors) {
                if (!msg.getSender().getName().equals(actor.getName())) {
                    actor.receive(msg);
                }
            }
        }
        else {
            msg.getRecipient().receive(msg);
        }
    }
    
    
    // for testing purposes only
    /**
     * get actors
     * @return actors
     */
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
