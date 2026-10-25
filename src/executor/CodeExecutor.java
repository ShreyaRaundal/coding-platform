
package executor;

import model.ExecutionResult;
import model.TestCase;

public interface CodeExecutor {

    ExecutionResult execute(
            String sourceCode,
            TestCase testCase);
}
