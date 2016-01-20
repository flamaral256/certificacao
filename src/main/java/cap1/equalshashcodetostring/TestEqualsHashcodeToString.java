package cap1.equalshashcodetostring;

public class TestEqualsHashcodeToString {
  public static void main(String[] args) {
    Hippo h1 = new Hippo("Harry", 3100);
    System.out.println(h1); // calls toString method and prints Harry
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
