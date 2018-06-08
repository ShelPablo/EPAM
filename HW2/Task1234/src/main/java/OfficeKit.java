import lombok.val;

import java.util.ArrayList;
import java.util.Collections;

public class OfficeKit {

    String employerName;

    ArrayList<BlueInkPen> blueInkPenList;
    ArrayList<BlackInkPen> blackInkPenList;
    ArrayList<GraphitePencil> graphitePencilList;
    ArrayList<ColoredPencil> coloredPencilList;
    ArrayList<Stapler> staplerList;

    ArrayList<Stationery> commonList;

    public OfficeKit(String employerName) {
        this.employerName = employerName;
        blueInkPenList = new ArrayList<BlueInkPen>();
        blackInkPenList = new ArrayList<BlackInkPen>();
        graphitePencilList = new ArrayList<GraphitePencil>();
        coloredPencilList = new ArrayList<ColoredPencil>();
        staplerList = new ArrayList<Stapler>();

        commonList = new ArrayList<Stationery>();
    }


    public OfficeKit addBlueInkPen(String name, int cost)
    {
        val item = new BlueInkPen(name, cost);
        commonList.add(item);
        blueInkPenList.add(item);
        return this;
    };
    public OfficeKit addBlackInkPen(String name, int cost)
    {
        val item = new BlackInkPen(name, cost);
        commonList.add(item);
        blackInkPenList.add(item);
        return this;
    };
    public OfficeKit addGraphitePencil(String name, int cost)
    {
        val item = new GraphitePencil(name, cost);
        commonList.add(item);
        graphitePencilList.add(item);
        return this;
    };
    public OfficeKit addColoredPencil(String name, int cost, String color)
    {
        val item = new ColoredPencil(name, cost, color);
        commonList.add(item);
        coloredPencilList.add(item);
        return this;
    };
    public OfficeKit addStapler(String name, int cost)
    {
        val item = new Stapler(name, cost);
        commonList.add(item);
        staplerList.add(item);
        return this;
    };

    public OfficeKit removeItem(int numInCommonList)
    {
        Stationery rms = commonList.remove(numInCommonList);
        if(blackInkPenList.contains(rms)) blackInkPenList.remove(rms);
        if(blueInkPenList.contains(rms)) blueInkPenList.remove(rms);
        if(graphitePencilList.contains(rms)) graphitePencilList.remove(rms);
        if(coloredPencilList.contains(rms)) coloredPencilList.remove(rms);
        if(staplerList.contains(rms)) staplerList.remove(rms);
        return this;
    }
    public OfficeKit removeItem(Stationery item)
    {
        int num = commonList.indexOf(item);
        if(num>=0) removeItem(num);
        return this;
    }

    public OfficeKit sortByNames()
    {
        Collections.sort(commonList, Stationery.COMPARE_BY_NAME);
        return this;
    }
    public OfficeKit sortByCosts()
    {
        Collections.sort(commonList, Stationery.COMPARE_BY_COST);
        return this;
    }

    public OfficeKit sortByCostsNames()
    {
        Collections.sort(commonList, Stationery.COMPARE_BY_COST_AND_NAME);
        return this;
    }

    public OfficeKit showAllItems(){
        for (val item: commonList) System.out.println(item.toString());
        System.out.println("===============================");
        return this;
    }

    public OfficeKit showTotalCost(){
        System.out.println(getTotalCost().toString());
        return this;
    }

    public Integer getTotalCost()
    {
        Integer sumCost = 0;
        for (val item:commonList) {sumCost+=item.getCost();}
        return sumCost;
    }

}
