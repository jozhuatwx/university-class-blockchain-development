package lab5;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;

public class BasicDigitalSignature {
  private static final String CRYPTO_ALGORITHM = "RSA";
  private static final String HASHING_ALGORITHM = "SHA-256";

  private Cipher cipher;
  private KeyPairGenerator keyPairGenerator;
  private KeyPair keyPair;

  // constructor
  public BasicDigitalSignature() {
    try {
      cipher = Cipher.getInstance(CRYPTO_ALGORITHM);
      keyPairGenerator = KeyPairGenerator.getInstance(CRYPTO_ALGORITHM);
      keyPair = keyPairGenerator.generateKeyPair();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // hash
  public byte[] hash(String input) {
    byte[] output = null;

    try {
      MessageDigest md = MessageDigest.getInstance(HASHING_ALGORITHM);
      output = md.digest(input.getBytes());
    } catch (Exception e) {
      e.printStackTrace();
    }

    return output;
  }

  // encryption
  public String encrypt(byte[] input) {
    String encryptedText = null;
    try {
      // init
      cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());
      byte[] cipherBytes = cipher.doFinal(input);
      // convert byte[] to String
      encryptedText = Base64.getEncoder().encodeToString(cipherBytes);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return encryptedText;
  }

  // verify
  public boolean verify(String input, String encryptedHash) {
    byte[] dataHash = hash(input);
    byte[] decryptedHash = null;

    try {
      cipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());
      decryptedHash = cipher.doFinal(Base64.getDecoder().decode(encryptedHash));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return Arrays.equals(dataHash, decryptedHash);
  }
}
