import static java.util.stream.IntStream.range;

import java.util.OptionalInt;

/**
 * 
 * https://projecteuler.net/problem=4
 *
 * A palindromic number reads the same both ways. The largest palindrome made from the product of
 * two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class EulerProblem4 {

  public static void main(String... args) {

    OptionalInt maxPalindrome =
        range(100, 1000)
            .mapToObj(
                i -> range(100, 1000).map(j -> i * j).filter(EulerProblem4::isSixDigitPalindrome)
                    .max()).filter(OptionalInt::isPresent).mapToInt(OptionalInt::getAsInt).max();

    System.out.println(maxPalindrome.getAsInt());
  }

  /**
   * 
   * @param n
   */
  public static boolean isSixDigitPalindrome(final int n) {

    int left = n % 1000;
    int right = n / 1000;

    // swaps digits
    right = right % 10 * 100 + right % 100 / 10 * 10 + right / 100;

    return left == right;
  }
}
