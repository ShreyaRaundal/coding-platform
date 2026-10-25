
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Contest {

    private String contestId;
    private String name;
    private List<Problem> problems;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<ContestParticipant> participants;

    public Contest(
            String contestId,
            String name,
            LocalDateTime startTime,
            LocalDateTime endTime) {

        this.contestId = contestId;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.problems = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    public void addProblem(Problem problem) {
        problems.add(problem);
    }

    public void addParticipant(ContestParticipant participant) {
        for (ContestParticipant existing : participants) {
            if (existing.getUser().getUserId()
                    .equals(participant.getUser().getUserId())) {
                return;
            }
        }
        participants.add(participant);
    }

    public String getContestId() {
        return contestId;
    }

    public String getName() {
        return name;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public List<ContestParticipant> getParticipants() {
        return participants;
    }
}
