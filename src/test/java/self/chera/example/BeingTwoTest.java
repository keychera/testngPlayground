package self.chera.example;

import org.testng.annotations.Test;
import self.chera.example.structures.Being;
import self.chera.example.structures.Exceptions;

import static org.testng.Assert.fail;

public class BeingTwoTest extends TestMaster {
    Being being = Being.builder().value(2).build();

    @Test
    void verifyTransactionA() {
        try {
            being.doTransactionA();
            fail();
        } catch (Exceptions.ExceptionTwoDoingTransactionA e) {
            e.printStackTrace();
        }
    }

    @Test
    void verifyTransactionB() {
        being.doTransactionB();
    }

    @Test
    void verifyTransactionC() {
        try {
            being.doTransactionC();
            fail();
        } catch (Exceptions.ExceptionOneTwoThreeDoingTransactionC e) {
            e.printStackTrace();
        }
    }
}
