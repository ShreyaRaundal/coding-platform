
import enums.Difficulty;
import enums.ProgrammingLanguage;
import model.ExecutionResult;
import model.Problem;
import model.Submission;
import model.TestCase;
import model.User;
import repository.InMemorySubmissionRepository;
import repository.SubmissionRepository;
import service.JudgeService;
import service.SubmissionService;
import executor.CodeExecutor;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // 1. Create a user.
        User user = new User(
                "U101", "Shreya", "shreya@example.com");

        // 2. Create test cases.
        TestCase tc1 = new TestCase(
                "TC1", "2 3", "5", false);

        TestCase tc2 = new TestCase(
                "TC2", "10 20", "30", true);

        // 3. Create a problem.
        Problem problem = new Problem(
                "P101",
                "Sum of Two Numbers",
                "Read two numbers and print their sum.",
                Difficulty.EASY,
                Arrays.asList("Numbers are integers"),
                Arrays.asList(tc1, tc2));

        // 4. Create a fake executor for integration testing.
        CodeExecutor fakeExecutor = (sourceCode, testCase) ->
                new ExecutionResult(
                        testCase.getExpectedOutput(),
                        null,
                        5,
                        true);

        // 5. Wire repository and services.
        SubmissionRepository repository =
                new InMemorySubmissionRepository();

        JudgeService judgeService = new JudgeService(fakeExecutor);

        SubmissionService submissionService =
                new SubmissionService(repository, judgeService);

        // 6. Submit code.
        Submission submission = submissionService.submitCode(
                user,
                problem,
                "FAKE TEST CODE",
                ProgrammingLanguage.JAVA);

        // 7. Display the result.
        System.out.println("Submission ID: "
                + submission.getSubmissionId());

        System.out.println("Status: "
                + submission.getStatus());

        System.out.println("Execution time: "
                + submission.getExecutionTime() + " ms");

        // 8. Retrieve the saved submission.
        Submission saved = submissionService.getSubmission(
                submission.getSubmissionId());

        System.out.println("Retrieved status: "
                + saved.getStatus());
    }
}
