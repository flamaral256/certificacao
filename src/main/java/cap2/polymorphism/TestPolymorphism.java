package cap2.polymorphism;

public class TestPolymorphism {
  public static void main(String[] args) {
    /* scenario 1 - a superclass object casts */
    Superclass superclass1 = new Superclass();
    //SomeInterface someinterface1 = superclass1; //compile error because there is no cast for this interface
    try {
      //cast for a interface is possible even when types are not related.(we know is not possible, but the compiler doesnt).
      SomeInterface someinterface1 = (SomeInterface) superclass1;
    } catch (ClassCastException e) {} //but in runtime we got a classcastexception
    //Subclass subclass1 = superclass1; //compile error because we need a cast when downing in the structure
    try {
      //compiles ok because this types are related but the object in memory is a superclass
      Subclass subclass1 = (Subclass) superclass1;
    } catch (ClassCastException e) {} //but in runtime we got a classcastexception
    //SomeUnrelatedClass unrelatedClass1 = superclass1; //compile error because this types are not related
    //SomeUnrelatedClass unrelatedClass1 = (SomeUnrelatedClass) superclass1; //still compile error because this types are not related even with cast

    /* scenario 2 - a subclass object casts */
    Subclass subclass2 = new Subclass();
    Superclass superclass2 = subclass2; //ok because we have upcast here automatic
    SomeInterface someinterface2 = subclass2; //ok because we have upcast here automatic
                //someinterface2 = superclass2; //compile error because we dont have a automatic cast here
                  someinterface2 = (SomeInterface) superclass2; //ok because we cast A OBJECT here not a reference.
    //Subclass subclass22 = superclass2; //compile error because we need a cast when downing in the structure
    Subclass subclass22 = (Subclass) superclass2; //ok because we cast A OBJECT here not a reference.
    //SomeUnrelatedClass unrelatedClass2 = subclass2; //compile error because this types are not related
    //SomeUnrelatedClass unrelatedClass2 = (SomeUnrelatedClass) subclass2; //still compile error because this types are not related even with cast

    /**
     * REMEMBER: only the atributes and methods of the type of the reference (not of the object) can be accessed
     */
  }
}

// Here are the elements of our test. A superclass, a subclass and an interface
class Superclass {
  String superclassAttr = "superclass";
  void superclassMethod() {}
}

interface SomeInterface {
  static final String someInterfaceConstant = "someInterfaceConstant";
  void someInterfaceMethod();
}

class Subclass extends Superclass implements SomeInterface {
  String subclassAttr = "subclass";
  void subclassMethod() {}

  @Override
  public void someInterfaceMethod() {};
}

class SomeUnrelatedClass {
}
