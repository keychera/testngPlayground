package self.chera.example.structures;


public class Being {
    public int value = 1;

    /*
        assume val > 0
        TransactionA can only be done by value 1
        TransactionB can only be done by every value but 3
        TransactionC can only be done value by more than 3
     */

    public void doTransactionA() {
        if (value > 1) {
            if (value == 2) {
                throw new Exceptions.ExceptionTwoDoingTransactionA();
            } else if (value == 3) {
                throw new Exceptions.ExceptionThreeDoingTransactionA();
            } else {
                throw new Exceptions.ExceptionTheRestDoingTransactionA();
            }
        }
    }

    public void doTransactionB() {
        if (value == 3) {
            throw new Exceptions.ExceptionThreeDoingTransactionB();
        }
    }

    public void doTransactionC() {
        if (value <= 3) {
            throw new Exceptions.ExceptionOneTwoThreeDoingTransactionC();
        }
    }
}
