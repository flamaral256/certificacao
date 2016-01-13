package cap1.reviewoca.accessmodifiers.cat;

public class CatAdmirer {
  public static void main(String[] args) {
	BigCat cat = new BigCat();
	System.out.println(cat.name); // public member accessed by everyone
	System.out.println(cat.hasFur); // protected member accessed by another class in the same package
	System.out.println(cat.hasPaws); // default member accessed by another class in the same package
	System.out.println(cat.id); // private member CANT be accessed by anyother class even if it is the same package
  }
}
