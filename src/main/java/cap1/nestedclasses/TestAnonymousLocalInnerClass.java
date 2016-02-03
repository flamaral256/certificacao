package cap1.nestedclasses;

//Anonymous inner class is a special type of LocalInner classes that has no name
public class TestAnonymousLocalInnerClass {

  abstract class AnonymousLocalInner {
    abstract void doit();
  }

  interface AnonymousInterface {
    void doit();
  }

  abstract class AnonymousLocalInnerClassInterface implements AnonymousInterface {
    abstract public void doit();
  }

  private void methodWithAnonymousParameter(AnonymousLocalInner x, AnonymousInterface y) {
    x.doit();
    y.doit();
  }

  private void callAnonymous() {
    // test a abstract anonymous class
    AnonymousLocalInner anonymousClass = new AnonymousLocalInner() {
      void doit() {
        System.out.println("testing a anonymous abstract class");
      }
    }; //<-----need a ; when declaring a local anonymous implementation
    anonymousClass.doit();

    // test a interface anonymous class
    AnonymousInterface anonymousInterface = new AnonymousInterface() {
      public void doit() {
        System.out.println("testing a anonymous interface");
      }
    }; //<-----need a ; when declaring a local anonymous implementation
    anonymousInterface.doit();

    // a class that implements a interface
    AnonymousLocalInnerClassInterface anonymousClassInterface = new AnonymousLocalInnerClassInterface() {
      public void doit() {
        System.out.println("testing a anonymous class with interface");
      }
    }; //<-----need a ; when declaring a local anonymous implementation
    anonymousClassInterface.doit();

    // a class and an interface passed with a parameter
    methodWithAnonymousParameter(
      new AnonymousLocalInner() {
        void doit() {
          System.out.println("testing a anonymous abstract class");
        }
    }, new AnonymousInterface() {
        public void doit() {
          System.out.println("testing a anonymous interface");
        }
    });
  }

  public static void main(String[] args) {
    new TestAnonymousLocalInnerClass().callAnonymous();
  }
}
