package cap1.overrideanotation;

public class TestOverrideAnotation {
  public static void main(String[] args) {
    Bobcat bobcat = new BobcatMother();
    bobcat.findDen();
  }
}

class Bobcat {
  //private void findDen() {} //Bobcat subclasses will not override this private method
  protected void findDen() {}
}

class BobcatMother extends Bobcat {
  @Override //forces the compiler throws a error when this method is not really overrided
  public void findDen() {}
}
