package profoundmasteryinidiocy.gmail.com.schedulermaybe.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Question implements Parcelable {

    private int id;
    private String topic;
    private String question;
    private String choice;
    private String choice2;
    private String choice3;
    private String answer;
    private String category;
    private String subcategory;

    public Question(int id, String topic, String question, String choice, String choice2, String choice3, String answer, String category, String subcategory) {
        this.id = id;
        this.topic = topic;
        this.question = question;
        this.choice = choice;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.answer = answer;
        this.category = category;
        this.subcategory = subcategory;
    }

    public Question(String topic, String question, String choice, String choice2, String choice3, String answer, String category, String subcategory) {
        this.topic = topic;
        this.question = question;
        this.choice = choice;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.answer = answer;
        this.category = category;
        this.subcategory = subcategory;
    }

    public Question() {
    }

    protected Question(Parcel in) {
        id = in.readInt();
        topic = in.readString();
        question = in.readString();
        choice = in.readString();
        choice2 = in.readString();
        choice3 = in.readString();
        answer = in.readString();
        category = in.readString();
        subcategory = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", question='" + question + '\'' +
                ", choice='" + choice + '\'' +
                ", choice2='" + choice2 + '\'' +
                ", choice3='" + choice3 + '\'' +
                ", answer='" + answer + '\'' +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(topic);
        dest.writeString(question);
        dest.writeString(choice);
        dest.writeString(choice2);
        dest.writeString(choice3);
        dest.writeString(answer);
        dest.writeString(category);
        dest.writeString(subcategory);
    }
}
