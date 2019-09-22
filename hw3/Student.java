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
public int compareMajor(Student input)
{
    return this.compareString(
        this.major.toCharArray(),
        input.major.toCharArray()
    );
}
public int compareFirst(Student input)
{
    /*
     * We also need to convert the strings to arrays so that we can loop through
     * each character for comparison.
     */
    return this.compareString(
        this.firstName.toCharArray(),
        input.firstName.toCharArray()
    );
}
private int compareString(char[] thisName, char[] inputName)
{
    /*
     * We can not loop longer than the shorter name.
     */
    int loopLength = thisName.length;
    if (inputName.length < loopLength) {
        loopLength = inputName.length;
    }
    if (thisName == inputName) {
        return 1;
    }
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
            loop == loopLength - 1
            &&  loopLength < thisName.length
        )) {
            return 1;
        }
        if (thisName[loop] > inputName[loop]
        || (
            loop == loopLength - 1
            &&  loopLength < inputName.length
        )) {
            return 0;
        }
    }
    return -1; // This is for compilation.  You need to change it.
}
public boolean compareGPA(Student input)
{
    return this.gpa <= input.gpa;
}
//Implement the following method, so that students can be sorted by their
//lastname
public int compareTo(Student input)
{
    return this.compareString(
        this.lastName.toCharArray(),
        input.lastName.toCharArray()
    );
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
/**
 * display() loops through an input array of student objects, and prints them to
 * the terminal.
 */
public static void display(Student[] input)
{
    for (int loop = 0;
    loop < input.length;
    loop++
    ) {
        System.out.println(
            input[loop].lastName
            + " " + input[loop].firstName
            + " " + input[loop].major
            + " " + input[loop].gpa
        );
    }
}
public static void main(String[] args) {
    ArrayList<Student> list = new ArrayList<Student>();
    list.add(new Student("Ellen", "Smith", "cs", 3.78));
    list.add(new Student("Ava", "Johnson", "math", 3.92));
    list.add(new Student("Mia", "Williams", "cs", 3.66));
    list.add(new Student("Sophie", "Brown", "math", 3.72));
    list.add(new Student("Nele", "Davis", "cs", 3.88));

    //YOUR CODES
    // Sort students by their lastname and display all students.
    System.out.println("Sort students by their last name:");
    Student.display(Student.sort(list.toArray(new Student[list.size()])));
    System.out.println();
    // Sort students by their firstname and display all students.
    System.out.println("Sort students by their first name:");
    Student.display(Student.sortFirst(list.toArray(new Student[list.size()])));
    System.out.println();
    // Sort students by their major and display all students.
    System.out.println("Sort students by their major:");
    Student.display(Student.sortMajor(list.toArray(new Student[list.size()])));
    System.out.println();
    // Sort students by their GPA and display all students.
    System.out.println("Sort students by their GPA (from highest to lowest):");
    Student.display(Student.sortGPA(list.toArray(new Student[list.size()])));
    System.out.println();
}
public static Student[] sortGPA(Student[] input)
{
    Student[] output = loopArray(input, 0, input.length - 2, "gpa");
    output           = loopArray(input, 1, input.length - 1, "gpa");
    for (int loop  = 0;
    loop          <= output.length - 2;
    loop          += 2
    ) {
        if (false == output[loop].compareGPA(output[loop + 1])) {
            Student.sortGPA(output);
        }
    }
    return output;
}
public static Student[] sortMajor(Student[] input)
{
    Student [] output = loopArray(input, 0, input.length - 2, "major");
    output            = loopArray(input, 1, input.length - 1, "major");
    for (int loop  = 0;
    loop          <= output.length - 2;
    loop          += 2
    ) {
        if (0 == output[loop].compareMajor(output[loop + 1])) {
            Student.sortMajor(output);
        }
    }
    return output;
}
public static Student[] sortFirst(Student[] input)
{
    Student[] output = loopArray(input, 0, input.length - 2, "firstName");
    output           = loopArray(input, 1, input.length - 1, "firstName");
    for (int loop  = 0;
    loop          <= output.length - 2;
    loop          += 2
    ) {
        if (0 == output[loop].compareFirst(output[loop + 1])) {
            Student.sortFirst(output);
        }
    }
    return output;
}
/**
 * sort() sorts an array of Student{} with the odd even sorting method.
 */
public static Student[] sort(Student[] input)
{
    Student[] output = loopArray(input, 0, input.length - 2, "");
    output           = loopArray(input, 1, input.length - 1, "");
    for (int loop  = 0;
    loop          <= output.length - 2;
    loop          += 2
    ) {
        if (0 == output[loop].compareTo(output[loop + 1])) {
            Student.sort(output);
        }
    }
    return output;
}
private static Student[] loopArray(
    Student[] array,
    int loopStart,
    int loopEnd,
    String loopField
) {
    Student[] output = array;
    for (int loop  = loopStart;
    loop          <= loopEnd;
    loop          += 2
    ) {
        if (loop == output.length - 1) {
            break;
        }
        switch (loopField) {
        case "gpa":
            if (false == output[loop].compareGPA(output[loop + 1])) {
                output = Student.swapElements(output, loop);
            }
            break;
        case "major":
            if (0 == output[loop].compareMajor(output[loop + 1])) {
                output = Student.swapElements(output, loop);
            }
            break;
        case "firstName":
            if (0 == output[loop].compareFirst(output[loop + 1])) {
                output = Student.swapElements(output, loop);
            }
            break;
        default:
            if (0 == output[loop].compareTo(output[loop + 1])) {
                output = Student.swapElements(output, loop);
            }
        }
    }
    return output;
}
private static Student[] swapElements(Student[] input, int loop)
{
    Student[] output = input;
    Student valueTemporary = output[loop];
    output[loop]           = output[loop + 1];
    output[loop + 1]       = valueTemporary;
    return output;
}
}
