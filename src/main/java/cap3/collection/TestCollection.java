package cap3.collection;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ArrayDeque;

public class TestCollection {
  public static void main(String[] args) {
    //u can use any implementation of collection
    //Collection<String> cs = new ArrayList<>();
    Collection<String> cs = new HashSet<>();
    //Collection<String> cs = new ArrayDeque<>();
    //Collection<String> cs = new HashMap<>(); //nok, map is not a collection actually

    //common methods
    System.out.println(cs.isEmpty() ? "colecao vazia" : "colecao com " + cs.size() + " objetos");

    //cs.add(new Integer(1)); //nok, because generics protect to include objects not allowed
    System.out.println(cs.add("Fernando")); //return true pra collections q aceitam duplicacoes como list
    System.out.println(cs.add("Fernando")); //return false pra collections q nao aceitam duplicacoes como Set
    cs.add("Luiz do");
    cs.add("Amaral");
    cs.add("Junior");
    System.out.println(cs);

    System.out.println(cs.isEmpty() ? "colecao vazia" : "colecao com " + cs.size() + " objetos");
    System.out.println(cs.contains("Fernando") ? "Fernando esta presente" : "Fernando nao esta presente");

    System.out.println(cs.remove(new Integer(1))); //its ok. generics only protect to include wrong types not to remove or consulting them.
                                                   //also returns false because there is such object in the collection
    System.out.println(cs.remove("Luiz do")); //return true because this objects was present and was removed
    cs.remove("Junior");
    System.out.println(cs);

    System.out.println(cs.isEmpty() ? "colecao vazia" : "colecao com " + cs.size() + " objetos");
    System.out.println(cs.contains("Junior") ? "Junior esta presente" : "Junior nao esta presente");

    cs.clear();
    System.out.println(cs.isEmpty() ? "colecao vazia" : "colecao com " + cs.size() + " objetos");
  }
}
