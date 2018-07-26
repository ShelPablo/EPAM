import lombok.val;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniversalClassTest {

    @Test
    void readPropertyFile() {
        val uc = UniversalClass.getInstance("someprops");
        //System.out.println(uc.getProps());
        Integer num = uc.getAs("Integer", "num");
        Byte byt = uc.getAs("Byte", "byt");
        String str=uc.getProps().get("str");//hello
        Double dub=uc.getAs("Double", "dub");//90.3456
        Float flt=uc.getAs("Float", "flt");//1.2345
        Boolean bul=uc.getAs("Boolean", "bol");//false
        Character chr=uc.getChar("chr");//X

        assertEquals("3, 125, hello, 90,345600, 1,234500, true, X",
                String.format("%d, %d, %s, %f, %f, %b, %c",
                        num, byt, str, dub, flt, bul, chr)
                );
    }




}