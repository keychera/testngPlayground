package self.chera.example.structures;


import lombok.Builder;

import java.util.Optional;

@Builder
public class Being {
    public int value;

    /*
        assume val > 0
        TransactionA can only be done by value 1
        TransactionB can only be done by every value but 3
        TransactionC can only be done value by more than 3
     */

    private void printTransactionName() {
        StackWalker walker = StackWalker.getInstance();
        Optional<String> invokingMethodName = walker.walk(frames -> frames
                .skip(1).findFirst()
                .map(StackWalker.StackFrame::getMethodName));
        System.out.println(invokingMethodName.orElse("[unknown trx]") + " is done!");
    }

    public void doTransactionA() {
        if (value > 1) {
            if (value == 2) {
                throw new Exceptions.ExceptionTwoDoingTransactionA();
            } else if (value == 3) {
                throw new Exceptions.ExceptionThreeDoingTransactionA();
            } else {
                throw new Exceptions.ExceptionTheRestDoingTransactionA();
            }
        } else {
            printTransactionName();
        }
    }

    public void doTransactionB() {
        if (value == 3) {
            throw new Exceptions.ExceptionThreeDoingTransactionB();
        } else {
            printTransactionName();
        }
    }

    public void doTransactionC() {
        if (value <= 3) {
            throw new Exceptions.ExceptionOneTwoThreeDoingTransactionC();
        } else {
            printTransactionName();
        }
    }

    public void doTransactionAlwaysPositive(){
        printTransactionName();
    }
}
