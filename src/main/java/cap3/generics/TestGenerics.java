package cap3.generics;

public class TestGenerics {
	public static void main(String[] args) {
    Glass<Juice> glassJuice = new Glass<>(new Juice()); //ok it implements Liquid
    //Glass<Cake> glassCake = new Glass<>(new Cake()); //nok it does not implement Liquid
    System.out.println(glassJuice.getLiquid());
    //System.out.println(glassJuice.getLiquidTaste(new Water())); // water has no taste
    System.out.println(glassJuice.getLiquidTaste(new Juice()));

    GlassOnlyOfFruitJuices<OrangeJuice> glassOnlyOrangeJuice = new GlassOnlyOfFruitJuices<>(); //ok orange implements fruit
    //GlassOnlyOfFruitJuices<AppleJuice> glassOnlyAppleJuice = new GlassOnlyOfFruitJuices<>(); //nok apple does not implement fruit
  }
}

class Juice implements Liquid { 
  @Override public String toString() {return "Juice";}
  @Override public String taste() {return "sweet";}
}
class Water implements Liquid {
  @Override public String toString() {return "Water";}
  @Override public String taste() {return null;} //water has no taste
}
class Cake {
  @Override public String toString() {return "Cake";}
}

interface Liquid {
  String taste();
}

class Glass<T extends Liquid> {
  private T liquid;

  Glass(T liquid) {
    this.liquid = liquid;
  }

  T getLiquid() {
    return liquid;
  }

  // this method exemplify the use generics with bounds on method level
  // why? to protect we get a taste for water for example that has no taste
  public <U extends Juice> String getLiquidTaste(U juice) {
    return juice.taste();
  }
}

interface Fruit {}
class OrangeJuice extends Juice implements Fruit {}
class AppleJuice extends Juice {}

// when using multiple type parameters you must put the concrete types first
class GlassOnlyOfFruitJuices<T extends Juice & Fruit> {
}
