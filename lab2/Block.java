package lab2;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;

public class Block {
  public static int count;

  private int index;
  private String data;
  private String hash, previousHash;
  private long timeStamp;

  public Block(String data, String previousHash) throws Exception {
    this.index = count;
    count++;
    this.data = data;
    this.previousHash = previousHash;
    this.timeStamp = new Timestamp(System.currentTimeMillis()).getTime();

    byte[] blockBytes = Block.getBytes(this);
    if (blockBytes != null) {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byteArrayOutputStream.write(blockBytes);
      byteArrayOutputStream.write(previousHash.getBytes());
      byteArrayOutputStream.write(Long.toString(timeStamp).getBytes());
      this.hash = Hasher.hash(byteArrayOutputStream.toByteArray(), "SHA-256");
    } else {
      throw new Exception("Unable to generate current block hash!");
    }
  }

  private static byte[] getBytes(Block block) {
    try (
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
    ) {
      objectOutputStream.writeObject(block);
      return byteArrayOutputStream.toByteArray();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public static int getCount() {
    return count;
  }

  public static void setCount(int count) {
    Block.count = count;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public String getPreviousHash() {
    return previousHash;
  }

  public void setPreviousHash(String previousHash) {
    this.previousHash = previousHash;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }

  @Override
  public String toString() {
    return "Block {" + "index = " + index + ", data = '" + data + '\'' + ", hash = '" + hash + '\'' + ", previousHash = '" + previousHash + '\'' + ", timeStamp = " + timeStamp + "}";
  }
}
