public class Mark <T extends  Number>{
    T mark;
    public Mark(T value){
        mark = value;
    }
    public T getMark() {
        return mark;
    }
    @Override
    public String toString(){return mark.toString();}

}
