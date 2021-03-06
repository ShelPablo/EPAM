import lombok.val;

import java.util.ArrayList;

public class JuniorToolkit {

    OfficeKit ok;

    JuniorToolkit()
    {
        ok = new OfficeKit("Pavel Shelest");
        ok
                .addBlackInkPen("Parker", 100000)
                .addBlueInkPen("Corvina", 10)
                .addGraphitePencil("bic", 10)
                .addColoredPencil("koh-i-noor_r", 10, "red")
                .addColoredPencil("koh-i-noor_g", 10, "green")
                .addColoredPencil("koh-i-noor_b", 10, "blue")
                .addStapler("Erich Crause", 100);
    }


    public static void main(String[] args) {
        JuniorToolkit myTools = new JuniorToolkit();
        myTools.ok.showAllItems()
                .sortByCosts().showAllItems()
                .sortByNames().showAllItems()
                .sortByCostsNames().showAllItems();


    }
}
