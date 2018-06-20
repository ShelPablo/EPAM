import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class NoSuchProrertyKeyException extends RuntimeException {
    @Getter
    String propName;

}
