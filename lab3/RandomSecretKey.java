package lab3;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RandomSecretKey {
  public static String generateSecretKey(String algorithm) {
    String secretKeyString = null;
    try {
      KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
      keyGenerator.init(256, new SecureRandom());
      SecretKey secretKey = keyGenerator.generateKey();
      secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return secretKeyString;
  }
}
