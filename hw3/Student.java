//A Java program to demonstrate Comparator interface
import java.io.*;
import java.util.*;

// A class 'Student' that implements Comparable
/**
 * Please first download the attached Student.java file. You are expected to:
 * -Implement the compareTo()method to the Studentclass so that students can be
 * sorted by their last name.
 * -Finish implementing the FirstNameCompareclass so
 * that students can be sorted by their first name.
 * -Finish implementing the MajorCompareclass so that students can be sorted by
 *  their major.
 * -Finish
 * implementing the GPACompareclass so that students can be sorted in descending
 * orderof their GPA.
 * -Write codes in the main()method to sort the students by
 * different criteria.
 */
class Student implements Comparable<Student> {
  private String firstName;
  private String lastName;
  private String major;
  private double gpa;

  //Implement the following method, so that students can be sorted by their lastname
  public int compareTo(Student input)
  {
    /*
     * We can not loop longer than the shorter name.
     */
    int loopLength = this.lastName.length();
    if (input.lastName.length() < loopLength) {
        loopLength = input.lastName.length();
    }
    /*
     * We also need to convert the strings to arrays so that we can loop through
     * each character for comparison.
     */
    char[] thisName  = this.lastName.toCharArray();
    char[] inputName = input.lastName.toCharArray();
    for (int loop = 0;
    loop < loopLength;
    loop++
    ) {
        /*
         * We return 1 if this.lastName should sort earlier, or 0 if
         * input.lastName should be. We return -1 if they are both equal. We
         * also need to consider where one name is wholly contained in the
         * other, but one name is also longer. In that case, the shorter name
         * should sort first.
         */
        if (thisName[loop] < inputName[loop]
        || (
            loop == loopLength
            &&  loopLength < thisName.length
        )) {
            return 1;
        }
        if (thisName[loop] > inputName[loop]
        || (
            loop == loopLength
            &&  loopLength < inputName.length
        )) {
            return 0;
        }
    }
    return -1; // This is for compilation.  You need to change it.
  }

  // Constructor
  public Student(String fn, String ln, String major, double gpa) {
    this.firstName = fn;
    this.lastName = ln;
    this.major = major;
    this.gpa = gpa;
  }

  // Getter methods for accessing private data
  public String getLastName() { return lastName; }
  public String getFirstName() { return firstName; }
  public String getMajor() { return major; }
  public double getGPA() { return gpa; }

  public static void main(String[] args) {
    ArrayList<Student> list = new ArrayList<Student>();
    list.add(new Student("Ellen", "Smith", "cs", 3.78));
    list.add(new Student("Ava", "Johnson", "math", 3.92));
    list.add(new Student("Mia", "Williams", "cs", 3.66));
    list.add(new Student("Sophie", "Brown", "math", 3.72));
    list.add(new Student("Nele", "Davis", "cs", 3.88));

    //YOUR CODES
    // Sort students by their lastname and display all students.
    Student studentPlaceholder = list.get(0);
    System.out.println(studentPlaceholder.compareTo(list.get(1)));
    // Sort students by their firstname and display all students.
    // Sort students by their major and display all students.
    // Sort students by their GPA and display all students.
  }
}

//Finish implementing the following class, so that students can be sorted by their firstname
//class FirstNameCompare implements Comparator<Student> {
  // YOUR CODES
//}

//Finish implementing the following class, so that students can be sorted by their major
//class MajorCompare implements Comparator<Student> {
  // YOUR CODES
//}

//Finish implementing the following class, so that students can be sorted by their GPA
//class GPACompare implements Comparator<Student> {
  // YOUR CODES
//}
