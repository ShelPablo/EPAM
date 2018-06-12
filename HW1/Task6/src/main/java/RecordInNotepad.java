import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
//import org.graalvm.compiler.nodes.memory.Access;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
/**
 * Запись для блокнота.
 */
public class RecordInNotepad {
    /**
     * Тема записи
     */
    final String topic;

    /**
     * Тип записи (перечисление): что-то сделать (TОDO)/сделано (DONE)/просто информация (INFO)
     */
    public enum NoteType {TODO, INFO, DONE}
    NoteType noteType;

    /**
     * Важность записи (перечисление: THEHIGHEST, VERYHIGH, HIGH, NOTHIGH, LOW)
     */
    public enum Importancy{THEHIGHEST, VERYHIGH, HIGH, NOTHIGH, LOW }
    final Importancy importancy;
    /**
     *
     * Дата и время, когда сделана запись
     */
    LocalDateTime dateTimeLastChange;
    /**
     * Непосредственно заметка
     */
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
