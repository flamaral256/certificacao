package cap1.instance_of;

public class Animal {

  public static void main(String[] args) {
    Animal hippo = new Hippo(); //this is a reference that could be a hippo or elephant
    Hippo anotherHippo = new Hippo(); //this is a reference that could only be a Hippo

    System.out.println(null instanceof Hippo); //false for any reference null
    System.out.println(hippo instanceof Object); //true
    System.out.println(hippo instanceof Animal); //true
    System.out.println(hippo instanceof Hippo); //true
    System.out.println(hippo instanceof Elephant); //false

    //Compile error because de reference is a class of Hippo and not Animal
    //Compiler only perform this check for classes.
    //System.out.println(anotherHippo instanceof Elephant);

    //For interfaces the compiler let it be checked in runtime, because is
    //possible to create a MotherHippo class that implements this interface
    System.out.println(hippo instanceof Mother); //false
  }
}

interface Mother {
}

class Hippo extends Animal{
}

class Elephant extends Animal {
}
