
# Online Coding Platform — Java LLD

A Low-Level Design (LLD) implementation of an online coding judge inspired by platforms such as LeetCode and HackerRank.

## Overview

This project demonstrates object-oriented design, SOLID principles, and design patterns for managing coding problems, submissions, test cases, and judging results.

## Features

- Model users, problems, test cases, and submissions
- Support Java and Python executor abstractions
- Evaluate test-case outputs through a judge service
- Track submission statuses
- Store and retrieve submissions through a repository abstraction
- Model contests and participants

## Design Patterns

| Pattern | Implementation | Purpose |
|---|---|---|
| Strategy | CodeExecutor, JavaExecutor, PythonExecutor | Encapsulate interchangeable execution behavior |
| Factory | ExecutorFactory | Select an executor based on programming language |
| Repository | SubmissionRepository, InMemorySubmissionRepository | Separate storage from business logic |

## Architecture

```text
Main
 |
 v
SubmissionService
 |
 +----> SubmissionRepository
 |
 v
JudgeService
 |
 v
ExecutorFactory
 |
 v
CodeExecutor
 |             |
JavaExecutor  PythonExecutor
 |
 v
ExecutionResult
```

## Submission Workflow

1. Validate the submission.
2. Create a submission with a unique ID.
3. Save the submission.
4. Invoke the judge service.
5. Select an executor for the requested language.
6. Evaluate the test-case results.
7. Save and return the final submission status.

## Technology Stack

- Java
- Object-Oriented Programming
- SOLID principles
- Design patterns
- In-memory storage using Java collections

## Run Locally

Requires a JDK with `java` and `javac` available in the terminal.

Compile from the project root:

```bash
javac -d out src/model/*.java src/enums/*.java src/executor/*.java src/repository/*.java src/service/*.java src/Main.java
```

Run:

```bash
java -cp out Main
```

## Current Limitations

- Code execution is mocked; arbitrary submitted code is not actually compiled or run.
- The in-memory repository does not persist data after the application exits.
- Contest scoring and leaderboard functionality may require further integration.
- Production deployment would require secure sandboxing, resource limits, persistent storage, and asynchronous judging.

## Future Improvements

- Implement the State pattern for submission lifecycle transitions.
- Add Observer-based submission notifications.
- Add unit and integration tests.
- Introduce a persistent database.
- Implement secure, isolated code execution.

## Learning Goals

This project demonstrates separation of concerns, polymorphism, abstraction, extensibility, and maintainable Java LLD.
