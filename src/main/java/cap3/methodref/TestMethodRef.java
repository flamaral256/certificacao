package cap3.methodref;

import java.util.List;

public class TestMethodRef {
    public static void main(String[] args) {
       // method reference of static methods
       Consumer<List<Integer>> sortList = Collections::sort;
    }
}

