package self.chera.example;

import lombok.Builder;
import org.testng.annotations.Test;
import self.chera.example.structures.Being;

@Builder
public class TransactionTestSet {
    private final Being being;
    @Builder.Default private final Evaluator transactionAStory = Evaluator.builder().build();
    @Builder.Default private final Evaluator transactionBStory = Evaluator.builder().build();
    @Builder.Default private final Evaluator transactionCStory = Evaluator.builder().build();
    @Builder.Default private final Evaluator transactionPositiveStory = Evaluator.builder().build();

    @Test
    void doTransactionA() {
        try {
            being.doTransactionA();
            transactionAStory.passingHandler.run();
        } catch (RuntimeException e) {
            transactionAStory.exceptionHandler.accept(e);
        }
    }

    @Test
    void doTransactionB() {
        try {
            being.doTransactionB();
            transactionBStory.passingHandler.run();
        } catch (RuntimeException e) {
            transactionBStory.exceptionHandler.accept(e);
        }

    }

    @Test
    void doTransactionC() {
        try {
            being.doTransactionC();
            transactionCStory.passingHandler.run();
        } catch (RuntimeException e) {
            transactionCStory.exceptionHandler.accept(e);
        }
    }

    @Test
    void doTransactionPositive() {
        try {
            being.doTransactionAlwaysPositive();
            transactionPositiveStory.passingHandler.run();
        } catch (RuntimeException e) {
            transactionPositiveStory.exceptionHandler.accept(e);
        }
    }
}
