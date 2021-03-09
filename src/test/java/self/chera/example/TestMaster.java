package self.chera.example;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.atomic.AtomicReference;

public class TestMaster implements IHookable {
    protected AtomicReference<String> testName = new AtomicReference<>();

    @BeforeMethod
    void saveCurrentTestName(ITestResult iTestResult) {
        testName.set(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
    }

    public static void pass() {
        System.out.println("Pass");
    }
}
