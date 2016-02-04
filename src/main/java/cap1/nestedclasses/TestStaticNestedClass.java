package cap1.nestedclasses;

// you might import a static nested class like any other class and also as a static class
//import cap1.nestedclasses.TestStaticNestedClass.NestedClass; //regular import
//import static cap1.nestedclasses.TestStaticNestedClass.NestedClass; //static import

//Static nested classes are defined in the same level of static variables
public class TestStaticNestedClass {

  static class NestedClass {
    private static int staticNumber = 3;
    private int instanceNumber = 33;
  }

  public static void main(String[] args) {
    System.out.println(NestedClass.staticNumber);

    // we can access a static nested class without a instance of an outer class
    System.out.println(new NestedClass().instanceNumber);
  }
}
