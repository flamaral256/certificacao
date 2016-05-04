package cap3.methodref;

import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

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

       // lists also receive a new method to replaceAll elements in a list. the code with the logic of how to update is passed as a lambda
       listOfIntegers.replaceAll(i -> i * 2); //replaceAll receive a UnaryOperator lambda that receives a type and return a modified value of the same type. In fact the method abstract here is apply that is in Function interface inhereated by UnaryOperator
       System.out.println(listAsCollection);

       // Also, all iterable object (that implements Iterable) receive a method forEach
       Iterable<Integer> it = listOfIntegers; //just to enphasize that forEach is in the java.lang.Iterable interface
       it.forEach(System.out::println); // forEach receive a consumer. in this case we just pass to println. so we write as method ref syntax

       // as variaveis locais utilizadas em lambdas seguem as regras de final e efetivamente final
    }
}
