package cap1.reviewoca.methodoverride;

import java.io.IOException;
import java.io.EOFException;
import java.sql.SQLException;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * Overriding rules:
 *
 * Everything on the left side of method name must be equals or greater
 * Everything on the right side of method name must be equals or lesser
 * In case of equals, must be more specific instead of more generic
 * Can not be static or final in superclass
 *        >=               >=                                         <=
 * [access modifier] {return type} {method name} ([arguments]) [throws exceptions];
 */
public class BobcatKitten extends Bobcat {
  //public void findDen() { System.out.println("overrided!"); } //ok, subclass has less exceptions than superclass
  //public void findDen() throws IOException { System.out.println("overrided!"); } //ok, subclass has same exceptions than superclass
  //public void findDen() throws EOFException { System.out.println("overrided!"); } //ok, subclass has a more specific exception than superclass
  //public void findDen() throws Exception { System.out.println("overrided!"); } //nok, subclass has a more generic exception than superclass
  //public void findDen() throws SQLException { System.out.println("overrided!"); } //nok, subclass has a different(s) exception(s) than superclass

  //nok, subclass has a different return type than superclass
  //public void findDenAsList() throws IOException { System.out.println("overrided!"); }

  //ok, subclass has the same return type of superclass
  //public List<Integer> findDenAsList() throws IOException { System.out.println("overrided!"); return new ArrayList<Integer>(); }

  //ok, subclass has a more specific return type of superclass
  //public ArrayList<Integer> findDenAsList() throws IOException { System.out.println("overrided!"); return new ArrayList<Integer>(); }

  //nok, subclass has a more generic return type of superclass
  //public Collection<Integer> findDenAsList() throws IOException { System.out.println("overrided!"); return new ArrayList<Integer>(); }

  public static void main(String[] args) {
	try {
      Bobcat bobcat = new BobcatKitten();
	  bobcat.findDen();
	  bobcat.findDenAsList();
	} catch (Exception e) {}
  }
}
