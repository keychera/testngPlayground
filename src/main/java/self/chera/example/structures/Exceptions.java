package self.chera.example.structures;

public class Exceptions {
    public static class ExceptionTwoDoingTransactionA extends RuntimeException {}
    public static class ExceptionThreeDoingTransactionA extends RuntimeException {}
    public static class ExceptionTheRestDoingTransactionA extends RuntimeException {}

    public static class ExceptionThreeDoingTransactionB extends RuntimeException {}

    public static class ExceptionOneTwoThreeDoingTransactionC extends RuntimeException {}
}
