
package model;

import enums.ProgrammingLanguage;
import enums.SubmissionStatus;

public class Submission {

    private String submissionId;
    private User user;
    private Problem problem;
    private String sourceCode;
    private ProgrammingLanguage language;
    private SubmissionStatus status;
    private long executionTime;

    public Submission(
            String submissionId,
            User user,
            Problem problem,
            String sourceCode,
            ProgrammingLanguage language) {

        this.submissionId = submissionId;
        this.user = user;
        this.problem = problem;
        this.sourceCode = sourceCode;
        this.language = language;
        this.status = SubmissionStatus.PENDING;
        this.executionTime = 0;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public User getUser() {
        return user;
    }

    public Problem getProblem() {
        return problem;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public ProgrammingLanguage getLanguage() {
        return language;
    }

    public SubmissionStatus getStatus() {
        return status;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void updateStatus(SubmissionStatus status) {
        this.status = status;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }
}
