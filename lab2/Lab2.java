package lab2;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.tools.javac.Main;

public class Lab2 {
  public static void main(String[] args) {
    
  }

  static void test1() {
    try {
      Block genesis = new Block("sample_data1", "0");
      Blockchain.nextBlock(genesis);

      Block b1 = new Block("sample_data2", Blockchain.getChain().getLast().getHash());
      Blockchain.nextBlock(b1);
    } catch (Exception e) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      Blockchain.distribute();
    }
  }

  static void test2() {
    try {
      String previousHash = Blockchain.getChain().getLast().getHash();
      System.out.println("Previous hash: " + previousHash);

      Block b2 = new Block("sample_data3", previousHash);
      Blockchain.nextBlock(b2);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      Blockchain.distribute();
    }
  }
}
