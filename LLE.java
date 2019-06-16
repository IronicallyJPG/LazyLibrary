
package Main;

import java.util.*;

public class LLE {

  /**
   * Encryption/Hashing Class
   */
  public LLE() {
    LL.LL_LINK();
  }

  //
  public int GenerateCaesarShiftKey(long SeedForRandom) {
    Random r = new Random();
    r.setSeed(SeedForRandom);
    int a = r.nextInt(10) + 2;
    int b = r.nextInt(10) + 2;
    return (a * b) * 3;
  }

  // ==============================================================
  public String encrypt(String msg, int shiftKey) {
    char[] rebuilt = new char[msg.length()];
    for (int h = 0; h < msg.length(); h++) {
      rebuilt[h] = ((char) (msg.toCharArray()[h] + (shiftKey)));
    }
    return String.copyValueOf(rebuilt);
  }

  // ==================================================================
  public String decrypt(String msg, int shiftKey) {
    char[] rebuilt = new char[msg.length()];
    for (int h = 0; h < msg.length(); h++) {
      rebuilt[h] = ((char) (msg.toCharArray()[h] - (shiftKey)));
    }
    return String.copyValueOf(rebuilt);
  }

}
