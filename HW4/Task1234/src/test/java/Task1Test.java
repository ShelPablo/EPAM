import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    static final String inputFile = "Main_quiz.java";

    @Test
    void findoutAllKeywords() {
        Task1 t1 = Task1.create("Main_quiz.java");
        t1.findoutAllKeywords();
        String[] words = t1.getWords();
        for(val w: words) System.out.println(w);
    }
}