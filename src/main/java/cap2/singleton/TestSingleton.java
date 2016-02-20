package cap2.singleton;

public class TestSingleton {
  public static void main(String[] args) {
    Singleton singleton = Singleton.getInstance();
  }
}

class Singleton {

  //constructor encapsulated
  private Singleton() {}

  // scenario 1 - created when the class is loaded
  // the problem here is that we can not set nothing more
  //private static final Singleton instance = new Singleton();

  // scenario 2 - we declare a final reference but initialize it within a block
  // this is the same as scenario 1 but here we can do other initializations together
  //private static final Singleton instance;
  //static {
  //  instance = new Singleton();
  //  // do other staff
  //}

  // scenario 3 - lazy singleton only creates instance when requested the first time
  // the problem here is that we cant set the variable as final
  //private static Singleton instance;

  // scenario 4 - lazy singleton with double lock for optimized when getting the instance only the first time
  private static volatile Singleton instance;

  // we need sysnchronized for every method of a singleton object for thread safe
  // the problem here is that always that someone needs a instance we got a bottle neck
  // the solution for this is in scenario 4, creating a double lock check
  public static Singleton getInstance() {
    if (instance == null) {
      synchronized(Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}
