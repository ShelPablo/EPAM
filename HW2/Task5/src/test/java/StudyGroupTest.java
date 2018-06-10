import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudyGroupTest {

    StudyGroup sg_java = new StudyGroup(Discipline.JAVA, "Java");
    StudyGroup sg_c_sh = new StudyGroup(Discipline.C_SHARP, "C#");

    Student vanya = new Student("Ivanov Ivan");
    Student sema = new Student("Semenov Semen");
    Student pasha = new Student("Pavlov Pavel");
    Student sidor = new Student("Sidorov Sidor");


    @Test
    void marksTypeChecking() {
        sg_java.addStudent(vanya);
        sg_c_sh.addStudent(vanya);

        assertFalse(sg_java.putMark(vanya, 1.9));
        assertTrue(sg_java.putMark(vanya, 1));
        assertFalse(sg_c_sh.putMark(vanya, 1));
        assertTrue(sg_c_sh.putMark(vanya, 1.0));
    }


    @Test
    void checkAdding() {
        assertTrue(sg_java.addStudent(vanya));
        assertTrue(sg_java.addStudent(sema));
        assertTrue(sg_java.addStudent(pasha));
        assertFalse(sg_java.addStudent(sema));

        assertEquals("Ivanov Ivan\n"+
                        "Pavlov Pavel\n"+
                        "Semenov Semen\n",

                        sg_java.getAllStudents());

        assertTrue(sg_c_sh.addStudent(vanya));
        assertTrue(sg_c_sh.addStudent(sema));
        assertTrue(sg_c_sh.addStudent(sidor));
        assertFalse(sg_c_sh.addStudent(sema));

        assertEquals("Ivanov Ivan\n"+
                        "Semenov Semen\n"+
                        "Sidorov Sidor\n",

                        sg_c_sh.getAllStudents());
//    }
//    @Test
//    void checkRemoving() {

        assertTrue(sg_c_sh.removeStudent(vanya));
        assertTrue(sg_c_sh.removeStudent(sema));
        assertFalse(sg_c_sh.removeStudent(sema));

        assertEquals("Sidorov Sidor\n",

                sg_c_sh.getAllStudents());

    }


    @Test
    void findStudentCheckAndMarksCompare() {
        StudyGroup sg_python = new StudyGroup(Discipline.PYTHON, "Python");

        sg_python.addStudent(vanya);
        sg_python.addStudent(pasha);
        sg_python.addStudent(sema);

        sg_java.addStudent(pasha);
        sg_java.addStudent(sema);

        sg_c_sh.addStudent(vanya);
        sg_c_sh.addStudent(sidor);

        //создание полного списка групп, из которых ищем все, содержащие студента
        ArrayList<StudyGroup> sgList = new ArrayList<StudyGroup>();
        sgList.add(sg_java);
        sgList.add(sg_c_sh);
        sgList.add(sg_python);

        ArrayList<StudyGroup> sglPavel =
            StudyGroup.getGroupListFor(pasha, sgList);
        val sglSemen = StudyGroup.getGroupListFor(sema, sgList);
        val sglSidor = StudyGroup.getGroupListFor(sidor, sgList);
        val sglIvan = StudyGroup.getGroupListFor(vanya, sgList);

        assertEquals("[Java, Python]",
                sglPavel.toString());



        sg_java.putMark(pasha, 4);
        sg_java.putMark(pasha, 5);
        sg_java.putMark(pasha, 5);

        sg_python.putMark(pasha, 4.3);
        sg_python.putMark(pasha, 5.2);
        sg_python.putMark(pasha, 3.9);
        sg_python.putMark(pasha, 4.8);

        assertEquals("Java: [4, 5, 5]\n"+
                                "Python: [4.3, 5.2, 3.9, 4.8]\n",
                StudyGroup.getAllMarksFor(pasha, sgList)

        );





    }
}