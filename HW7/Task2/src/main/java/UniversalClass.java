import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

public class UniversalClass {

    private static UniversalClass instance;

    @Getter
    Map<String, String> props;

    private UniversalClass(String file)
    {
        ResourceBundle rb = ResourceBundle.getBundle(file);
        props = rb.keySet().stream()
                .collect(Collectors.toMap(k->k, rb::getString));
    }

    public static UniversalClass getInstance(String propFile) {
        synchronized (UniversalClass.class) {
            if (instance == null) {
                instance = new UniversalClass(propFile);
            }
            return instance;
        }
    }
/**
 * just a little dark reflection magic instead of:
 * switch (type) {
 *      case "Integer":   return (T) Integer.valueOf();
 *      case "Long":      return (T) Long.valueOf(props.get(property));
 *      case "Short":     return (T) Short.valueOf(props.get(property));
 *      case "Byte":      return (T) Byte.valueOf(props.get(property));
 *      case "Boolean":   return (T) Boolean.valueOf(props.get(property));
 *      case "Float":     return (T) Float.valueOf(props.get(property));
 *      case "Double":    return (T) Double.valueOf(props.get(property));
 *      default:          return null;
*/
    @SneakyThrows
    <T> T getAs(String type, String property)
    {
        Method valueOf = Class.forName("java.lang." + type).getDeclaredMethod("valueOf", String.class);
        return (T)valueOf.invoke(null,  props.get(property));
    }

    Character getChar(String property)
    {
        return props.get(property).toCharArray()[0];
    }

}
