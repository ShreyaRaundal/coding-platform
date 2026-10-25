
package repository;

import java.util.Optional;
import model.Submission;

public interface SubmissionRepository {

    void save(Submission submission);

    Optional<Submission> findById(String submissionId);
}
