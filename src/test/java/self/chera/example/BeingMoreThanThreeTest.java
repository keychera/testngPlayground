package self.chera.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import self.chera.example.structures.Being;
import self.chera.example.structures.Exceptions;

import java.util.Random;

import static org.testng.Assert.fail;

public class BeingMoreThanThreeTest extends TestMaster {
    Being being;

    @BeforeClass
    void createBeingToTest() {
        being = new Being();
        being.value = 4;
    }

    @Test
    void verifyTransactionA() {
        try {
            being.doTransactionA();
            fail();
        } catch (Exceptions.ExceptionTheRestDoingTransactionA e) {
            e.printStackTrace();
        }
    }

    @Test
    void verifyTransactionB() {
        being.doTransactionB();
    }

    @Test
    void verifyTransactionC() {
        being.doTransactionC();

    }
}