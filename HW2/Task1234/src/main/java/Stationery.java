import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.Comparator;

@AllArgsConstructor
@Getter
public abstract class Stationery {
    String name;
    int cost;

    public static final Comparator<Stationery> COMPARE_BY_COST = new Comparator<Stationery>() {
        //@Override
        public int compare(Stationery lhs, Stationery rhs) {
            return lhs.getCost() - rhs.getCost();
        }
    };
    public static final Comparator<Stationery> COMPARE_BY_NAME = new Comparator<Stationery>() {
        //@Override
        public int compare(Stationery lhs, Stationery rhs) {
            return String.CASE_INSENSITIVE_ORDER.compare(lhs.getName(), rhs.getName());
        }
    };
    public static final Comparator<Stationery> COMPARE_BY_COST_AND_NAME = new Comparator<Stationery>() {
        //@Override
        public int compare(Stationery lhs, Stationery rhs) {
            int costComp = lhs.getCost() - rhs.getCost();
            if(costComp == 0) return String.CASE_INSENSITIVE_ORDER.compare(lhs.getName(), rhs.getName());
            else return costComp;
        }
    };

    @Override
    public String toString(){

        return new StringBuilder(this.getClass().toString()).substring(6)+"\t\t\t"+ name +"\t\t\t"+cost;

    }

}
