import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    }
    public void showAllStringsContaining(String wordForFinding)
    {
        System.out.println(getAllStringsContaining(wordForFinding));
    }



    String logDateTime(){
        return  LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm"))+" - ";
    }




}
