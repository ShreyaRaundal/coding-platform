
package model;

public class ExecutionResult {

    private String output;
    private String errorMessage;
    private long executionTimeMs;
    private boolean success;

    public ExecutionResult(
            String output,
            String errorMessage,
            long executionTimeMs,
            boolean success) {

        this.output = output;
        this.errorMessage = errorMessage;
        this.executionTimeMs = executionTimeMs;
        this.success = success;
    }

    public String getOutput() {
        return output;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public long getExecutionTimeMs() {
        return executionTimeMs;
    }

    public boolean isSuccess() {
        return success;
    }
}
