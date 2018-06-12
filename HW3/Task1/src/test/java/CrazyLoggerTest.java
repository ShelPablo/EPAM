import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrazyLoggerTest {

    CrazyLogger logger = new CrazyLogger();

    @Test
    void log() {
        logger.log("helllo, CrazyLogger!");
        System.out.println(logger.getLog());

    }
}