package cap1.enums;

public class TestEnums {

  public static void main(String[] args) {
    Season s1 = Season.WINTER;
    Season s2 = Season.WINTER;
    //Both points to the same reference because they are like static final objects
    System.out.println(s1 == s2);
    System.out.println(s1 == Season.WINTER);
    //System.out.println(s1 == 2) //compile error because Enum is a type, not an int

    //Also the toString is override in the Enum class to print the name of the constant
    System.out.println(Season.WINTER);

    //values() returns an array of all constants in the Enum type and ordinal the index of that constant
    for(Season s : Season.values()) {
      System.out.println(s + " " + s.ordinal());
    }

    //Get a Enum object from a literal string constant
    Season s3 = Season.valueOf("WINTER"); //OK
    try{
      Season s4 = Season.valueOf("winter"); //NOK
    } catch(IllegalArgumentException e) {
      e.printStackTrace();
    }

    switch(s3) {
      case WINTER:
      //case Season.WINTER: compile error. In the switch statement use only the constante
        System.out.println("switch WINTER");
        break;
      //case 2: compile error. remember that the type of switch must me the same of the case label
        //break;
    }

    // Test the call of a method inside the Enum
    System.out.println(Season.WINTER.getStartMonth());
  }
}

enum Season {
  WINTER {
    // This area is a anonymous type of Enum Season
    @Override
    String getStartMonth() {
      return "january override";
    }
    @Override
    String globalMethodDeclare() {
      return getStartMonth();
    }
  }, SPRING("april") {
    // This area is a anonymous type of Enum Season
    @Override
    String globalMethodDeclare() {
      return getStartMonth();
    }
  }, SUMMER("july") {
    // This area is a anonymous type of Enum Season
    @Override
    String globalMethodDeclare() {
      return getStartMonth();
    }
  }, FALL("September") {
    // This area is a anonymous type of Enum Season
    @Override
    String globalMethodDeclare() {
      return getStartMonth();
    }
  }
  ; //add a ; when you need insert code after the constants

  // This is a instance variable declared globally but each constant has your instance
  private String startMonth;

  private Season() {
  }

  // dont compile with protected and public. default and private ok
  // because the construct can only be called by the Enum.
  // Also the constructor is called only once when a variable of this type
  // is referenced in the first time. After this java use the already constructed values.
  private Season(String startMonth) {
    System.out.println("This message must appear only once for each enum constant");
    this.startMonth = startMonth;
  }

  // this is a global method with a default implementation
  String getStartMonth() {
    return startMonth;
  }

  // this is a global method to be implemented for each anonymous Enum type of Season
  abstract String globalMethodDeclare();
}

//You can not extends a enum like a class
//enum ExtendedSeason extends Season {
//}
