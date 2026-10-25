package model;

public class LeaderboardEntry {

    private User user;
    private double score;
    private int rank;

    public LeaderboardEntry(User user, double score, int rank) {
        this.user = user;
        this.score = score;
        this.rank = rank;
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
