import lombok.*;
import lombok.experimental.NonFinal;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Account {
    @Getter
    String name;
    @Getter
    @NonFinal
    Integer balance; //in roubles

    public void deposit(Integer amount)
    {
        synchronized (this) {
            this.balance += amount;
        }
    }

    public void withdraw(Integer amount)
    {
        synchronized (this) {
            this.balance -= amount;
        }
    }

}
