import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.NonFinal;

@AllArgsConstructor
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


    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Account)) return false;
        final Account other = (Account) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.name;
        final Object other$name = other.name;
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
//   аккаунт будет определяться только своим именем! (analog id)
//        final Object this$balance = this.balance;
//        final Object other$balance = other.balance;
//        if (this$balance == null ? other$balance != null : !this$balance.equals(other$balance)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.name;
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
//        final Object $balance = this.balance;
//        result = result * PRIME + ($balance == null ? 43 : $balance.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Account;
    }

    public String toString() {
        return String.format("%s: %d\n", name, balance );
    }
}
