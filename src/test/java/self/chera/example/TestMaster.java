package self.chera.example;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class TestMaster implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        System.out.println(testResult.getName());
        callBack.runTestMethod(testResult);
    }

    public static void pass() {
        System.out.println("Pass");
    }


}
