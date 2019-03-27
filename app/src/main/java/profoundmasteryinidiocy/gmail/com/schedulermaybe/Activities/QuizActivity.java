package profoundmasteryinidiocy.gmail.com.schedulermaybe.Activities;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.Data.DatabaseHandler;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.R;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.Model.*;

public class QuizActivity extends AppCompatActivity implements Serializable {
    private TextView questionTextView;
    private TextView choiceOne;
    private TextView choiceTwo;
    private TextView choiceThree;
    private TextView choiceFour;
    private CardView choiceOneBox;
    private CardView choiceTwoBox;
    private CardView choiceThreeBox;
    private CardView choiceFourBox;
    private CardView[] choices;
    private TextView[] choicesSelection;
    private TextView questionCount;
    private DatabaseHandler db;
    private List<Question> allQuestionsBank;
    private List<String> chosen;
    private List<Question> questionsGiven;
    private Bundle quizInfo;
    private String topic;
    private int questionTotal;
    private TextView topicTV;
    private Chronometer chronometer;
    private boolean canClickAgain = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        chronometer = findViewById(R.id.timer);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        questionTextView = findViewById(R.id.question_text);
        choiceOne = findViewById(R.id.choice1);
        choiceTwo = findViewById(R.id.choice2);
        choiceThree=findViewById(R.id.choice3);
        choiceFour = findViewById(R.id.choice4);
        choiceOneBox = findViewById(R.id.choices_box1);
        choiceTwoBox = findViewById(R.id.choices_box2);
        choiceThreeBox = findViewById(R.id.choices_box3);
        choiceFourBox = findViewById(R.id.choices_box4);
        topicTV = findViewById(R.id.topic);
        choices = new CardView[]{choiceOneBox, choiceTwoBox, choiceThreeBox, choiceFourBox};
        choicesSelection = new TextView[]{choiceOne, choiceTwo, choiceThree, choiceFour};
        questionCount = findViewById(R.id.question_count);
        quizInfo  = getIntent().getExtras();
        topic = quizInfo.getString("topic");
        topicTV.setText(topic);
        questionTotal = Integer.parseInt(quizInfo.getString("Number"));
        db = new DatabaseHandler(this);
        chosen = new ArrayList<>();
        questionsGiven = new ArrayList<>();
        allQuestionsBank = db.getQuestionsByTopic(topic);
        if(allQuestionsBank.size()<questionTotal){
            questionTotal = allQuestionsBank.size();
        }

        imScaredOfRecursiveFunctionsButImGonnaTryThis(allQuestionsBank, questionTotal);

    }

    public void imScaredOfRecursiveFunctionsButImGonnaTryThis(List<Question> questions, final int count) {
        if (count == 1) {

            final Question question = getRandomQuestion(questions);
            questions.remove(question);
            questionTextView.setText(question.getQuestion());
            List<Integer> questionOrder = new ArrayList<>();
            for(int i = 1; i<=4;i++){
                questionOrder.add(i);
            }
            Collections.shuffle(questionOrder);

            String qc = questionTotal - (count-1) + "/" + questionTotal;
            questionCount.setText(qc);
            for (int c = 0; c < 4; c++) {
                switch(questionOrder.get(c)){
                    case 1:
                        choicesSelection[c].setText(question.getChoice());
                        break;
                    case 2:
                        choicesSelection[c].setText(question.getChoice2());
                        break;
                    case 3:
                        choicesSelection[c].setText(question.getChoice3());
                        break;
                    case 4:
                        choicesSelection[c].setText(question.getAnswer());
                        break;
                }
                final int finalC = c;

                choices[c].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(canClickAgain) {
                            chosen.add(choicesSelection[finalC].getText().toString());
                            questionsGiven.add(question);

                            Intent resultsIntent = new Intent(QuizActivity.this, QuizResults.class);
                            resultsIntent.putStringArrayListExtra("Selected Answers", (ArrayList<String>) chosen);
                            resultsIntent.putParcelableArrayListExtra("Questions", (ArrayList<? extends Parcelable>) questionsGiven);
                            startActivity(resultsIntent);
                            canClickAgain = false;
                        }
                    }
                });
            }

        } else {

            final Question question = getRandomQuestion(questions);
            questions.remove(question);
            questionTextView.setText(question.getQuestion());
            final List<Question> newQuestions = new ArrayList<>(questions);
            List<Integer> questionOrder = new ArrayList<>();
            for(int i = 1; i<=4;i++){
                questionOrder.add(i);
            }
            Collections.shuffle(questionOrder);

            String qc = questionTotal - (count-1) + "/" + questionTotal;
            questionCount.setText(qc);
            for (int c = 0; c < 4; c++) {
                switch(questionOrder.get(c)){
                    case 1:
                        choicesSelection[c].setText(question.getChoice());
                        break;
                    case 2:
                        choicesSelection[c].setText(question.getChoice2());
                        break;
                    case 3:
                        choicesSelection[c].setText(question.getChoice3());
                        break;
                    case 4:
                        choicesSelection[c].setText(question.getAnswer());
                        break;
                }


                final int finalC = c;

                choices[c].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        questionsGiven.add(question);
                        chosen.add(choicesSelection[finalC].getText().toString());
                        imScaredOfRecursiveFunctionsButImGonnaTryThis(newQuestions, count-1);
                    }
                });
            }

        }

    }

    public Question getRandomQuestion(List<Question> questions){
        Random rand = new Random();
        int randomIndex = rand.nextInt(questions.size());
        Question randomQuestion = questions.get(randomIndex);
        return randomQuestion;
    }
    @Override
    public void onBackPressed(){}

}
