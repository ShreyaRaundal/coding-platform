
package executor;

import enums.ProgrammingLanguage;

public class ExecutorFactory {

    public static CodeExecutor getExecutor(
            ProgrammingLanguage language) {

        if (language == null) {
            throw new IllegalArgumentException(
                    "Programming language cannot be null");
        }

        switch (language) {
            case JAVA:
                return new JavaExecutor();

            case PYTHON:
                return new PythonExecutor();

            default:
                throw new IllegalArgumentException(
                        "Unsupported programming language: " + language);
        }
    }
}
