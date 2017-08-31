import java.util.Arrays;

/**
 *
 * https://projecteuler.net/problem=79
 *
 * A common security method used for online banking is to ask the user for three random characters
 * from a passcode. For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th
 * characters; the expected reply would be: 317.
 *
 * The text file, keylog.txt, contains fifty successful login attempts.
 *
 * Given that the three characters are always asked for in order, analyse the file so as to
 * determine the shortest possible secret passcode of unknown length.
 */
public class EulerProblem79 {

  // note : duplicated codes, but no repeated digits in any code
  private static int[] file = new int[] {319, 680, 180, 690, 129, 620, 762, 689, 762, 318, 368,
      710, 720, 710, 629, 168, 160, 689, 716, 731, 736, 729, 316, 729, 729, 710, 769, 290, 719,
      680, 318, 389, 162, 289, 162, 718, 729, 319, 790, 680, 890, 362, 319, 760, 316, 729, 380,
      319, 728, 716};

  public static void main(String... args) {


    int[] distinctShortCodes = Arrays.stream(file).distinct().toArray();

    int currentFullCode = 1000;

    for (int j = 0; j < 1_000_000_000; j++) {

      currentFullCode++;
      int currentDigits = (int) Math.floor(Math.log10(currentFullCode)) + 1;

      int reminder = currentFullCode;
      int[] fullCodeDigitsArray = new int[currentDigits];
      for (int index = currentDigits - 1; index >= 0; index--) {
        fullCodeDigitsArray[index] = reminder % 10;
        reminder /= 10;
      }

      boolean passed = true;

      for (int i = 0; i < distinctShortCodes.length; i++) {
        boolean test = testOne(fullCodeDigitsArray, distinctShortCodes[i]);
        if (!test) {
          passed = false;
          break;
        }
      }

      if (passed) {
        System.out.println("Found a matching number " + currentFullCode);
        break;
      }

      if (j % 1_000_000 == 0) {
        System.out.println("Nothing found so far");
      }

    }
  }

  private static boolean testOne(int[] fillCode, int shortCode) {
    int digit1 = shortCode / 100;
    int digit2 = shortCode % 100 / 10;
    int digit3 = shortCode % 10;

    int index1 = findIndex(fillCode, digit1);
    int index2 = findIndex(fillCode, digit2);
    int index3 = findIndex(fillCode, digit3);

    return index1 != -1 && index2 != -1 && index3 != -1 && index1 < index2 && index2 < index3;
  }

  private static int findIndex(int[] fullCode, int digit) {
    for (int i = 0; i < fullCode.length; i++) {
      if (fullCode[i] == digit) {
        return i;
      }
    }
    return -1;
  }
}
