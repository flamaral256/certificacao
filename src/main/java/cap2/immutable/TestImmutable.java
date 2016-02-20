package cap2.immutable;

import java.util.List;
import java.util.ArrayList;

public class TestImmutable {
  public static void main(String[] args) {
    Immutable immutable = new Immutable(33, "Fernando", new ArrayList<Integer>());
  }
}

// 1 - the class must me final to avoid inherance of methods
final class Immutable {

  // 2 - the attributes must me private and final
  private final int someInt;
  private final String someString;
  private final List<Integer> someList;

  // 3 - we must set the attributes by constructor instead setters
  public Immutable(int someInt, String someString, List<Integer> someList) {
    // take care of the input references to avoid (by copy) external handling
    this.someInt = someInt; //ok primitives are passed by value
    this.someString = someString; //ok String already is immutable
    //this.someList = someList //NOK, clients may modify the list externally having the reference
    if (someList == null)
      throw new RuntimeException("someList is required"); //only for know the state
    this.someList = new ArrayList<Integer>(someList); //ok, 4 - we create a new List reference coping the values
  }

  // ok primitivies we return by value
  int getSomeInt() {
    return someInt;
  }

  // ok Strings are immutable
  String getSomeString() {
    return someString;
  }

  // NOK, we can not return internal references
  //List<Integer> getSomeList() {
    //return someList;
  //}

  // 5 - we may return only different references of ower internal references
  List<Integer> getSomeList() {
    return new ArrayList<Integer>(this.someList);
    // we also could copy all values for a external reference or even return a index of some element
  }

  Immutable addInt(int fator) {
    // when we need to change the object actually we return a new instance of it with de values modified
    return new Immutable(this.someInt + fator, this.someString, this.someList);
  }
}
