import lombok.val;
import lombok.var;

import java.util.ArrayList;
import java.util.HashMap;

public class StudyGroup {

    StudyGroup(Discipline discipline, String groupName)
    {
        this.discipline = discipline;
        markTable = new HashMap<Student, ArrayList<Mark>>();
        this.groupName = groupName;
    }

    String groupName;

    Discipline discipline;

    public static String getAllMarksFor(Student student, ArrayList<StudyGroup> sgList) {
        val sgStudent = getGroupListFor(student, sgList);
        if(sgList.isEmpty()) return "No such student";
        val discilineMarkTable = new StringBuilder();
        for (val sg:sgStudent)
            discilineMarkTable.append(sg.toString()+": "+
                    sg.getMarks(student).toString()+"\n");
        return discilineMarkTable.toString();
    }

    public ArrayList<Mark> getMarks(Student student) {
        if(!markTable.containsKey(student)) return null;
        return markTable.get(student);
    }


    public HashMap<Student, ArrayList<Mark>> getMarkTable() {
        return markTable;
    }

    HashMap<Student, ArrayList<Mark>> markTable;

    public static ArrayList<StudyGroup> getGroupListFor(Student student, ArrayList<StudyGroup> sgList)
    {
        var sglForStudent = new ArrayList<StudyGroup>(); // sgl - StudyGroupList
        for (val sg:sgList) if(sg.getMarkTable().containsKey(student)) sglForStudent.add(sg);
        return sglForStudent;
    }

    public boolean addStudent(Student student)
    {
        if(markTable.containsKey(student)) return false;
        markTable.put(student, new ArrayList<Mark>());
        return true;
    }

    public boolean putMark(Student student, double mark)
    {
        if(discipline.isIntMarked()) return false;
        markTable.get(student).add(new Mark<Double>(mark));
        return true;
    }

    public boolean putMark(Student student, int mark)
    {
        if(!discipline.isIntMarked()) return false;
        markTable.get(student).add(new Mark<Integer>(mark));
        return true;
    }

    public String getAllStudents()
    {
        var studentList = new StringBuilder();
        for (Student st:markTable.keySet()) studentList.append(st.toString()+"\n");
        return studentList.toString();
    }


    public boolean removeStudent(Student student) {
        if(!markTable.containsKey(student)) return false;
        markTable.remove(student);
        return true;
    }
    @Override
    public String toString(){return groupName;}


}
