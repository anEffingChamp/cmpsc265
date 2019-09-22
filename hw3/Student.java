//A Java program to demonstrate Comparator interface 
import java.io.*; 
import java.util.*; 

// A class 'Student' that implements Comparable 
class Student implements Comparable<Student> { 
  private String firstName;
  private String lastName;
  private String major; 
  private double gpa; 

  //Implement the following method, so that students can be sorted by their lastname
  public int compareTo(Student m) { 
    // YOUR CODES
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