package cap3.collection;

import java.util.List;
import java.util.ArrayList;

public class TestList {
  public static void main(String[] args) {
    // Lists add the power of indexes to collection
    // with indexes u can get/set a specific object, remove and add (such case override if there is an object at the index) etc
    // also u have methods to find a specific index
    List<String> ls = new ArrayList<>(); //an unsafed thread implementation of older Stack and Vector
    //List<String> ls = new LinkedList<>(); //a special list that is also a queue, but slower ArrayList

    ls.add("Fernando"); // calls from Collection and return true
    ls.add(1, "Amaral"); // calls from List and return void. repair how the list add the index feature

    System.out.println(ls.get(0));
    System.out.println(ls.set(1, "Epopeia")); //return Amaral and set Epopeia in the place
    System.out.println(ls);

    System.out.println(ls.indexOf("Fernando"));
    ls.add("Fernando"); // no problem, lists accept duplicated objects
    System.out.println(ls.lastIndexOf("Fernando"));
  }
}
