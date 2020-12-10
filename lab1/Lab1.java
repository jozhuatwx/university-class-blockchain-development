package lab1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Lab1 {
  public static void main(String[] args) {
    HashSetDemo();
    LinkedListDemo();
    LinkedListMapDemo();
  }

  public static void HashSetDemo() {
    HashSet<String> lst = new HashSet<>();

    lst.add("ironman");
    System.out.println("ironman".hashCode());

    lst.add("spiderman");
    System.out.println("spiderman".hashCode());

    lst.add("antman");
    System.out.println("antman".hashCode());

    lst.add("captain america");
    System.out.println("captain america".hashCode());

    System.out.println(lst);
    System.out.println(lst.hashCode());
  }

  public static void LinkedListDemo() {
    LinkedList<String> lst = new LinkedList<>();

    lst.add("ironman");
    System.out.println("ironman".hashCode());

    lst.add("spiderman");
    System.out.println("spiderman".hashCode());

    lst.add("antman");
    System.out.println("antman".hashCode());

    lst.add("captain america");
    System.out.println("captain america".hashCode());

    System.out.println(lst);
    System.out.println(lst.hashCode());
  }

  public static void LinkedListMapDemo() {
    LinkedList<HashMap<String, Integer>> lst = new LinkedList<>();

    for (int i = 0; i < 5; i++) {
      HashMap<String, Integer> map = new HashMap<>();
      String value = String.format("APU%d", i);
      Integer hash = value.hashCode();

      map.put(value, hash);
      lst.add(map);
    }

    for (HashMap<String,Integer> elem : lst) {
      System.out.println(elem);
    }
  }
}
