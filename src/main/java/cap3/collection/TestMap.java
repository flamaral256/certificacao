package cap3.collection;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class TestMap {
  public static void main(String[] args) {
    // the map interface is not a collection. Maps store elements as collection,
    // but as an association of key/values pairs. So you can find in maps methods,
    // to retrieve both keys and values, check size and empty, clear etc
    Map<String, String> hmss = new HashMap<>(); //no garanties that objects are sorted
    Map<String, String> tmss = new TreeMap<>(); //sorted calling compareTo. This map also implements NavigableMap

    //isEmpty, size
    System.out.println(hmss.isEmpty()); //true
    System.out.println(hmss.size()); //0
    System.out.println(tmss.isEmpty()); //true
    System.out.println(tmss.size()); //0

    //using put to add or replace (also retrieve the old element) elements
    System.out.println(hmss.put("fernando", "fernando")); //add value fernando associated with a key fernando and return null
    System.out.println(tmss.put("fernando", "fernando")); //add value fernando associated with a key fernando and return null
    System.out.println(hmss.put("amaral", "amaral")); //add value fernando associated with a key fernando and return null
    System.out.println(tmss.put("amaral", "amaral")); //add value fernando associated with a key fernando and return null
    System.out.println(hmss.put("fernando", "epopeia")); //add value epopeia associated with a key fernando and return fernando
    System.out.println(tmss.put("fernando", "epopeia")); //add value epopeia associated with a key fernando and return fernando

    //using get to retrieve a value of a key
    System.out.println(hmss.get("fernando")); //return epopeia
    System.out.println(tmss.get("fernando")); //return epopeia
    System.out.println(hmss.get("amaral")); //return null
    System.out.println(tmss.get("amaral")); //return null

    //isEmpty, size
    System.out.println(hmss.isEmpty()); //false
    System.out.println(hmss.size()); //2
    System.out.println(tmss.isEmpty()); //false
    System.out.println(tmss.size()); //2

    //checks
    //System.out.println(hmss.contains("fernando")); //does not compile. what are u really mean? Key or value?
    System.out.println(hmss.containsKey("fernando")); //true
    System.out.println(hmss.containsKey("amaral")); //false
    System.out.println(hmss.containsValue("epopeia")); //true
    System.out.println(hmss.containsValue("amaral")); //false
    System.out.println(tmss.containsKey("fernando")); //true
    System.out.println(tmss.containsKey("amaral")); //false
    System.out.println(tmss.containsValue("epopeia")); //true
    System.out.println(tmss.containsValue("amaral")); //false

    //retrive all values and keys
    System.out.println(hmss.keySet()); //fernando, amaral
    System.out.println(tmss.keySet()); //amaral, fernando (sorted)
    System.out.println(hmss.values()); //epopeia, amaral
    System.out.println(tmss.values()); //amaral, epopeia (sorted)

    //clear map
    hmss.clear();
    tmss.clear();
    System.out.println(hmss.isEmpty()); //true
    System.out.println(hmss.size()); //0
    System.out.println(tmss.isEmpty()); //true
    System.out.println(tmss.size()); //0
  }
}
