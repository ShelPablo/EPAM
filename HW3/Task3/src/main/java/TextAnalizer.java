import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.NonFinal;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class TextAnalizer {

    static final String res = "src/main/resources/";

    public String getText() {return text;}

    @NonFinal
    String text;
    //ArrayList<String> editedText = new ArrayList<String>();
    @NonFinal
    @Getter
    String editedText;

    /*public String getParagraph(int index)
    {
        return editedText[index];
    }
*/

    @SneakyThrows
    public void loadFile(String filename)
    {
        File file = new File(res+filename);
        if (!file.exists() | file.length() > 10*1024*1024) return;
        int fsize = (int) file.length();
        char[] s = new char[fsize];

        try (InputStreamReader isr =
                     new InputStreamReader(new FileInputStream(file), "windows-1251");)
        {
            isr.read(s);
            //while ((s_buf = isr.re  br.readLine()) != null) s.append(s_buf);
        }
        text = String.valueOf(s);//s.toString();
    }
/*
    public void splitTextByParagraph()
    {
       editedText = Pattern.compile("\n").split(text);
    }

    public void splitTextBySentences()
    {
        editedText = Pattern.compile("\n").split(text);
    }
*/
    public void selectBody()
    {
        Matcher m0 = Pattern.compile("<body>").matcher(text);
        Matcher m1 = Pattern.compile("</body>").matcher(text);
        if(m0.find() && m1.find())
            editedText = text.substring(m0.start(), m1.end());
    }
    public void deleteAllTags()
    {
        Matcher m = Pattern.compile("<.{1,20}>").matcher(editedText);
        editedText = m.replaceAll("");
    }






}
