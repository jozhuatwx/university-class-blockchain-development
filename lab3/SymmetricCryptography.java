package lab3;

import java.security.Key;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SymmetricCryptography {
  private final static String ALGORITHM = "AES";
  private final static String SECRET_KEY = RandomSecretKey.generateSecretKey(ALGORITHM);

  private static Key generateKey() {
    return new SecretKeySpec(Arrays.copyOf(SECRET_KEY.getBytes(), 16), ALGORITHM);
  }

  private Cipher cipher;
  private Key key;

  // constructor
  public SymmetricCryptography() {
    try {
      cipher = Cipher.getInstance(ALGORITHM);
      key = generateKey();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // encryption
  public String encrypt(String input) {
    String encryptedText = null;
    try {
      // init
      cipher.init(Cipher.ENCRYPT_MODE, key);
      byte[] cipherBytes = cipher.doFinal(input.getBytes());
      // convert byte[] to String
      encryptedText = Base64.getEncoder().encodeToString(cipherBytes);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return encryptedText;
  }

  // decryption
  public String decrypt(String input) {
    String decryptedText = null;
    try {
      // init
      cipher.init(Cipher.DECRYPT_MODE, key);
      byte[] dataBytes = cipher.doFinal(Base64.getDecoder().decode(input));
      // convert byte[] to String
      decryptedText = new String(dataBytes);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return decryptedText;
  }

  public String getKey() {
    return Base64.getEncoder().encodeToString(key.getEncoded());
  }
}
