package cap1.reviewoca.methodoverride;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Bobcat {
  protected void findDen() throws IOException { System.out.println("original code"); }
  protected List<Integer> findDenAsList() throws IOException { System.out.println("original code"); return new ArrayList<Integer>(); }
}
