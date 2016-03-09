package cap3.generics;

public class TestGenerics {
	public static void main(String[] args) {
    Glass<Juice> glass = new Glass<>(new Juice());
    System.out.println(glass.getLiquid());
  }
}

class Juice { @Override public String toString() {return "Juice";} }
class Water { @Override public String toString() {return "Water";} }

interface Liquid {
}

class Glass<T> {
    private T liquid;

    Glass(T liquid) {
      this.liquid = liquid;
    }

    T getLiquid() {
      return liquid;
    }
}
