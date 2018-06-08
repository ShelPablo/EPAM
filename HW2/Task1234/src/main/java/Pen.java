public class Pen extends WritingItem {

    public Pen(String name, int cost){
        super(name, cost);
    }

    @Override
    public String toString(){return "pen\t\t\t"+getName()+"\t\t\t"+getCost();}

    public void write(String note) {
        System.out.println("This is written with Pen: " + note);
    }
}
