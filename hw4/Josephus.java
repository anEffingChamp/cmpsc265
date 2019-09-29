import java.util.*;
/**
 * In the Josephus problem from antiquity, N people are in dire straits and
 * agree to the following strategy to reduce the population. They arrange
 * themselves in a circle (at positions numbered from 0 to N - 1) and proceed
 * around the circle, eliminating every Mth person until only one person is
 * left. Legend has it that Josephus figured out where to sit to avoid being
 * eliminated. Finish theQueue client Josephus.java that takes N and M from
 * keyboardand prints out the order in which people are eliminated (and thus
 * would show Josephus where to sit in the circle).
 */
class Josephus
{
public void getJosephus(int N, int M)
{
// YOUR CODES
}
public static void main(String[] args) throws Exception
{
    Josephus josephus = new Josephus();
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a number for N indicating the total number of people: ");
    int N = input.nextInt();
    System.out.print("Please enter a number for M indicating the Mth person to be eliminated: ");
    int M = input.nextInt();
    josephus.getJosephus(N, M);
}
}
