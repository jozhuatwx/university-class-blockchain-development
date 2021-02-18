package lab4;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class AsymmetricCryptography {
  private Cipher cipher;
  
  public AsymmetricCryptography() {
    try {
      cipher = Cipher.getInstance(Config.ALGORITHM);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String encrypt(String input, PublicKey key) throws Exception {
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

  public String decrypt(String input, PrivateKey key) throws Exception {
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
}
