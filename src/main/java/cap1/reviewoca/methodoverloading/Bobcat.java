package cap1.reviewoca.methodoverloading;

interface A {
}

interface B {
}

public class Bobcat {
  protected void findDen() { System.out.println("no args"); }
  protected void findDen(Double d) { System.out.println("wrapper double"); }
  protected void findDen(long l) { System.out.println("long"); }
  protected void findDen(A a) { System.out.println("a"); }
  protected void findDen(B b) { System.out.println("b"); }
}
