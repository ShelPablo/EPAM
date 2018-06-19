import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.NonFinal;
import lombok.val;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Task2 {
    //знать наизусть!
    static String[] KEYWORDS = {"abstract", "assert",  "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float",
            "for", "goto" /**/, "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while"};

    static  ArrayList<String> keyWords = new ArrayList<String>();//Arrays.asList(KEYWORDS);

    @SneakyThrows
    static Task2 create(String inputFile){
        File file = new File("src/main/resources/"+inputFile);
        //проверяем, что файл есть, и что он не больше 10 МБ
        if (!file.exists() | file.length() > 10*1024*1024) return null;
        int fsize = (int) file.length();
        char[] s = new char[fsize];
        try (InputStreamReader isr =
                     new InputStreamReader(new FileInputStream(file)/*, "windows-1251"*/);)
        {
            isr.read(s);
        }
        return new Task2(String.valueOf(s), inputFile);
    }

    private Task2(String text, String filename){
        this.text = text;
        this.filename = filename;
        foundKW = new HashMap<String, Integer>();
        Collections.addAll(keyWords, KEYWORDS);
    }

    String filename;

    String text;

    @Getter
    @NonFinal
    String[] words;

    HashMap<String, Integer> foundKW;
    /**
     *
     */
    public void findoutAllKeywords()
    {
        splitTextIntoWords();
        for (val w:words) {
            if(keyWords.contains(w)){
                //подсмотрено здесь: https://stackoverflow.com/questions/81346/most-efficient-way-to-increment-a-map-value-in-java
                //там же более эффективные (по перформансу) способы инкремента инта в мапе
                int count = foundKW.containsKey(w) ? foundKW.get(w) : 0;
                foundKW.put(w, count + 1);
            }
        }
        writeOutputFile();

    }

    void splitTextIntoWords(){
        words = Pattern.compile("\\W+").split(text);//[\\s,}{)(]+
    }

    @SneakyThrows
    void writeOutputFile(){
        File file = new File("src/main/resources/"+filename+".jkeywords");
        try (Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "UTF8"))) {
            out.write(foundKW.toString());
        }
    }


}
