public class main_test {
    public static void main(String[] args) {
        Notepad np = new Notepad("Java courses");
        np.addRecord(RecordInNotepad.NoteType.TODO, RecordInNotepad.Importancy.THEHIGHEST,
                "Сделать ДЗ !!!!");
        np.addRecord(RecordInNotepad.NoteType.INFO, RecordInNotepad.Importancy.HIGH,
                "Для подключения Lombok в Maven в pom.xml прописать:\n" +
                        "        <dependency>\n" +
                        "            <groupId>org.projectlombok</groupId>\n" +
                        "            <artifactId>lombok</artifactId>\n" +
                        "            <version>1.16.22</version>\n" +
                        "            <scope>provided</scope>\n" +
                        "        </dependency>  ");
        np.addRecord(RecordInNotepad.NoteType.TODO, RecordInNotepad.Importancy.THEHIGHEST,
                "Сходить на лекцию !!!!");
        //смена темы
        np.addRecord("Family", RecordInNotepad.NoteType.TODO, RecordInNotepad.Importancy.HIGH,
                "После лекции зайти в магазин, купить молока!!");
        np.addRecord(RecordInNotepad.NoteType.TODO, RecordInNotepad.Importancy.HIGH,
                "и хлеба!!");
        //опять смена темы
        np.addRecord("Java courses", RecordInNotepad.NoteType.INFO, RecordInNotepad.Importancy.NOTHIGH,
                "В MarketPlace скидки после 18:00 25%");



        System.out.println("БЛОКНОТ ДО ИЗМЕНЕНИЙ:\n\n\n\n\n");
        np.showAllRecs();


        //изменения в блокноте
        np.removeRecord(5);
        np.editRecord(4, "После лекции зайти в магазин, купить молока и хлеба");
        np.editRecord(1, RecordInNotepad.NoteType.DONE);


        System.out.println();
        System.out.println("БЛОКНОТ ПОСЛЕ ИЗМЕНЕНИЙ:\n\n\n\n\n");
        np.showAllRecs();




    }
}
