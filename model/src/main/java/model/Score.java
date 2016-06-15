package model;

/**
 * Created by Dorian on 15/06/2016.
 */
public class Score extends Entity {

    private int score_id;
    private int LastScore;
    private int Score;


    public int getScore_id() {
        return score_id;
    }

    public void setScore_id(int score_id) {
        this.score_id = score_id;
    }


    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }


    public int getLastScore() {
        return LastScore;
    }

    public void setLastScore(int lastScore) {
        LastScore = lastScore;
    }
}
