/**
 * Teacher
 * @author Richard
 * @version 2019-10-19
 */
public class Teacher extends Person
{
    private String subject;
    private double salary;
    
    /**
     * Constructor
     * @param name of teacher
     * @param age of teacher
     * @param gender of teacher
     * @param subject of teacher
     * @param salary of teacher
     */
    public Teacher(String name, int age, String gender, String subject, double 
        salary) {
        super(name, age, gender);
        this.subject = subject;
        this.salary = salary;
    }
    
    /**
     * returns subject
     * @return subject of teacher
     */
    public String getSubject() {
        return subject;
    }
    
    /**
     * returns salary
     * @return salary of teacher
     */
    public double getSalary() {
        return salary;
    }
    
    /**
     * sets subject
     * @param subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    /**
     * sets salary
     * @param salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + subject +
            ", salary: " + salary;
    }
}
