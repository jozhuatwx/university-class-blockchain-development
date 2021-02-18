package lab4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyAccess {
  public static PublicKey getPublicKey() throws Exception {
    byte[] keyBytes = Files.readAllBytes(Paths.get(Config.PUBLIC_KEY_FILE));
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
    return KeyFactory.getInstance(Config.ALGORITHM).generatePublic(keySpec);
  }

  public static PrivateKey getPrivateKey() throws Exception {
    byte[] keyBytes = Files.readAllBytes(Paths.get(Config.PRIVATE_KEY_FILE));
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
    return KeyFactory.getInstance(Config.ALGORITHM).generatePrivate(keySpec);
  }
}
