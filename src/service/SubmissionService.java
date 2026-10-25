
package service;

import enums.ProgrammingLanguage;
import enums.SubmissionStatus;
import model.Problem;
import model.Submission;
import model.User;
import repository.SubmissionRepository;

import java.util.UUID;

public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final JudgeService judgeService;

    public SubmissionService(
            SubmissionRepository submissionRepository,
            JudgeService judgeService) {

        this.submissionRepository = submissionRepository;
        this.judgeService = judgeService;
    }

    public Submission submitCode(
            User user,
            Problem problem,
            String sourceCode,
            ProgrammingLanguage language) {

        if (user == null || problem == null) {
            throw new IllegalArgumentException(
                    "User and problem are required");
        }

        if (sourceCode == null || sourceCode.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Source code cannot be empty");
        }

        if (language == null) {
            throw new IllegalArgumentException(
                    "Programming language is required");
        }

        Submission submission = new Submission(
                UUID.randomUUID().toString(),
                user,
                problem,
                sourceCode,
                language
        );

        // Save initial submission.
        submissionRepository.save(submission);

        // Evaluate submission.
        judgeService.judge(submission);

        // Save updated verdict.
        submissionRepository.save(submission);

        return submission;
    }

    public Submission getSubmission(String submissionId) {
        return submissionRepository.findById(submissionId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Submission not found: " + submissionId));
    }
}
