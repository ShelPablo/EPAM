import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UniversalClass {

    Properties property;

    public UniversalClass(String propFileName)
    {
        property = new Properties();
        try (FileInputStream fis = new FileInputStream(propFileName);){

            property.load(fis);
/*
            String host = property.getProperty("db.host");
            String login = property.getProperty("db.login");
            String password = property.getProperty("db.password");

            System.out.println("HOST: " + host
                    + ", LOGIN: " + login
                    + ", PASSWORD: " + password);
*/
        } catch (IOException e) {
            System.err.println(e.getMessage() );
        }
    }

    public String getProp(String propKey) throws NoSuchProrertyKeyException
    {
        String propVal = property.getProperty(propKey);
        if(propVal == null) throw new NoSuchProrertyKeyException(propKey);
        return propVal;
    }




}
