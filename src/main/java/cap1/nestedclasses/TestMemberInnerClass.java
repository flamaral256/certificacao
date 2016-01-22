package cap1.nestedclasses;

//Inner classes are not static and are in the same level of the class
public class TestMemberInnerClass {

  private String outerFieldMember = "outer Field Member";

  private //may also be default protected or public
  //may also be abstract or final
  class MemberInnerClass
  //may also extends class
  //may also implements interfaces
  {
    //private static String staticMemberNotAllowed = "You cant do this!"; //compile error
    //private static void staticMethodNotAllowed() {} //compile error
    private String getOuterFieldMember() {return outerFieldMember;}
  }

  private class A {
    private int x = 10; //instance variable with the same name between inner classes
    private class B {
      private int x = 20; //instance variable with the same name between inner classes
      private class C {
        private int x = 30; //instance variable with the same name between inner classes
        private void printAllx() {
          System.out.println(x); //implicit C.this.x, prints 30
          System.out.println(this.x); //implicit C.this.x, prints 30
          System.out.println(B.this.x); //refers B instance x, prints 20
          System.out.println(A.this.x); //refers A instance x, prints a0
        }
      }
    }
  }

  //this interface can only be implemented by a inner class of this class
  private interface Secret {
    public abstract void doIt();
  }

  private class TestPrivateInterface implements Secret {
    @Override
    public void doIt() {
      System.out.println("Test implementation of a private interface");
    }
  }

  public void callInner() {
    MemberInnerClass inner = new MemberInnerClass();
    System.out.println(inner.getOuterFieldMember());
  }

  public static void main(String[] args) {
    TestMemberInnerClass test = new TestMemberInnerClass();
    test.new MemberInnerClass(); //another option to create an instance of inner class
    test.callInner();

    //how to declare and instanciate inner classes
    //TestMemberInnerClass.A a = test.new A(); //Its ok, but redundant because A is in the same level of TestMemberInnerClass
    A a = test.new A(); //implicitally refers to TestMemberInnerClass.A, but because it's in the same level does'nt neet declare TestMemberInnerClass
    A.B b = a.new B();
    A.B.C c = b.new C();
    c.printAllx();

    test.new TestPrivateInterface().doIt();
  }
}
