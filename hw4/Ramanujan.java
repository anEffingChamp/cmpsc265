import java.util.*;
public class Ramanujan
{
/**
 * Srinivasa Ramanujanwas an Indian mathematician who became famous for his
 * intuition for numbers. When the English mathematician G. H. Hardy came to
 * visit him one day, Hardy remarked that the number of his taxi was 1729, a
 * rather dull number. To which Ramanujan replied, "No, Hardy! It is a very
 * interesting number. It is the smallest number expressible asthe sum of two
 * cubes in two different ways.Since:1729 = 1^3 + 12^3 = 9^3 + 10^3
 *
 * Please finish
 * writing the program Ramanujan.java using a minimum-oriented PriorityQueue to
 * find all such numbers that are less than or equal to N and that each can be
 * expressed asthe sum of two cubes in two different ways. In other words, find
 * distinct positive integers i, j, k, and lsuch that i3+ j3= k3+ l3.
 */
// A data type that encapsulates a pair of numbers (i, j)
// and the sum of their cubes, ie, i^3 + j^3.
private static class Pair implements Comparable<Pair>
{
private int i;          // first element of the pair
private int j;          // second element of the pair
private int sumOfCubes; // i^3 + j^3
// Construct a pair (i, j).
Pair(int i, int j)
{
    this.i = i;
    this.j = j;
    sumOfCubes = i * i * i + j * j * j;
}
// Compare this pair to the other by sumOfCubes.
public int compareTo(Pair other)
{
    return sumOfCubes - other.sumOfCubes;
}
}
public static void main(String[] args) throws Exception
{
    System.out.print("Please enter a number: ");
    PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
    Scanner userInput         = new Scanner(System.in);
    int userInputValue        = userInput.nextInt();
    int userInputRoot         = (int) Math.cbrt(userInputValue);
    for (int loop = 1;
    loop < userInputRoot;
    loop++
    ) {
        queue.add(new Pair(loop, loop + 1));
    }
    while (1 < queue.size()) {
        Pair control = queue.remove();
        Pair other   = queue.peek();
        if (0              == control.compareTo(other)
        &&  userInputValue >= control.sumOfCubes
        ) {
            System.out.println(
                control.sumOfCubes + " = " + control.i + "^3 + " + control.j
                + "^3 = " + other.i + "^3 + " + other.j + "^3"
            );
        }
        if (userInputRoot > control.j) {
            queue.add(new Pair(control.i, control.j + 1));
        }
    }
}
}
