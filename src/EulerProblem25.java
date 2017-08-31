import java.math.BigInteger;

/**
 *
 * https://projecteuler.net/problem=25
 *
 * The Fibonacci sequence is defined by the recurrence relation:
 * 
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * 
 * The 12th term, F12, is the first term to contain three digits.
 * 
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class EulerProblem25 {


  public static void main(String... args) {


    BigInteger Fn_2 = new BigInteger("1");
    BigInteger Fn_1 = new BigInteger("1");

    int n = 3;

    while (true) {

      BigInteger Fn = Fn_1.add(Fn_2);

      if (Fn.toString().length() >= 1000) {
        System.out.println(n);
        break;
      }
      n++;
      Fn_2 = Fn_1;
      Fn_1 = Fn;
    }

  }

}
