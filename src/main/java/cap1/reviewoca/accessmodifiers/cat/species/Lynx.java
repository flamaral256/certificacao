package cap1.reviewoca.accessmodifiers.cat.species;

import cap1.reviewoca.accessmodifiers.cat.BigCat;

public class Lynx extends BigCat {
  public static void main(String[] args) {
	BigCat cat = new BigCat();
	System.out.println(cat.name); // public member accessed by everyone
	System.out.println(cat.hasFur); // protected member CANT be accessed by another class REFERENCE (protected has no effect here)
                                    // only by inheritance. Ex: Lynx cat = new Lynx(); cat.hasFur (here the extends has effect)
	System.out.println(cat.hasPaws); // default member CANT be accessed by another class in another package
	System.out.println(cat.id); // private member CANT be accessed by anyother class even if it is the same package
  }
}
