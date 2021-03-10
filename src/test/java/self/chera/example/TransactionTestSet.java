package self.chera.example;

import io.qameta.allure.testng.TestInstanceParameter;
import lombok.Builder;
import org.testng.annotations.Test;
import self.chera.example.structures.Being;

@Builder
public class TransactionTestSet extends TestMaster {
    @TestInstanceParameter("Being")
    private final Being actor;
    @Builder.Default
    private final Evaluator transactionAStory = Evaluator.builder().build();
    @Builder.Default
    private final Evaluator transactionBStory = Evaluator.builder().build();
    @Builder.Default
    private final Evaluator transactionCStory = Evaluator.builder().build();
    @Builder.Default
    private final Evaluator transactionPositiveStory = Evaluator.builder().build();

    @Test
    void doTransactionA() {
        try {
            actor.doTransactionA();
            transactionAStory.passingHandler.run();
        } catch (RuntimeException e) {
            transactionAStory.exceptionHandler.accept(e);
        }
    }

    @Test
    void doTransactionB() {
        try {
            actor.doTransactionB();
            transactionBStory.passingHandler.run();
        } catch (RuntimeException e) {
            transactionBStory.exceptionHandler.accept(e);
        }

    }

    @Test
    void doTransactionC() {
        try {
            actor.doTransactionC();
            transactionCStory.passingHandler.run();
        } catch (RuntimeException e) {
            transactionCStory.exceptionHandler.accept(e);
        }
    }

    @Test
    void doTransactionPositive() {
        try {
            actor.doTransactionAlwaysPositive();
            transactionPositiveStory.passingHandler.run();
        } catch (RuntimeException e) {
            transactionPositiveStory.exceptionHandler.accept(e);
        }
    }
}
