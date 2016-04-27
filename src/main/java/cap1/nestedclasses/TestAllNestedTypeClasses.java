package cap1.nestedclasses;

import java.util.Comparator;

public class TestAllNestedTypeClasses {

  public static void main(String[] args) {
    System.out.println(new OuterClass().outerInstanceAttribute);
    System.out.println(OuterClass.outerStaticAttribute);

    //creating a instance of a nested static class to access a instance member
    OuterClass.NestedStaticClass nestedStaticClassObj = new OuterClass.NestedStaticClass();

    System.out.println(OuterClass.NestedStaticClass.staticAttribute);
    System.out.println(nestedStaticClassObj.instanceAttribute);
    System.out.println(OuterClass.NestedStaticClass.getStaticAttribute());
    System.out.println(nestedStaticClassObj.getInstanceAttribute());
    System.out.println(OuterClass.NestedStaticClass.getOuterStaticAttribute());
    //this method does not exist because it try to access a outer instance attribute instead of a static attribute
    //System.out.println(nestedStaticClassObj.getOuterInstanceAttribute());

    // ------------------------------------------------------------------------------ //

    //creating a instance of a nested inner class. this case always need an instance of the outer class
    OuterClass.NestedInnerMemberClass nestedInnerClassObj = new OuterClass().new NestedInnerMemberClass();

    System.out.println(OuterClass.NestedInnerMemberClass.staticAttribute);
    System.out.println(nestedInnerClassObj.instanceAttribute);
    //this method does not exist because inner classes can not declare static methods
    //System.out.println(OuterClass.NestedInnerMemberClass.getStaticAttribute());
    System.out.println(nestedInnerClassObj.getInstanceAttribute());
    //this method does not exist because inner classes can not declare static methods
    //System.out.println(OuterClass.NestedInnerMemberClass.getOuterStaticAttribute());
    System.out.println(nestedInnerClassObj.getOuterInstanceAttribute());
  }
}

class OuterClass {
  String outerInstanceAttribute;
  static String outerStaticAttribute;

  //only nested classes can be static. top level classes can not be static
  static class NestedStaticClass {
    String instanceAttribute;
    static String staticAttribute;
    String getInstanceAttribute() { return instanceAttribute; }
    static String getStaticAttribute() { return staticAttribute; }
    //String getOuterInstanceAttribute() { return outerInstanceAttribute; } //you can not refer to an outer instance attribute. only outer static.
    static String getOuterStaticAttribute() { return outerStaticAttribute; }
  }

  class NestedInnerMemberClass {
    String instanceAttribute;
    static final String staticAttribute = "";
    String getInstanceAttribute() { return instanceAttribute; }
    //static String getStaticAttribute() { return staticAttribute; } //you can not create static methods. only final attributes statics are allowed
    String getOuterInstanceAttribute() { return outerInstanceAttribute; }
    //static String getOuterStaticAttribute() { return outerStaticAttribute; } //idem comments above
  }

  void outerInstanceMethod() {
    class InnerLocalNestedClass {
    }
  }

  //type infer does not work with inner types. So we need to specify
  Comparator<Integer> innerAnonymousNestedClass = new Comparator<Integer>() {
    @Override public int compare(Integer i1, Integer i2) { return i1 - i2; }
  };
}
