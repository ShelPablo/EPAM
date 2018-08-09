import lombok.*;
import lombok.experimental.NonFinal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    @AllArgsConstructor
    static class Reference
    {
        //String[] authors;
        String authors;
        String article;
        String journal;
        String  year_pages;

        public static Reference parse(String s)
        {

            String[] buf = s.split("\\.");
            if(buf.length<5) return null;
            return new Reference(buf[1], buf[2], buf[3], buf[4]);
        }

        @Override
        public String toString()
        {
            return String.format("%s:    ''%s''.    \n\t%s, %s",
                    authors, article, journal, year_pages);
        }

    }




    @SneakyThrows
    public void referenceParser(String filename)
    {
        Path p = Paths.get(getClass().getResource(filename).toURI());
        List<Reference> refList =  Files.lines(p)
                .filter(x->!x.isEmpty())
                .map(Reference::parse)
                .peek(System.out::println)
                .collect(Collectors.toList());
        refList.forEach(System.out::println);

    }




}
