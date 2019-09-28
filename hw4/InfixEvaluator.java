import java.util.*;

class InfixEvaluator {
  public double evaluateInfix(String s){
    // YOUR CODES
    return 0;  // for compilation.  You need to change it.
  }
  
  public static void main(String[] args) throws Exception {
    InfixEvaluator infix = new InfixEvaluator();
    System.out.print("Please enter an arithmetic expressions: ");
    Scanner input = new Scanner(System.in);
    String exp = input.nextLine();
    System.out.println("The result is: " + infix.evaluateInfix(exp));
  }
}