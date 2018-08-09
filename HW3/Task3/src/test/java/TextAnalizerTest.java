import lombok.SneakyThrows;
import lombok.val;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static org.junit.jupiter.api.Assertions.*;

class TextAnalizerTest {

    TextAnalizer ta = new TextAnalizer();

    @org.junit.jupiter.api.Test
    void loadFile() {
        ta.loadFile("task_attachment.html");
        ta.selectBody();
        ta.deleteAllTags();



        System.out.println(ta.getEditedText());
    }

    @SneakyThrows
    @org.junit.jupiter.api.Test
    void splitFile() {

        String str = "jksnk<body><h1>a<<<b</h1> zzgz </body>  hddsg";
        //String[] spl = Pattern.compile("<+").split(str);
        //for(String s : spl) System.out.println(s);

        Matcher m = Pattern.compile("<body>(.*)</body>").matcher(str);

        if(m.find()) System.out.println(m.group(1));

        //prepareFile();
        //System.out.println(ta.getParagraph(14));


    }


    @org.junit.jupiter.api.Test
    void referenceParser() {
        ta.referenceParser("references.txt");


    }
}