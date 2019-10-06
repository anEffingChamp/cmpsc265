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
int[] queue;
public void getJosephus(int inputTotal, int inputCounter)
{
    if (0 >= inputTotal) {
        System.out.println("Every one lives!");
        return;
    }
    System.out.println("People will be eliminated in such a sequence: ");
    this.queue   = new int[inputTotal];
    int[] result = this._updateQueue(inputCounter, 0);
    while (1 < result[0]) {
        result = this._updateQueue(inputCounter, result[1]);
    }
}
private int[] _updateQueue(int inputCounter, int inputStart)
{
    int localCounter = inputStart;
    int localZeroes  = 0;
    for (int loop  = 0;
    loop          <= this.queue.length - 1;
    loop++
    ) {
        /*
         * 0 is the default value, so people at those positions are still alive.
         * We count the living until localCounter matches inputCounter, and then
         * mark that person with 1 since they are now eliminated.
         *
         * We run the loop again if more than one index is still 0.
         */
        if (0 == this.queue[loop]) {
            localCounter++;
            localZeroes++;
            if (localCounter == inputCounter) {
                this.queue[loop] = 1;
                localCounter     = 0;
                System.out.print(loop + " ");
            }
        }
    }
    /*
     * Ultimately we need to end the process as counter begins to outnumber the
     * active indices. In that case, we call this function recursively with a
     * smaller counter.
     */
    if (localZeroes > 1
    &&  localZeroes < inputCounter
    ) {
        int[] result = this._updateQueue(inputCounter, localCounter);
    }
    int[] output = new int[2];
    output[0]    = localZeroes;
    output[1]    = localCounter;
    return output;
}
public static void main(String[] args) throws Exception
{
    Josephus josephus = new Josephus();
    Scanner input     = new Scanner(System.in);
    System.out.print("Please enter a number for N indicating the total number of people: ");
    int N = input.nextInt();
    System.out.print("Please enter a number for M indicating the Mth person to be eliminated: ");
    int M = input.nextInt();
    josephus.getJosephus(N, M);
}
}
