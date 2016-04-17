package cap3.generics;

import java.util.List;
import java.util.ArrayList;

public class TestGenerics {
	public static void main(String[] args) {
    Glass<Juice> glassJuice = new Glass<>(new Juice()); //ok it implements Liquid
    //Glass<Cake> glassCake = new Glass<>(new Cake()); //nok it does not implement Liquid
    System.out.println(glassJuice.getLiquid());
    //System.out.println(glassJuice.getLiquidTaste(new Water())); // water has no taste
    System.out.println(glassJuice.getLiquidTaste(new Juice()));

    GlassOnlyOfFruitJuices<OrangeJuice> glassOnlyOrangeJuice = new GlassOnlyOfFruitJuices<>(); //ok orange implements fruit
    //GlassOnlyOfFruitJuices<AppleJuice> glassOnlyAppleJuice = new GlassOnlyOfFruitJuices<>(); //nok apple does not implement fruit

    //Glass<Liquid> glassLiquid = new Glass<Juice>(); //nok cuz both type inheritance from Object here
    //SuperGlass<Juice> glassPolymorphic = new ChieldGlass<Water>(); //nok cuz the types are different
    SuperGlass<Juice> glassPolymorphic = new ChieldGlass<Juice>();

    Tray tray = new Tray();
    tray.add(new WildGlass<Juice>());
    tray.add(new WildGlass<Cake>());

    tray.addOnlyJuice(new WildGlass<Juice>());//ok
    tray.addOnlyJuice(new WildGlass<OrangeJuice>()); //ok orangejuice is subtype of juice
    //tray.addOnlyJuice(new WildGlass<Cake>());//nok cake is not a juice

    /**
     * PAY ATENTION HERE: when we set the parameter type with the arguments coke, cokediet etc
     * we are actually only setting wildclass with the alowed type references for this wildglass
     */
    tray.addOnlyCokesWithOutSugar(new WildGlass<Coke>()); //ok coke is super type of cokezero
    tray.addOnlyCokesWithOutSugar(new WildGlass<CokeDiet>()); //ok cokediet is super type of cokezero
    tray.addOnlyCokesWithOutSugar(new WildGlass<CokeZero>()); //ok cokezero is the own lower type
    //tray.addOnlyCokesWithOutSugar(new WildGlass<CokeGreen>()); //nok cokeGreen is not a super type of cokezero
    //tray.addOnlyCokesWithOutSugar(new WildGlass<CokeXtra>()); //nok cokeXtra is a subtype of cokezero
    tray.showContent();

    /**
     * PAY ATENTION HERE: But here, we are not "tipando" with the allowed references. We are
     * actually putting real objects here. Not references.
     */
    List<? super CokeZero> listOfCokes = new ArrayList<Coke>(); //<-- look that we can setup the reference coke
    //listOfCokes.add(new Coke()); //nok. but not all cokes objects are cokezeros
    //listOfCokes.add(new CokeDiet()); //nok. not all cokediet are cokezeros. even if the future class are not even written
    listOfCokes.add(new CokeZero()); //ok. cokezero object is allowed
    listOfCokes.add(new CokeXtra()); //ok. cokextra is also a cokezero. HERE we are adding a object that is a sub type for a lower bound
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

class SuperGlass<T> {
}

// this assert that both types (super and sub) will receive the same type T
// allowing the inheritance between this types
class ChieldGlass<T> extends SuperGlass<T> {
}

//-------------------------------------------------------------

class WildGlass<T> {}

class Coke {}
class CokeDiet extends Coke {}
class CokeZero extends CokeDiet {}
class CokeXtra extends CokeZero {}
class CokeGreen extends Coke {}

class Tray {
  private List<WildGlass<?>> trayContent = new ArrayList<>();

  void add(WildGlass<?> glass) {//this tray can have glasses of any kind even cakes
    trayContent.add(glass);
  }
  void addOnlyJuice(WildGlass<? extends Juice> glass) {//this tray can only have glasses of juices
    trayContent.add(glass);
  }
  void addOnlyCokesWithOutSugar(WildGlass<? super CokeZero> glass) {// can only accept cokezero and supertypes of it
    trayContent.add(glass);
  }
  void showContent() {
    System.out.println(trayContent);
  }
}
//-------------------------------------------------------------
