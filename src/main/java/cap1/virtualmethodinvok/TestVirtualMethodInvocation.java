package cap1.virtualmethodinvok;

public class TestVirtualMethodInvocation {

  public static void main(String[] args) {
    Animal animal = new Lion();
    System.out.println(animal.name); //print ??? because there is not override of attributes
    animal.feed(); //print feed with Meat because the real object instanciated is a Lion so calls the virtual method of it
  }
}

abstract class Animal {
  String name = "???";

  abstract void feed();
}

class Cow extends Animal {
  String name = "Cow";

  void feed() {
    addHay();
  }

  private void addHay() { System.out.println("feed with Hay"); }
}

class Bird extends Animal {
  String name = "Bird";

  void feed() {
    addSeed();
  }

  private void addSeed() { System.out.println("feed with Seed"); }
}

class Lion extends Animal {
  String name = "Lion";

  void feed() {
    addMeat();
  }

  private void addMeat() { System.out.println("feed with Meat"); }
}
