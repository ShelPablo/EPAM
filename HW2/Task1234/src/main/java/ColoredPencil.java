public class ColoredPencil extends Pencil {
    String color;
    public ColoredPencil(String name, int cost, String color){
        super(name, cost);
        this.color = color;
    }

    @Override
    public String toString()
    {
        return color+" " + super.toString();
    }

}
