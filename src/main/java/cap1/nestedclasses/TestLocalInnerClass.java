package cap1.nestedclasses;

//LocalInner classes are not static and are in the same level of the method
public class TestLocalInnerClass {
  private final int x = 5; //ok this is a member variable

  public void calculate() {
    //inside this method we declare a inner local class that will be in a different class file.
    //local variables here will be copied to this file or passed by constructor. But for this work,
    //this local variable could not change. So they must be final or effectivaly final.
    
    //final int y = 7; //ok, it is a local variable final
    int y = 7; //ok, it is a local variable effectivally final
    //if(true) y = 7; else y = 0; //ok, y is defined only once in each branch of the if
    //y = 5; //nok because y was already defined, so it is not final
    class Calculator {
      private void multiply() {
        System.out.println(x * y);
      }
    }
    //y = 5; //nok because y was already defined, so it is not final (even after class declare)
    new Calculator().multiply();
  }

  public static void main(String[] args) {
    new TestLocalInnerClass().calculate();
  }
}
