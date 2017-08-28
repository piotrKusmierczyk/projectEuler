import java.util.stream.IntStream;

/**
 * 
 * https://projecteuler.net/problem=3
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 */
public class EulerProblem3 {

  public static void main(String... args) {

    long largeNumber = 600_851_475_143L;

    int[] primes = findLowPrimes(1_000_000);
    // brute forced but works
    for (int i = primes.length - 1; i >= 0; i--) {
      if (largeNumber % primes[i] == 0) {
        System.out.println(primes[i]);
        break;
      }
    }
  }

  /**
   * Eratosthenes sieve for finding primes
   *
   * @param n -1 is the largest number checked for being a prime
   * @return
   */
  private static int[] findLowPrimes(final int n) {

    final boolean[] multiples = new boolean[n];
    for (int i = 2; i < n; i++) {
      if (!multiples[2]) {
        for (int j = 2 * i; j < n; j += i) {
          multiples[j] = true;
        }
      }
    }

    return IntStream.range(2, n).filter(i -> !multiples[i]).toArray();
  }
}
