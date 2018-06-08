
public class WritingItem extends Stationery implements Writing {
    WritingItem(String name, int cost){
        super(name, cost);
    }

    public void write(String note) {
        System.out.println("This is written with WritingItem: " + note);
    }
}
