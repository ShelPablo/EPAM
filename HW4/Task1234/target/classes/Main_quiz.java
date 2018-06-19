import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_quiz {

    static final String res = "src/main/resources/",
                        selectLang = "selectLang",//"../resources/selectLang",
                        quiz = "quiz2_",
                        ans = "ans2_",
                        esc = "esc_";
                        //txt = ".txt";

    @SneakyThrows
    public static void main(String[] args) {
        //полезная тема для проверки текущей директории
        //String current = new java.io.File( "." ).getCanonicalPath();
        //System.out.println("Current dir:"+current);
        //========вывод начального сообщения с выбором языка===
        printResourceTxt(res+selectLang);

        //=========выбор языка================
        String lang=null;
        while (lang == null){
            switch (new Scanner(System.in).nextInt())
            {
                case 1: lang = "ru"; break;
                case 2: lang = "en"; break;
                default: errorMesage();
                break;
            }
        }
        //=======загрузка ответов по  языку==========
        ArrayList<String> ansList = new ArrayList<String>();
        loadResourceStrings(ansList, res+ans+lang);
        //=======цикл основного диалога==============
        boolean wantContinue = true;
        while (wantContinue) {

            printResourceTxt(res + quiz + lang );
            System.out.println();
            int qnum = new Scanner(System.in).nextInt();
            switch (qnum)
            {
                case 0: lang = "ru"; break;

                default:
                    if(qnum<=ansList.size()) System.out.println(ansList.get(qnum-1));
                    else errorMesage();
                    break;
            }
            printResourceTxt(res + esc + lang );
            System.out.println();
            wantContinue = (new Scanner(System.in).nextInt()!=0);
        }
    }
    @SneakyThrows
    private static void printResourceTxt(String filename)
    {
        String s;

        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr);)
        {
            while ((s = br.readLine()) != null) System.out.println(s);
        }
    }
    @SneakyThrows
    private static void loadResourceStrings(ArrayList<String> dst, String filename)
    {
        String s;

        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr);)
        {
            while ((s = br.readLine()) != null) dst.add(s);
        }
    }

    private static void errorMesage() {System.out.println("Error input! Try again!\n" +
            "Ошибка ввода! Попробуйте снова!");}


}
