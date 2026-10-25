
package repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import model.Submission;

public class InMemorySubmissionRepository
        implements SubmissionRepository {

    private final Map<String, Submission> submissions =
            new HashMap<>();

    @Override
    public void save(Submission submission) {
        if (submission == null) {
            throw new IllegalArgumentException("Submission cannot be null");
        }

        submissions.put(submission.getSubmissionId(),submission);
    }

    @Override
    public Optional<Submission> findById(String submissionId) {
        return Optional.ofNullable(submissions.get(submissionId));
    }
}
