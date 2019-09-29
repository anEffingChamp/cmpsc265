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
String[] values;
String[] operators;
public double evaluateInfix(String input)
{
    this.values               = new String[2];
    this.operators            = new String[100];
    StringTokenizer tokenizer = new StringTokenizer(input, " ");
    while (true == tokenizer.hasMoreTokens()) {
        String token = tokenizer.nextToken();
        switch (token) {
        case "(":
            for (int loop  = 0;
            loop          <= this.operators.length - 1;
            loop++
            ) {
                if (null == this.operators[loop]) {
                    this.operators[loop] = token;
                    break;
                }
            }
            break;
        case "+":
        case "-":
        case "*":
        case "/":
        case "^":
            this.operators[99] = token;
            break;
        case ")":
            for (int loop  = this.operators.length - 1;
            loop          >= 0;
            loop--
            ) {
                if ("(" == this.operators[loop]) {
                    this.operators[loop] = null;
                    break;
                }
                if (0 == loop) {
                    System.out.println("We are missing a (");
                    return 0;
                }
            }
            break;
        /*
         * We assume that the token is a number if it fails to match a known
         * arithmetic operator.
         */
        default:
            if ("1" == this.values[1]) {
                this.values[0] = String.valueOf(
                    this.valueOperation(this.values[0], token)
                );
                this.values[1] = null;;
                break;
            }
            if (null == this.values[1]) {
                this.values[0] = token;
                this.values[1] = "1";
            }
        }
    }
    return Double.parseDouble(this.values[0]);
}
double valueOperation(String firstValue, String secondValue) {
    double output = 0;
    switch (this.operators[99]) {
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
