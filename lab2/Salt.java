package lab2;

import java.security.SecureRandom;

public class Salt {
  private static final int SIZE = 16;

  public static byte[] generate() {
    SecureRandom random = new SecureRandom();
    byte[] b = new byte[SIZE];
    random.nextBytes(b);
    return b;
  }
}
