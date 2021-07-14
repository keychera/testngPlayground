package self.chera.config;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import self.chera.example.structures.Being;

// this is used following this: https://stackoverflow.com/a/45693082
public class AllureModifierListener implements TestLifecycleListener {
    @Override
    public void afterTestStop(TestResult result) {
        var param = result.getParameters().stream().filter(p -> p.getName().equals(Being.class.getSimpleName())).findFirst();
        if (param.isPresent()) {
            var name = result.getName();
            result.setName(param.get().getValue() + " " + name);
        }
    }
}
