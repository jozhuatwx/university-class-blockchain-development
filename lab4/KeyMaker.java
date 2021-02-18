package lab4;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyMaker {
  KeyPairGenerator keyPairGenerator;
  KeyPair keyPair;

  public KeyMaker() throws Exception {
    keyPairGenerator = KeyPairGenerator.getInstance(Config.ALGORITHM);
    keyPairGenerator.initialize(1024);
  }

  public static void makeKeyPair() {
    try {
      KeyMaker keyMaker = new KeyMaker();
      keyMaker.keyPair = keyMaker.keyPairGenerator.generateKeyPair();

      PublicKey publicKey = keyMaker.keyPair.getPublic();
      PrivateKey privateKey = keyMaker.keyPair.getPrivate();

      // String puk = Base64.getEncoder().encodeToString(publicKey.getEncoded());
      // System.out.println("Public Key: " + puk);
      // String prk = Base64.getEncoder().encodeToString(privateKey.getEncoded());
      // System.out.println("Private Key: " + prk);

      saveKeyPair(Config.PUBLIC_KEY_FILE, publicKey.getEncoded());
      saveKeyPair(Config.PRIVATE_KEY_FILE, privateKey.getEncoded());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void saveKeyPair(String path, byte[] key) {
    File file = new File(path);
    file.getParentFile().mkdirs();
    try {
      Files.write(Paths.get(path), key, StandardOpenOption.CREATE);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
