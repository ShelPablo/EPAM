import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void BankPerformance() {
        Bank b = new Bank();
        b.loadAccountsFromXML("accounts.xml");


    }
}