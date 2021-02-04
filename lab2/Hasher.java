package lab2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
  private static MessageDigest md;

  public static String hash(byte[] input, String algorithm) {
    String output = null;

    try {
      md = MessageDigest.getInstance(algorithm);
      // feed in the input byte[] to md
      md.update(input);
      // add salt
      md.update(Salt.generate());
      // generate hash output
      byte[] hashBytes = md.digest();
      // convert to hexformat
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < hashBytes.length; i++) {
        sb.append(Integer.toHexString(0xFF & hashBytes[i]));
      }
      output = sb.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return output;
  }
}
