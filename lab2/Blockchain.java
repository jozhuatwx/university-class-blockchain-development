package lab2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

import com.google.gson.GsonBuilder;

public class Blockchain {
  private static final String BCHAIN_FILE = "./master/chain.dat";
  private static LinkedList<Block> database = new LinkedList<>();

  // write to the masterchain file
  private static void persist() {
    try (
      FileOutputStream fileOutputStream = new FileOutputStream(BCHAIN_FILE);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    ) {
      objectOutputStream.writeObject(database);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // obtain the existing chain
  public static LinkedList<Block> getChain() {
    try (
      FileInputStream fileOutputStream = new FileInputStream(BCHAIN_FILE);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileOutputStream);
    ) {
      return (LinkedList<Block>) objectInputStream.readObject();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void distribute() {
    String chain = new GsonBuilder()
      .setPrettyPrinting()
      .create()
      .toJson(database);

    try {
      Files.write(Paths.get("ledger.txt"), chain.getBytes(), StandardOpenOption.CREATE);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void nextBlock(Block newBlock) {
    Blockchain.database.add(newBlock);
    Blockchain.persist();
  }
}
