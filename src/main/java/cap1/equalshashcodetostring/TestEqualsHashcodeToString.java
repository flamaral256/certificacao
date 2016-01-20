package cap1.equalshashcodetostring;

public class TestEqualsHashcodeToString {
  public static void main(String[] args) {
    Hippo h1 = new Hippo("Harry", 3100);
    System.out.println(h1); // calls toString method and prints Harry

    //Test equals of two lions with the same id
    Lion l1 = new Lion(1, 20, "Lion A");
    Lion l2 = new Lion(1, 25, "Lion B");
    System.out.println(l1.equals(l2));

    //Test hashcode (group of cards) and equals (specific card)
    Card ace1 = new Card("aces", "1");
    Card ace2 = new Card("aces", "2");
    Card two1 = new Card("twos", "1");
    Card two2 = new Card("twos", "2");
    System.out.println(ace1.hashCode() == ace2.hashCode()); //true as aces are in the same group
    System.out.println(two1.hashCode() == two2.hashCode()); //true as twos are in the same group
    System.out.println(ace1.hashCode() == two1.hashCode()); //false as twos and aces are in different groups
    System.out.println(ace1.equals(ace2)); //false as aces are in the same group but are different cards
    System.out.println(ace1.equals(ace1)); //true as aces are in the same group and also are the same card number
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

class Card {
  private String rank;
  private String suit;

  Card(String r, String s) {
    if (r == null || s == null)
      throw new IllegalArgumentException();
    rank = r;
    suit = s;
  }

  // Here we return a specific card inside that group
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Card))
      return false;
    Card c = (Card) obj;
    return rank.equals(c.rank) && suit.equals(c.suit);
  }

  // Here we return a category of cards (groups)
  @Override
  public int hashCode() {
    return rank.hashCode();
  }
}
