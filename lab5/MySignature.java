package lab5;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;

public class MySignature {
  private static final String SIGNATURE_ALGRORITHM = "SHA256WithRSA";
  private static final String CRYPTO_ALGRORITHM = "RSA";

  private Signature signature;
  private KeyPairGenerator keyPairGenerator;
  private KeyPair keyPair;

  // constructor
  public MySignature() {
    try {
      signature = Signature.getInstance(SIGNATURE_ALGRORITHM);
      keyPairGenerator = KeyPairGenerator.getInstance(CRYPTO_ALGRORITHM);
      keyPair = keyPairGenerator.generateKeyPair();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // sign
  public String sign(String input) {
    String signedText = null;
    try {
      signature.initSign(keyPair.getPrivate());
      signature.update(input.getBytes());
      signedText = Base64.getEncoder().encodeToString(signature.sign());
    } catch (Exception e) {
      e.printStackTrace();
    }

    return signedText;
  }

  // verify
  public boolean verify(String input, String encryptedHash) {
    try {
      signature.initVerify(keyPair.getPublic());
      signature.update(input.getBytes());
      return signature.verify(Base64.getDecoder().decode(encryptedHash));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
