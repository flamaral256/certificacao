package cap1.reviewoca.methodoverloading;

/**
 * Overloading rules:
 *
 * Call the specific type in subclass
 * Call the specific type in superclass
 * Call the closest type in subclass
 * Call the closest type in superclass
 * Call the primitives first
 * Call the wrappers
 * Compiler error if more than one method matches for a type
 */
public class BobcatKitten extends Bobcat {
  protected void findDen(Dummy dummy) { System.out.println("dummy"); }

  public static void main(String[] args) {
    Bobcat bobcat = new BobcatKitten();
    Dummy dummy = new Dummy();

    //nok, superclass reference has more than one method that matches
    //bobcat.findDen(dummy);

    //ok, subclass reference has only one method of type Dummy
    //((BobcatKitten)bobcat).findDen(dummy);

    //ok, we solve ambiguous between methods specifing the exact type by cast
    //bobcat.findDen((A)dummy);

    //ok, compiler call the closest method in subclass or superclass. In this case long
    int i = 33;
    //bobcat.findDen(i);

    //ok, compiler call the Double wrapper argument since it is the closest of primitive double
    //bobcat.findDen((double)i);

    //nok, compiler consideres null as a reference of some type. In this case might be type A or B
    //bobcat.findDen(null);
  }
}

class Dummy implements A, B {
}
