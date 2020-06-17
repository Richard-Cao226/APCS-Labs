/**
 * College Student
 * @author Richard
 * @version 2019-10-21
 */
public class CollegeStudent extends Student
{
    private String major;
    private int year;
    
    /**
     * Constructor
     * @param name of student
     * @param age of student
     * @param gender of student
     * @param idNum of student
     * @param gpa of student
     * @param year of student
     * @param major of student
     */
    public CollegeStudent(String name, int age, String gender, String idNum, 
        double gpa, int year, String major) {
        super(name, age, gender, idNum, gpa);
        this.major = major;
        this.year = year;
    }
    
    /**
     * Returns year
     * @return year of student
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Returns major
     * @return major of student
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * sets year
     * @param year to set student to
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * sets major
     * @param major to set student to
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + year +
            ", major: " + major;
    }
}
