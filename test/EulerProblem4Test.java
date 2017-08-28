import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class EulerProblem4Test {

  @Test
  public void testSixDigitPalindromes() {

    assertTrue(EulerProblem4.isSixDigitPalindrome(666666));
    assertTrue(EulerProblem4.isSixDigitPalindrome(100001));
    assertTrue(EulerProblem4.isSixDigitPalindrome(123321));

    assertFalse(EulerProblem4.isSixDigitPalindrome(100002));
    assertFalse(EulerProblem4.isSixDigitPalindrome(123456));
  }
}
