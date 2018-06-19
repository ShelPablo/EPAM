import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    static final String inputFile = "Main_quiz.java";

    @Test
    void findoutAllKeywords() {
        Task2 t2 = Task2.create("Main_quiz.java");
        t2.findoutAllKeywords();
        String[] words = t2.getWords();
        for(val w: words) System.out.println(w);
    }
}