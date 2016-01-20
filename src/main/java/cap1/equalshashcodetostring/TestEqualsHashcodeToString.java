package cap1.equalshashcodetostring;

public class TestEqualsHashcodeToString {
  public static void main(String[] args) {
    Hippo h1 = new Hippo("Harry", 3100);
    System.out.println(h1); // calls toString method and prints Harry

    //Test equals of two lions with the same id
    Lion l1 = new Lion(1, 20, "Lion A");
    Lion l2 = new Lion(1, 25, "Lion B");
    System.out.println(l1.equals(l2));
  }
}

class Hippo {
  private String name;
  private double weight;

  Hippo(String name, double weight) {
      this.name = name;
      this.weight = weight;
  }

  @Override
  public String toString() {
    return name + "weight " + weight;
  }
}

class Lion {
  private int idNumber;
  private int age;
  private String name;

  Lion(int idNumber, int age, String name) {
    this.idNumber = idNumber;
    this.age = age;
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    //protect against null objects returning false and be sure of the cast
    if (!(obj instanceof Lion))
      return false;
    Lion otherLion = (Lion) obj;
    return this.idNumber == otherLion.idNumber;
  }
}
