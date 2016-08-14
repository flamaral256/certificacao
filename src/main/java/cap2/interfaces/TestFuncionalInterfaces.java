package cap2.interfaces;

import java.util.function.Predicate;

public class TestFuncionalInterfaces {
  public static void main(String[] args) {
    Webmotors webmotors = new Webmotors();
    webmotors.showAvailableCars(new Car("corolla", 4, "black"), c -> c.has4ports());
    webmotors.showAvailableCars(new Car("civic", 2, "grey"), c -> c.isBlack());
  }
}

class Car {
  private String branch;
  private int numberOfPorts;
  private String color;

  public Car(String branch, int ports, String color) {
    this.branch = branch;
    this.numberOfPorts = ports;
    this.color = color;
  }

  public boolean has4ports() {
    return numberOfPorts == 4;
  }

  public boolean isBlack() {
    return color.equals("black");
  }

  @Override
  public String toString() {
    return branch;
  }
}

class Webmotors {
  public void showAvailableCars(Car car, Predicate<Car> matcher) {
    if(matcher.test(car))
      System.out.println(car);
  }
}

// a method with only one abstract method is a funcional interface
@FunctionalInterface
interface CarMatch {
  static CarMatch of(Car c) { // also now is possible implement static methods
    return new CarMatch() {
      public boolean match(Car c) {
        return false;
      }
    };
  }
  boolean match(Car c);
}
