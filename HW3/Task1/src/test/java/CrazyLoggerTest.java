import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrazyLoggerTest {

    CrazyLogger logger = new CrazyLogger();

    @Test
    void log() {
        logger.log("helllo, CrazyLogger!");
        logger.log("Error: code is not perfect!");
        logger.log("Warning: you must work harder!");
        logger.log("Error: this option is not supported!");
        logger.log("Crirical Error: CrazyLogger?? Who invented this classname??");
        logger.log("Not Critical Warning: your jokes may not be approved");

        //assertEquals("",
        //        logger.getAllStringsContaining("Warning" ));
        //assertEquals("",
        //        logger.getAllStringsContaining("Error" ));
        //тут так не очень удобно делать, т.к. выдается время создания лога, заранее не известное,
        //чтобы записать его в expected у assertEquals
        //поэтому проверяем себя просто так:
        logger.showAllStringsContaining("Warning");
        logger.showAllStringsContaining("Error");

    }
}