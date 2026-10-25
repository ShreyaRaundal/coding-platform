
package model;

public class ContestParticipant {

    private String participantId;
    private User user;
    private double score;
    private int rank;

    public ContestParticipant(String participantId, User user) {
        this.participantId = participantId;
        this.user = user;
        this.score = 0;
        this.rank = 0;
    }

    public String getParticipantId() {
        return participantId;
    }

    public User getUser() {
        return user;
    }

    public double getScore() {
        return score;
    }

    public int getRank() {
        return rank;
    }

    public void updateScore(double score) {
        this.score = score;
    }

    public void updateRank(int rank) {
        this.rank = rank;
    }
}
