package cap3.comparing;

import java.util.Comparator;

public class TestComparator {
  public static void main(String[] args) {
    //metodo 1 - usando inner class
    Comparator<Animal> byId = new Comparator<Animal>() {
      @Override
      public int compare(Animal a1, Animal a2) {
        return a1.getId() - a2.getId();
      }
    };

    //metodo 2 - usando lambdas
    Comparator<Animal> byIdWithlambda = (a1, a2) -> a1.getId() - a2.getId();
  }
}

class Animal {
  private int id;

  Animal(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Animal: " + id;
  }
}
