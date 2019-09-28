import java.util.*;
/*
 * Problem 1: InfixEvaluatorclass(25')
 * Description:Please write a program that
 * can evaluate an infix arithmetic expressions involving doubles combined with
 * +, -, *, /, and ^ operators as well as
 * parenthesis. The parenthesis does NOT have to be fully balanced. For
 * example:( 2 * 3 ^ 2 ).  The fully parenthesized version of this expression
 * would be ( 2 * ( 3 ^ 2 ) )However, make sure that:
 * - Each such expression always has one opening parenthesis and one closing
 *   parenthesis.  For example,
 * you need to represent as ( 2 + 3 ) not 2 + 3.
 * - Numbers and operators including
 * parenthesis are all separated by a space.
 * - Please do not first convert the
 * infix expression into postfix, and then evaluate the postfix
 */
class InfixEvaluator
{
public double evaluateInfix(String s)
{
    // YOUR CODES
    return 0;  // for compilation.  You need to change it.
}
public static void main(String[] args) throws Exception
{
    InfixEvaluator infix = new InfixEvaluator();
    System.out.print("Please enter an arithmetic expressions: ");
    Scanner input = new Scanner(System.in);
    String exp = input.nextLine();
    System.out.println("The result is: " + infix.evaluateInfix(exp));
}
}
