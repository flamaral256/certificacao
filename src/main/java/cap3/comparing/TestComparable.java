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

  /**
   * Realize that when we write a compareTo method
   * together an equals method we have two logics to
   * say if an object is equals (comparing return 0
   * or equals returning true). There is a possibility
   * of this logics are not be consistent and some collections
   * actions will be unpredictable when sorting. For avoid this,
   * u may use the class comparator instaded comparable
   */
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Animal))
      return false;
    Animal a = (Animal) o;
    return this.id == a.id;
  }
}
