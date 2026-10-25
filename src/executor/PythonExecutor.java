
package executor;

import model.ExecutionResult;
import model.TestCase;

public class PythonExecutor implements CodeExecutor {

    @Override
    public ExecutionResult execute(
            String sourceCode,
            TestCase testCase) {

        return new ExecutionResult(
                "",
                "Mock Python execution is not configured.",
                0,
                false
        );
    }
}
