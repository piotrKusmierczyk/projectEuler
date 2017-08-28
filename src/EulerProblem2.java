/**
 * 
 * https://projecteuler.net/problem=2
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By
 * starting with 1 and 2, the first 10 terms will be:
 * 
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find
 * the sum of the even-valued terms.
 * 
 */
public class EulerProblem2 {

  public static void main(String... args) {

    long ans = 0;
    int f1 = 0;
    int f2 = 1;

    while (f2 < 4_000_000) {

      if (f2 % 2 == 0) {
        ans += f2;
      }
      int swap = f2;
      f2 = f2 + f1;
      f1 = swap;
    }

    System.out.println(ans);
  }
}
