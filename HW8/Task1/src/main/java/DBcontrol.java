import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class DBcontrol {


    private static final String LOGIN = "guest";
    private static final String PASSWORD = "123456";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL_SQL = "jdbc:postgresql://127.0.0.1:5432/testdb";
    private static final String SQL_SCRIPT_1 = "script1.sql";
    private static final String SQL_SCRIPT_2 = "script2.sql";

    @SneakyThrows
    public static void main(String[] argv) {


        try {
            Class.forName(DRIVER);
            System.out.println("JDBC driver Registered Succesfully");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
            return;
        }

        Path queryScriptPath = Paths.get(new DBcontrol().getClass()
                .getResource(SQL_SCRIPT_1).toURI());
        List<String> queryScript1 = Files.readAllLines(queryScriptPath);

        queryScriptPath = Paths.get(new DBcontrol().getClass()
                .getResource(SQL_SCRIPT_2).toURI());
        List<String> queryScript2 = Files.readAllLines(queryScriptPath);
// to delete first space - how does it appear???
        queryScript1.add(0, queryScript1.get(0).substring(1));
        queryScript1.remove(1);

        queryScript2.add(0, queryScript2.get(0).substring(1));
        queryScript2.remove(1);
//--------

        try(Connection conn = DriverManager.getConnection(URL_SQL, LOGIN, PASSWORD);
            Statement stmt = conn.createStatement(); )
        {

            for(String s: queryScript2){
                System.out.println(s);
                stmt.execute(s);
            }



            for(String s: queryScript1){
                System.out.println(s);
                stmt.execute(s);
            }
            ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT;");
            while (rs.next()) System.out.println(rs.getString("StudentName"));//rs.getString(1));

//            for(String s: queryScript2){
//                System.out.println(s);
//                stmt.execute(s);
//            }



        } catch (SQLException e) {e.printStackTrace();}



//        String strr = "";
//        Scanner in1 = new Scanner(new File("m.sql"));
//        while(in1.hasNext())
//            strr += in1.nextLine() + "\r\n";//считываем скрипт в переменную
//        in1.close();
//        rs = null;
//        try{
//            ps=null;
//            ps=bd.prepareStatement(strr);
//            ps.execute();
//            System.out.println("Table creation process successfully!");
//        }
//        catch(SQLException s){
//            System.out.println("Table all ready exists!");
//        }
//


    }






}
