package lab3;

public class Lab3 {
  public static void main(String[] args) {
    SymmetricCryptography crypto = new SymmetricCryptography();

    String data = "SampleData";
    String encrypted = crypto.encrypt(data);
    System.out.println(encrypted);

    String decrypted = crypto.decrypt(encrypted);
    System.out.println(decrypted);
  }
}
