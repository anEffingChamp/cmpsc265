import java.util.*;
/*
 * Write a class that can implement the following: Given a stream of integers
 * and a window size, calculate the moving average of all integersin the sliding
 * window.
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 * Outputs:Your
 * outputs should look something as follows.$ java MovingAveragePlease enter a
 * number to specify the size of the window: 3Please enter a number to be added
 * into the window: 1The average after adding the above number is: 1.0Please
 * enter a number to be added into the window: 10The average after adding the
 * above number is: 5.5Please enter a number to be added into the window: 3The
 * average after adding the above number is: 6.0
 */
class MovingAverage
{
int[] values;
int valuePosition;
/** Initialize your data structure here. */
public MovingAverage(int size)
{
    this.values        = new int[size];
    this.valuePosition = 0;
}
public double next(int input)
{
    this.values[valuePosition] = input;
    this.valuePosition++;

    double output = 0;
    for (int loop = 0;
    loop < valuePosition;
    loop++
    ) {
        output = (output + this.values[loop]);
    }
    return output / (double) this.valuePosition;
}
public static void main(String[] args)
{
    System.out.println(
        "Please enter a number to specify the size of the window:"
    );
    Scanner userInput     = new Scanner(System.in);
    int averageCount      = userInput.nextInt();
    MovingAverage average = new MovingAverage(averageCount);
    for (int loop = 0;
    loop < averageCount;
    loop++
    ) {
        System.out.print("Please enter a number to add to the window: ");
        System.out.println(
            "The average after adding the above number is " +
            average.next(userInput.nextInt())
        );
        System.out.println("");
    }
}
}
