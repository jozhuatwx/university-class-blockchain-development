package lab5;

public class Lab5 {
  public static void main(String[] args) {
    // basic digital signature
    BasicDigitalSignature basicDigitalSignature = new BasicDigitalSignature();

    String message = "How is your semester?";
    String digitalSignature = basicDigitalSignature.encrypt(basicDigitalSignature.hash(message));
    System.out.println("Message: " + message);
    System.out.println("Digital Signature: " + digitalSignature);

    System.out.println(basicDigitalSignature.verify(message, digitalSignature) + "\n");

    // my signature
    MySignature mySignature = new MySignature();

    digitalSignature = mySignature.sign(message);
    System.out.println("Message: " + message);
    System.out.println("Digital Signature: " + digitalSignature);

    System.out.println(mySignature.verify(message, digitalSignature));
  }
}
