package self.chera.example;

import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import self.chera.example.structures.Being;
import self.chera.example.structures.Exceptions;

import static org.testng.Assert.fail;

public class BeingTwoTest extends TestMaster {
    Being being = Being.builder().value(2).build();

    @Factory
    Object[] verifyAllTransactions() {
        return new TransactionTestSet[]{TransactionTestSet.builder()
                .being(being)
                .transactionAStory(Evaluator.builder()
                        .passingHandler(Assert::fail)
                        .exceptionHandler(e -> {
                            if (e instanceof Exceptions.ExceptionTwoDoingTransactionA) {
                                e.printStackTrace();
                            } else {
                                throw e;
                            }
                        })
                        .build())
                .transactionBStory(Evaluator.builder()
                        .passingHandler(TestMaster::pass)
                        .build())
                .transactionCStory(Evaluator.builder()
                        .passingHandler(Assert::fail)
                        .exceptionHandler(e -> {
                            if (e instanceof Exceptions.ExceptionOneTwoThreeDoingTransactionC) {
                                e.printStackTrace();
                            } else {
                                throw e;
                            }
                        })
                        .build()
                )
                .transactionPositiveStory(Evaluator.builder()
                        .passingHandler(TestMaster::pass)
                        .build()
                )
                .build()};
    }

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
