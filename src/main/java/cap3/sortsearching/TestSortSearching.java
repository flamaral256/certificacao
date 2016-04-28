package cap3.sortsearching;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * The objects in a collection must be comparable otherwise the collection does not have to know how to sort then
 */
public class TestSortSearching {
  public static void main(String[] args) {
    Integer[] ai = {3,1,9,7}; // <-- an array
    List<Integer> li = new ArrayList<Integer>(Arrays.asList(ai)); // <-- a list

    // Sorting in two tastes. one for array and other to collections
    Arrays.sort(ai);
    System.out.println(Arrays.asList(ai));
    Collections.sort(li);
    System.out.println(li);

    // now the array must be [1,3,7,9]

    // Searching using binary search algorithm. Also in two tastes
    System.out.println(Arrays.binarySearch(ai, 1)); // it finds in index 0
    System.out.println(Arrays.binarySearch(ai, 3)); // it finds in index 1 ..
    System.out.println(Arrays.binarySearch(ai, 0)); // it not finds. but if this elements exists it should be in index (1*-1)-2 ..

    System.out.println(Collections.binarySearch(li, 1)); // it finds in index 0
    System.out.println(Collections.binarySearch(li, 3)); // it finds in index 1 ..
    System.out.println(Collections.binarySearch(li, 0)); // it not finds. but if this elements exists it should be in index (1*-1)-2 ..
    
    // como 0 pode ser positivo ou negativo. nao teriamos como saber se qd retornasse zero o elemento foi achado em zero, ou se
    // ele deveria ser incluido em zero. portanto qd nao achar subtrai um para sempre o indice comecar a partir de -1

    List<ClassNotComparable> naoComparavelList = new ArrayList<>(
                            Arrays.asList(new ClassNotComparable(3), new ClassNotComparable(1), new ClassNotComparable(5)));
    //Collections.sort(naoComparavelList); // nao compila. sort usa um upper bound generics esperando que a classe seja Comparable

    List<ClassComparable> comparavelList = new ArrayList<>(
                            Arrays.asList(new ClassComparable(3), new ClassComparable(1), new ClassComparable(5)));
    Collections.sort(comparavelList); // ok. agora os objetos sao comparaveis e a collection pode ordenar normalmente
    System.out.println(comparavelList); // 1,3,5
    Comparator<ClassComparable> invertedc = Collections.reverseOrder(); //reverseOrder so aceita objetos Comparable
    Collections.binarySearch(comparavelList, new ClassComparable(3), invertedc); //cuidado aki pois a lista esta ascendente e a busca descendente, tornando os resultados imprevisiveis.

    // Para resolver o problema da lista de objetos nao comparaveis podemos criar um comparator pra esses objetos
    Comparator<ClassNotComparable> c = (c1, c2) -> c1.i - c2.i;
    Collections.sort(naoComparavelList, c);
    System.out.println(naoComparavelList); // 1,3,5
    Collections.binarySearch(naoComparavelList, new ClassNotComparable(3), c); //buscas tb podem passar o criterio de comparacao
  }
}

// classe para demonstrar q colecoes nao conseguem ordenar objetos que nao sao comparaveis
class ClassNotComparable {
  int i;
  ClassNotComparable(int i) {this.i = i;}
  @Override public String toString() { return "" + this.i; }
}

// classe para demonstrar q colecoes soh podem order se os objetos forem comparaveis
class ClassComparable implements Comparable<ClassComparable> {
  int i;
  ClassComparable(int i) {this.i = i;}
  @Override public int compareTo(ClassComparable cc) { return this.i - cc.i; }
  @Override public String toString() { return "" + this.i; }
}
