package cap3.methodref;

import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestMethodRef {
    public static void main(String[] args) {
       // method reference and lambda of static methods
       Consumer<List<Integer>> methodRef1 = Collections::sort;
       Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);

       // method reference and lambda of an instance
       String str = "some string instance";
       Predicate<String> methodRef2 = str::startsWith;
       Predicate<String> lambda2 = s -> str.startsWith(s);

       // method reference and lambda of an instance to be determinaded at runtime
       Predicate<String> methodRef3 = String::isEmpty;
       Predicate<String> lambda3 = s -> s.isEmpty();

       // method reference and lambda of a constructor
       Supplier<ArrayList> methodRef4 = ArrayList::new;
       Supplier<ArrayList> lambda4 = () -> new ArrayList();

       // method reference and lambda of a constructor using generics. note how we must specify the type. diamond not work here
       Supplier<ArrayList<Integer>> methodRef5 = ArrayList<Integer>::new;
       Supplier<ArrayList<Integer>> lambda5 = () -> new ArrayList<Integer>();

       // until java 7 we could remove objects from a collection that matches equals method and a specific index of a list
       // in java 8 we have the power of remove objects passing a piece of code instead of an object or a index
       List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
       Collection<Integer> listAsCollection = listOfIntegers; // just to enphasize that removeIf is in collection interface
       System.out.println(listAsCollection);
       listAsCollection.removeIf(i -> i % 2 == 0); // removeIf receive a predicate as a filter
       System.out.println(listAsCollection);
    }
}
