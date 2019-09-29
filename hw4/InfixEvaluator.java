import java.util.*;
/*
 * Problem 1: InfixEvaluatorclass(25')
 * Description:Please write a program that
 * can evaluate an infix arithmetic expressions involving doubles combined with
 * +, -, *, /, and ^ operators as well as
 * parenthesis. The parenthesis does NOT have to be fully balanced. For
 * example:( 2 * 3 ^ 2 ).  The fully parenthesized version of this expression
 * would be ( 2 * ( 3 ^ 2 ) )However, make sure that:
 *
 * - Each such expression always has one opening parenthesis and one closing
 *   parenthesis.  For example, you need to represent as ( 2 + 3 ) not 2 + 3.
 * - Numbers and operators including parenthesis are all separated by a space.
 * - Please do not first convert the infix expression into postfix, and then
 *   evaluate the postfix
 */
class InfixEvaluator
{
Stack<String> valueStack;
Stack<String> operatorStack;
Stack<String> parenthesesStack;
public double evaluateInfix(String input)
{
    this.valueStack           = new Stack<String>();
    this.operatorStack        = new Stack<String>();
    this.parenthesesStack     = new Stack<String>();
    StringTokenizer tokenizer = new StringTokenizer(input, " ");
    while (true == tokenizer.hasMoreTokens()) {
        String token = tokenizer.nextToken();
        switch (token) {
        case "(":
            parenthesesStack.push(token);
            break;
        case ")":
            // TODO What do we do with unbalanced parantheses?
            parenthesesStack.pop();
            break;
        case "+":
        case "-":
        case "*":
        case "/":
        case "^":
            operatorStack.push(token);
            break;
        /*
         * We assume that the token is a number if it fails to match a known
         * arithmetic operator.
         */
        default:
            if (true == operatorStack.isEmpty()
            &&  true == valueStack.isEmpty()
            ) {
                valueStack.push(token);
                break;
            }
            valueStack.push(
                String.valueOf(this.valueOperation(valueStack.pop(), token))
            );
        }
    }
    return Double.parseDouble(this.valueStack.pop());
}
double valueOperation(String firstValue, String secondValue) {
    double output = 0;
    switch (this.operatorStack.pop()) {
    case "+":
        output =
            Double.parseDouble(firstValue) + Double.parseDouble(secondValue);
        break;
    case "-":
        output =
            Double.parseDouble(firstValue) - Double.parseDouble(secondValue);
        break;
    case "*":
        output =
            Double.parseDouble(firstValue) * Double.parseDouble(secondValue);
        break;
    case "/":
        output =
            Double.parseDouble(firstValue) / Double.parseDouble(secondValue);
        break;
    case "^":
        output = Math.pow(
            Double.parseDouble(firstValue),
            Double.parseDouble(secondValue)
        );
        break;
    default:
    }
    return output;
}
public static void main(String[] args) throws Exception
{
    InfixEvaluator infix = new InfixEvaluator();
    System.out.print("Please enter an arithmetic expressions: ");
    Scanner input        = new Scanner(System.in);
    String exp           = input.nextLine();
    System.out.println("The result is: " + infix.evaluateInfix(exp));
}
}
