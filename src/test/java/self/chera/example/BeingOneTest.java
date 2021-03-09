package self.chera.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import self.chera.example.structures.Being;
import self.chera.example.structures.Exceptions;

import static org.testng.Assert.fail;

public class BeingOneTest extends TestMaster {
    Being being;

    @BeforeClass
    void createBeingToTest() {
        being = new Being();
    }

    @Test
    void verifyTransactionA() {
        being.doTransactionA();
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
