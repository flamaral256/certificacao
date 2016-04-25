package cap3.comparing;

public class TestComparable {
  public static void main(String[] args) {
    Animal a1a = new Animal(1);
    Animal a1b = new Animal(1);
    Animal a2 = new Animal(2);
    System.out.println(a1a.compareTo(a1b)); // return 0
    System.out.println(a1a.compareTo(a2)); // return -1
    System.out.println(a2.compareTo(a1a)); // return 1
  }
}

class Animal implements Comparable<Animal> { //using generics. when not u have to cast in compareTo method

  private int id;

  Animal(int id) {
    this.id = id;
  }

  // returns:
  // this / equals / that
  //  -1      0       1

  @Override
  //public int compareTo(Object that) { // without generics
  public int compareTo(Animal a) {
    //Animal a = (Animal) that; //without generics u need a cast
    return id - a.id; //ascendente
    //return that.id - id; //descendente
  }

  @Override
  public String toString() {
    return "Animal: " + id;
  }
}
