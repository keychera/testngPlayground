package self.chera.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import self.chera.example.structures.Being;
import self.chera.example.structures.Exceptions;

import static org.testng.Assert.fail;

public class BeingThreeTest extends TestMaster {
    Being being;

    @BeforeClass
    void createBeingToTest() {
        being = new Being();
        being.value = 3;
    }

    @Test
    void verifyTransactionA() {
        try {
            being.doTransactionA();
            fail();
        } catch (Exceptions.ExceptionThreeDoingTransactionA e) {
            e.printStackTrace();
        }
    }

    @Test
    void verifyTransactionB() {
        try {
            being.doTransactionB();
            fail();
        } catch (Exceptions.ExceptionThreeDoingTransactionB e) {
            e.printStackTrace();
        }
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
