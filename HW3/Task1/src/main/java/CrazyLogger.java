import lombok.val;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class CrazyLogger {
    public String getLog() {
        return cumulLog.toString();
    }

    StringBuilder cumulLog;

    public CrazyLogger() {
        cumulLog = new StringBuilder();
    }


    public void log(String message){
        cumulLog.append(logDateTime() + message + "\n");
    }

    public String getAllStringsContaining(String wordForFinding)
    {
        //разбиваем на отдельные строки по символам конца строки
        String[] logs = Pattern.compile("\n").split(cumulLog.toString());
        //выбираем строки, содержащие слово для поиска
        StringBuilder sb = new StringBuilder();
        for (val s:logs) {if(s.contains(wordForFinding)) sb.append(s+"\n");}
        return sb.toString();
    }
    public void showAllStringsContaining(String wordForFinding)
    {
        System.out.println(getAllStringsContaining(wordForFinding));
    }



    String logDateTime(){
        return  LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm"))+" - ";
    }




}
