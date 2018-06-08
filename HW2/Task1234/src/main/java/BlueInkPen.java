public class BlueInkPen extends Pen {

    public BlueInkPen(String name, int cost){
        super(name, cost);
    }

    public void write(String note) {
        System.out.println("This is written with BlueInkPen: " + note);
    }
}
