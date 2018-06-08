public class Pencil extends WritingItem {

    public Pencil(String name, int cost){
        super(name, cost);
    }

    public void write(String note) {
        System.out.println("This is written with Pencil: " + note);
    }

    @Override
    public String toString(){return "pencil" + "\t\t\t" + getName() + "\t\t\t" + getCost();}

}
