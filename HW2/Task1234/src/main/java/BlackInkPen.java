public class BlackInkPen extends Pen {
    public BlackInkPen(String name, int cost){
        super(name, cost);
    }
    public void write(String note) {
        System.out.println("This is written with BlackInkPen: " + note);
    }

}
