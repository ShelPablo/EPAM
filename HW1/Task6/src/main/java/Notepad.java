import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notepad {
    ArrayList<RecordInNotepad> recs;
    String currentTopic;
    //HashSet<String> topics;

    public Notepad(String firstTopic)
    {
        recs = new ArrayList<>();
        this.currentTopic = firstTopic;
    }

    public void addRecord(
            RecordInNotepad.NoteType noteType,
            RecordInNotepad.Importancy importancy,
            String note)
    {
        addRecord(currentTopic, noteType, importancy, note);
    }
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

    public void removeRecord(int recnum){ recs.remove(recnum-1); }


    public void editRecord(int recnum, String note){ recs.get(recnum-1).setNote(note); }
    public void editRecord(int recnum, RecordInNotepad.NoteType newType){ recs.get(recnum-1).setNoteType(newType); }
    public void editRecord(int recnum, String note, RecordInNotepad.NoteType newType)
    {
        recs.get(recnum-1).setNote(note);
        recs.get(recnum-1).setNoteType(newType);
    }

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
