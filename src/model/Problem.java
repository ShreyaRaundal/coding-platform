
package model;

import enums.Difficulty;
import java.util.List;

public class Problem {

    private String problemId;
    private String title;
    private String description;
    private Difficulty difficulty;
    private List<String> constraints;
    private List<TestCase> testCases;

    public Problem(
            String problemId,
            String title,
            String description,
            Difficulty difficulty,
            List<String> constraints,
            List<TestCase> testCases) {

        this.problemId = problemId;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.constraints = constraints;
        this.testCases = testCases;
    }

    public String getProblemId() {
        return problemId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public List<String> getConstraints() {
        return constraints;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }
}
