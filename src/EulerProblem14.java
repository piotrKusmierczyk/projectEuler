import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://projecteuler.net/problem=14
 *
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even) n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1 It can be seen that this sequence (starting at 13 and
 * finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is
 * thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest sequence?
 * 
 * NOTE: Once the sequence starts the terms are allowed to go above one million.
 */
public class EulerProblem14 {

  public static void main(String... args) {
    System.out.println(longestSequenceStart(1_000_000));
  }

  private static int longestSequenceStart(int N) {

    /**
     * Will map integers to nodes that remember the origin and length of the largest tested sequence
     * start, that contains the key integer.
     * 
     * So basically memorizing the longest patch to each tested integer.
     * 
     * Using longs since this problem apparently overflows.
     */
    Map<Long, ChainNode> sequenceMap = new HashMap<>();

    sequenceMap.put(1L, new ChainNode(1, 0));

    for (int sequenceStart = 1; sequenceStart < N; sequenceStart++) {

      long sequenceValue = sequenceStart;
      int sequenceLength = 0;

      do {

        if (sequenceMap.containsKey(sequenceValue)) {

          if (!sequenceMap.get(sequenceValue).accept(sequenceStart, sequenceLength)) {
            break;
          }

        } else {
          sequenceMap.put(sequenceValue, new ChainNode(sequenceStart, sequenceLength));
        }

        sequenceValue = sequenceNext(sequenceValue);
        sequenceLength++;

      } while (sequenceValue > 1);
      sequenceMap.get(1L).accept(sequenceStart, sequenceLength);

    }

    return (int) sequenceMap.get(1L).sequenceHighestStartingValue;
  }

  private static class ChainNode {

    int sequenceLength;
    long sequenceHighestStartingValue;

    public ChainNode(long sequenceStartingValue, int sequenceLength) {
      this.sequenceLength = sequenceLength;
      this.sequenceHighestStartingValue = sequenceStartingValue;
    }

    public boolean accept(long sequenceStartingValue, int sequenceLength) {
      if (sequenceLength > this.sequenceLength
          ||
          // the question asks for the largest value
          sequenceLength == this.sequenceLength
          && sequenceHighestStartingValue < sequenceStartingValue) {

        this.sequenceLength = sequenceLength;
        this.sequenceHighestStartingValue = sequenceStartingValue;
        return true;
      }

      return false;
    }
  }

  private static long sequenceNext(long n) {
    if (n % 2 == 0) {
      return n / 2;
    } else {
      return 3 * n + 1;
    }
  }
}
