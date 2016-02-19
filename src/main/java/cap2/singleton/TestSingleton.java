package cap2.singleton;

public class TestSingleton {
  public static void main(String[] args) {
    Singleton singleton = Singleton.getInstance();
  }
}

class Singleton {
  // scenario 1 - created when the class is loaded
  // the problem here is that we can not set nothing more
  //private static final Singleton instance = new Singleton();

  // scenario 2 - we declare a final reference but initialize it within a block
  // this is the same as scenario 1 but here we can do other initializations together
  private static final Singleton instance;
  static {
    instance = new Singleton();
    // do other staff
  }

  //constructor encapsulated
  private Singleton() {}

  public static Singleton getInstance() {
    return instance;
  }
}
