package cap3.wrappers;

import java.util.List;
import java.util.ArrayList;

public class TestWrappers {
  public static void main(String[] args) {
    Byte B = (byte) 1; //autoboxing
    byte b = new Byte(B); //unboxing
    System.out.println(B);
    System.out.println(b);

    // pay attention on this trick
    List<Byte> bytes = new ArrayList<>();
    bytes.add(new Byte((byte)1));
    bytes.add(new Byte((byte)3));
    bytes.add((byte)7); // <-- autoboxing before list add it
    bytes.remove((byte)1); // <-- thats the trick. this remove the element on index 1 instead of autoboxing for a wrapper
                           // and call the method remove(Object). The compiler calls the most near overloaded method matches.
    bytes.remove(new Byte((byte)7)); // <---- the correct is this to call the method of a object argument
    System.out.println(bytes);

    byte b1 = bytes.get(0);
    System.out.println(b1);
  }
}
