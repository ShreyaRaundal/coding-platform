
package executor;

import model.ExecutionResult;
import model.TestCase;

public class JavaExecutor implements CodeExecutor {

    @Override
    public ExecutionResult execute(
            String sourceCode,
            TestCase testCase) {

        return new ExecutionResult(
                "",
                "Mock Java execution is not configured.",
                0,
                false
        );
    }
}
