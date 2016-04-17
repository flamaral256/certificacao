package cap3.collection;

import java.util.Set;
import java.util.HashSet;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TestSet {
  public static void main(String[] args) {
    // the set methods are all inherenced from Collection
    Set<Integer> hsi = new HashSet<>(); //no garanties that objects are sorted
    Set<Integer> tsi = new TreeSet<>(); //sorted calling compareTo
    // some implementation like treeset also has a navigable interface
    NavigableSet<Integer> ni = (NavigableSet<Integer>) tsi;

    hsi.add(2); //inserted out of logical numeric order
    hsi.add(3);
    hsi.add(1);
    hsi.add(4);
    System.out.println(hsi); //though (embora), hashset store the object in the order of hashcode this will appear 1,2,3,4

    // the set methods are all inherenced from Collection
    tsi.add(2); //again inserted out of logical numeric order
    tsi.add(1);
    tsi.add(4);
    tsi.add(3);
    System.out.println(tsi); //a treeset will order the inserts calling compareTo (the objects must be comparable or the results are unknow)
                              // because of this the this collection not accept null

    // ordered set also implements a navigable interface that add the power to call some useful methods of consulting
    System.out.println(ni.higher(2)); //  >  2 - 3
    System.out.println(ni.ceiling(2)); // >= 2 - 2
    System.out.println(ni.floor(2)); //   <= 2 - 2
    System.out.println(ni.lower(2)); //   <  2 - 1
    System.out.println(ni.lower(1)); //   <  1 - null
  }
}
