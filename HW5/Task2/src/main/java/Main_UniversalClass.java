public class Main_UniversalClass {
    public static void main(String[] args) {
        UniversalClass uc_fail = new UniversalClass("src/main/resources/lemon.properties");
        UniversalClass uc = new UniversalClass("src/main/resources/orange.properties");

       try {
           System.out.println("name = " + uc.getProp("name"));
           System.out.println("taste = " + uc.getProp("taste"));
           System.out.println("color = " + uc.getProp("color"));
       } catch (NoSuchProrertyKeyException e){
           System.err.println("Нет такого ключа: " + e.getPropName());
       }

    }

}
