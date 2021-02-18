package lab4;

public class Lab4 {
  public static void main(String[] args) throws Exception {
    // KeyMaker.makeKeyPair();

    AsymmetricCryptography crypto = new AsymmetricCryptography();
    String data = "SampleData";

    String encrypted = crypto.encrypt(data, KeyAccess.getPublicKey());
    System.out.println(encrypted);

    String decrypted = crypto.decrypt(encrypted, KeyAccess.getPrivateKey());
    System.out.println(decrypted);
  }
}
