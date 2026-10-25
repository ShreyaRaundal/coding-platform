
package service;

import enums.SubmissionStatus;
import executor.CodeExecutor;
import executor.ExecutorFactory;
import model.ExecutionResult;
import model.Problem;
import model.Submission;
import model.TestCase;

import java.util.function.Function;

public class JudgeService {

    private final Function<Submission, CodeExecutor> executorProvider;

    // Production wiring: choose an executor using the Factory.
    public JudgeService() {
        this.executorProvider = submission ->
                ExecutorFactory.getExecutor(submission.getLanguage());
    }

    // Test wiring: inject a fake executor.
    public JudgeService(CodeExecutor executor) {
        this.executorProvider = submission -> executor;
    }

    public SubmissionStatus judge(Submission submission) {
        submission.updateStatus(SubmissionStatus.RUNNING);

        Problem problem = submission.getProblem();
        CodeExecutor executor = executorProvider.apply(submission);
        long totalTime = 0;

        try {
            for (TestCase testCase : problem.getTestCases()) {
                ExecutionResult result = executor.execute(
                        submission.getSourceCode(), testCase);

                totalTime += result.getExecutionTimeMs();
                submission.setExecutionTime(totalTime);

                if (!result.isSuccess()) {
                    submission.updateStatus(SubmissionStatus.RUNTIME_ERROR);
                    return SubmissionStatus.RUNTIME_ERROR;
                }

                String actual = normalize(result.getOutput());
                String expected = normalize(testCase.getExpectedOutput());

                if (!actual.equals(expected)) {
                    submission.updateStatus(SubmissionStatus.WRONG_ANSWER);
                    return SubmissionStatus.WRONG_ANSWER;
                }
            }

            submission.updateStatus(SubmissionStatus.ACCEPTED);
            return SubmissionStatus.ACCEPTED;

        } catch (RuntimeException exception) {
            submission.updateStatus(SubmissionStatus.RUNTIME_ERROR);
            return SubmissionStatus.RUNTIME_ERROR;
        }
    }

    private String normalize(String output) {
        return output == null ? "" : output.trim();
    }
}
