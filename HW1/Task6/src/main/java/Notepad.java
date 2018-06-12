import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

@FieldDefaults(level = AccessLevel.PRIVATE)
/**
 * Класс блокнот
 * Состоит из записей класса RecordInNotepad
 * @author Shelest P.S.
 * @version 0.0
 * @see RecordInNotepad
 */
public class Notepad {
    ArrayList<RecordInNotepad> recs;
    String currentTopic;

    /**
     * В конструкторе сразу определяется тема первой записи
     * (чтобы сразу можно было пользоваться addRecord без указания темы)
     * @param firstTopic - тема первой записи
     */
    public Notepad(String firstTopic)
    {
        recs = new ArrayList<>();
        this.currentTopic = firstTopic;
    }

    /**
     *Добавление записи, определяемой классом RecordInNotepad, без указания темы (тема остается предыдущей)
     * @see RecordInNotepad
     * @param noteType - тип заметки (перечисление) один из трех вариантов: напоминание что-то сделать/ пометка "сделано"/ просто информация
     * @see RecordInNotepad#noteType
     * @param importancy - важность заметки
     * @see RecordInNotepad#importancy
     * @param note - непосредственно заметка
     */
    public void addRecord(
            RecordInNotepad.NoteType noteType,
            RecordInNotepad.Importancy importancy,
            String note)
    {
        addRecord(currentTopic, noteType, importancy, note);
    }
    /**
     *Добавление записи, определяемой классом RecordInNotepad, с указанием темы записи
     * @param topic - тема записи
     * @see RecordInNotepad
     * @param noteType - тип записи (перечисление) один из трех вариантов: напоминание что-то сделать/ пометка "сделано"/ просто информация
     * @see RecordInNotepad#noteType
     * @param importancy - важность записи
     * @see RecordInNotepad#importancy
     * @param note - непосредственно заметка
     */
    public void addRecord(
            String topic,
            RecordInNotepad.NoteType noteType,
            RecordInNotepad.Importancy importancy,
            String note)
    {
        val rec = new RecordInNotepad(topic, importancy);
        rec.setNoteType(noteType);
        rec.setDateTimeLastChange(LocalDateTime.now());
        rec.setNote(note);
        currentTopic = topic;
        recs.add(rec);
    }


    /**
     * Удаление записи по индексу, начальный индекс - 1. Увидеть индексы можно, предварительно вызвав showAllRecs
     * @see Notepad#showAllRecs()
     * @param recnum - номер (=индекс) удаляемой записи (отсчитывается от 1!!)
     */
    public void removeRecord(int recnum){ recs.remove(recnum-1); }


    /**
     * Редактирование заметки в записи по индексу (индекс отсчитывается от 1)
     * @param recnum - номер записи
     * @param note - новая заметка (заменяет старую)
     */
    public void editRecord(int recnum, String note){ recs.get(recnum-1).setNote(note); }

    /**
     * Редактирование типа записи (как правило с ТОDО на DONE)
     * @param recnum - номер (индекс) записи, отсчитываемый с 1
     * @param newType - новый тип заметки вместо старого
     */
    public void editRecord(int recnum, RecordInNotepad.NoteType newType){ recs.get(recnum-1).setNoteType(newType); }

    /**
     * Редакирование одновременно типа записи и заметки
      * @param recnum - номер записи (от 1)
     * @param note - новая замека (заменяет старую)
     * @param newType - новый тип
     * @see RecordInNotepad#noteType
     */
    public void editRecord(int recnum, String note, RecordInNotepad.NoteType newType)
    {
        recs.get(recnum-1).setNote(note);
        recs.get(recnum-1).setNoteType(newType);
    }

    /**
     * Показать все записи с их индексами. Записи при выводе разделяются "=========="
     */
    public void showAllRecs()
    {
        int i=1;
        for (val rec: recs) {
            System.out.print(i++);
            System.out.println(rec.toString());
            System.out.println("=======================================================");
        }
    }

}
