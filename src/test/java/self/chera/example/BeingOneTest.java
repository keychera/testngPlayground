package self.chera.example;

import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import self.chera.example.structures.Being;
import self.chera.example.structures.Exceptions;

import static org.testng.Assert.fail;

public class BeingOneTest extends TestMaster {
    Being being = Being.builder().value(1).build();

    @Factory
    Object[] verifyAllTransactions() {
        return new TransactionTestSet[]{TransactionTestSet.builder()
                .being(being)
                .transactionAStory(Evaluator.builder()
                        .passingHandler(TestMaster::pass)
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
