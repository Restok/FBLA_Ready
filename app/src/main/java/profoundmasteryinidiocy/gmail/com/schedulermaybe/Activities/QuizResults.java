package profoundmasteryinidiocy.gmail.com.schedulermaybe.Activities;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.R;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.Model.Question;

public class QuizResults extends AppCompatActivity {

    private Bundle quizInfo;
    private TextView score;
    private Button detailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        quizInfo = getIntent().getExtras();
        detailsButton = findViewById(R.id.details_button);
        List<Question> questionsGiven;
        questionsGiven = getIntent().getParcelableArrayListExtra("Questions");
        final ArrayList<String> chosenAnswers = quizInfo.getStringArrayList("Selected Answers");


        Log.d("Chosen answers", chosenAnswers.toString());
        int correct = 0;
        for(int x = 0; x<questionsGiven.size(); x++){
            if(questionsGiven.get(x).getAnswer().equals(chosenAnswers.get(x))){
                correct+=1;
            }
        }
        score = findViewById(R.id.score);
        score.setText(correct + "/" + questionsGiven.size());

        final List<Question> finalQuestionsGiven = new ArrayList<>(questionsGiven);
        final double finalCorrect = correct;
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent details = new Intent(QuizResults.this, ResultDetails.class);
                details.putParcelableArrayListExtra("Questions", (ArrayList<? extends Parcelable>) finalQuestionsGiven);
                details.putStringArrayListExtra("Selected Answers", chosenAnswers);
                details.putExtra("correct", finalCorrect);
                startActivity(details);

            }
        });


    }
    @Override
    public void onBackPressed(){}
}
