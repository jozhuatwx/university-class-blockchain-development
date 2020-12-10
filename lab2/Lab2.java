package lab2;

public class Lab2 {
  public static void main(String[] args) {
    String password = "password";
    System.out.println("Password: " + password);

    String hashMD5 = Hasher.hash(password, "MD5");
    System.out.println("MD5: " + hashMD5);

    String hashSHA256 = Hasher.hash(password, "SHA-256");
    System.out.println("SHA256: " + hashSHA256);

    String hashSHA512 = Hasher.hash(password, "SHA-512");
    System.out.println("SHA512: " + hashSHA512);
  }
}
