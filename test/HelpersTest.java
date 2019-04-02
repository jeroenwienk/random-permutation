import nl.jwienk.permutaties.utils.Helpers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HelpersTest {

  @org.junit.Test
  public void isUniqueArray() {
    int[] arr = {0, 1, 2, 3};
    assertTrue(Helpers.isUniqueArray(arr));
  }

  @org.junit.Test
  public void isNotUniqueArray() {
    int[] arr = {0, 0, 2, 3};
    assertFalse(Helpers.isUniqueArray(arr));
  }


}