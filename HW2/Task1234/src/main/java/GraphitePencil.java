public class GraphitePencil extends Pencil {
    public GraphitePencil(String name, int cost){
        super(name, cost);
    }

    public void write(String note) {
        System.out.println("This is written with GraphitePencil: " + note);
    }



}
