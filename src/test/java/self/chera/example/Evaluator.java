package self.chera.example;

import jdk.jshell.spi.ExecutionControl;
import lombok.Builder;

import java.util.function.Consumer;

@Builder
public class Evaluator {
    @Builder.Default
    Runnable passingHandler = () -> {
        throw new UnsupportedOperationException("not implemented yet");
    };
    @Builder.Default
    Consumer<RuntimeException> exceptionHandler = exception -> {
        throw exception;
    };
}