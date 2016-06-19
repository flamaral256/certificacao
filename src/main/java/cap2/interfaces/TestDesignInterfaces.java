package cap2.interfaces;

import java.util.List;
import java.util.ArrayList;

public class TestDesignInterfaces {
  public static void main(String[] args) {
    System.out.println(new Impl().getSomeDouble());
    System.out.println(new Impl().getSomeList());
  }
}

class Impl implements A, B, C {
  @Override
  public double getSomeDouble() {
    return 33.0;
  }

  @Override
  public List<Integer> getSomeList() {
    return new ArrayList<Integer>();
  }
}

interface A {
  static final String s = "constant";

  static int getSomeInt() { //now we can write static methods in interfaces,
  // but because a class can implement multiples interfaces a class can not call this static method.
    return 33;
  }

  default long getSomeLong() {
    return 33l;
  }

  // implicit public abstract for non-static and non-default methods
  double getSomeDouble();

  List<Integer> getSomeList();
}

interface B {
  double getSomeDouble() throws Exception;

  // nok, B not override from anyone. If some class implements A and B we got a compile error due to two defaults methods
  // The compiler says that getSomeLong method is not related between types A and B
  //default long getSomeLong() {
  //  return 33l;
  //}
}

interface C extends A {
  // ok, we can redeclare the same method from interface A
  double getSomeDouble();

  // ok, we override the default method from A. So it counts with one in the end
  // We say that getSomeLong method is related between types A and C
  default long getSomeLong() {
    return 33l;
  }
}
