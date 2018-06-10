import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    String lastName_firstName; //"Ivanov Ivan"

    @Override
    public String toString(){return lastName_firstName;}
}
