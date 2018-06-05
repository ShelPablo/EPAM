import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
//import org.graalvm.compiler.nodes.memory.Access;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecordInNotepad {
    final String topic;
    enum NoteType {TODO, INFO, DONE}
    NoteType noteType;
    enum Importancy{THEHIGHEST, VERYHIGH, HIGH, NOTHIGH, LOW }
    final Importancy importancy;
    LocalDateTime dateTimeLastChange;
    String note;

    @Override
    public String toString(){
        return  "\t" + topic + "\n"
                + "\t" + dateTimeLastChange.format(DateTimeFormatter.ofPattern("hh:mm dd.MM.yyyy"))+ "\n"
                + "\t\t" + "Type: " + noteType.name() + "\n"
                + "\t\t" + "Importancy: " + importancy.name() + "\n"
                + note;

    }

}
