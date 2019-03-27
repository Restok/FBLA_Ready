package profoundmasteryinidiocy.gmail.com.schedulermaybe.Model;

import java.util.ArrayList;

public class Quiz {

    private int numOfQuestions;
    private String topic;
    private ArrayList<Question> questions;
    private int correctNum;
    private int incorrectNum;

    public Quiz(int numOfQuestions, String topic, ArrayList<Question> questions) {
        this.numOfQuestions = numOfQuestions;
        this.topic = topic;
        this.questions = questions;
    }

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public void setNumOfQuestions(int numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public int getCorrectNum() {
        return correctNum;
    }

    public void setCorrectNum(int correctNum) {
        this.correctNum = correctNum;
    }

    public int getIncorrectNum() {
        return incorrectNum;
    }

    public void setIncorrectNum(int incorrectNum) {
        this.incorrectNum = incorrectNum;
    }
}
