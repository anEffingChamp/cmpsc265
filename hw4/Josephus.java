import java.util.*;

class Josephus {
  public void getJosephus(int N, int M){
    // YOUR CODES
  }
  
  public static void main(String[] args) throws Exception {
    Josephus josephus = new Josephus();
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a number for N indicating the total number of people: ");
    int N = input.nextInt();
    System.out.print("Please enter a number for M indicating the Mth person to be eliminated: ");
    int M = input.nextInt();
    josephus.getJosephus(N, M);
  }
}