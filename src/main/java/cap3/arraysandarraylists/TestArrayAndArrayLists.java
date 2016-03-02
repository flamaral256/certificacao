package cap3.arraysandarraylists;

import java.util.Arrays;
import java.util.List;

public class TestArrayAndArrayLists {
  public static void main(String[] args) {
    String[] array = {"Fernando", "Amaral"};
    List<String> list = Arrays.asList(array); // <--this returns a internal implementation of ArrayList as a static nested class.
    array[0] = "Epopeia";
    list.set(1, "IO");
    System.out.println(list); // <--must shows bouth indexes altered cuz we have the reference of array externally
    String[] array2 = (String[]) list.toArray(); // <--returns a clone of internal array. so it is other object
    array2[0] = "List";
    array2[1] = "Unmodified";
    System.out.println(list);
    list.remove(1); // <-- not supported, cuz is a fixed size implementation and not the ArrayList actually
  }
}
