package profoundmasteryinidiocy.gmail.com.schedulermaybe.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.Adapters.MyRecyclerAdapter;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.Model.Question;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.R;


public class ResultDetails extends AppCompatActivity {
    double correctDouble;
    double totalDouble;
    Integer totalNum;
    Integer correctNum; 
    private Bundle extras;
    private RecyclerView questionsDetail;
    private TextView overallScore;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_details);
        List<Question> questionsGiven = getIntent().getParcelableArrayListExtra("Questions");
        List<String> chosen = getIntent().getStringArrayListExtra("Selected Answers");
        Dictionary subcategoryCorrect = new Hashtable();
        Dictionary subcategoryTotal = new Hashtable();
        List<String> subcategories = new ArrayList<>();
        LinearLayout subCateLinearLayout = findViewById(R.id.scores_linearlayout);
        overallScore = findViewById(R.id.score_overall);
        extras = getIntent().getExtras();
        DecimalFormat f = new DecimalFormat("##.00");

        overallScore.setText(String.valueOf(f.format(extras.getDouble("correct")/questionsGiven.size()*100)) + "%");

        questionsDetail = findViewById(R.id.questionList);
        questionsDetail.setLayoutManager(new LinearLayoutManager(this));

        MyRecyclerAdapter adapter = new MyRecyclerAdapter(questionsGiven, chosen, this);
        questionsDetail.setAdapter(adapter);
        exitButton = findViewById(R.id.exitToHome);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(ResultDetails.this, home.class);
                startActivity(home);
            }
        });
        int count = 0;


        for(Question x:questionsGiven){

            boolean questionCorrect = false;

            if(x.getAnswer().equals((chosen.get(count)))){
                questionCorrect = true;
            }
            if(!((Hashtable) subcategoryCorrect).containsKey(x.getSubcategory())){
                subcategories.add(x.getSubcategory());
                if(questionCorrect)
                    subcategoryCorrect.put(x.getSubcategory(), 1);
                else
                    subcategoryCorrect.put(x.getSubcategory(), 0);
                subcategoryTotal.put(x.getSubcategory(), 1);
            }

            else{
                Integer previousCorrect = (Integer) subcategoryCorrect.get(x.getSubcategory());
                Integer previousTotal = (Integer) subcategoryTotal.get(x.getSubcategory());
                if(questionCorrect)
                    subcategoryCorrect.put(x.getSubcategory(), previousCorrect+1);
                subcategoryTotal.put(x.getSubcategory(),previousTotal+1);
            }
            count+=1;
        }
        TextView score1 = findViewById(R.id.score1);
        TextView score2 = findViewById(R.id.score2);
        correctNum = (Integer) subcategoryCorrect.get(subcategories.get(0));
        Log.d(subcategories.get(0), String.valueOf(subcategoryCorrect.get(subcategories.get(0))));

        totalNum = (Integer)subcategoryTotal.get(subcategories.get(0));
        Log.d(subcategories.get(0), String.valueOf(subcategoryTotal.get
                (subcategories.get(0))));

        correctDouble = correctNum.doubleValue();
        totalDouble = totalNum.doubleValue();
        String score1text = subcategories.get(0) + " " + f.format(correctDouble*100/totalDouble)+ "%";
        subcategories.remove(0);
        score1.setText(score1text);
        try {
            correctNum = (Integer) subcategoryCorrect.get(subcategories.get(0));

            totalNum = (Integer)subcategoryTotal.get(subcategories.get(0));
            correctDouble = correctNum.doubleValue();
            totalDouble = totalNum.doubleValue();
            String score2text = subcategories.get(0) + " " + f.format(correctDouble*100/totalDouble)+ "%";
            subcategories.remove(0);
            score2.setText(score2text);
        }
        catch(Exception e){
            score2.setText("N/A");
        }



        if(subcategories.size()>0){
            int numOfLayouts = (int)Math.ceil(subcategories.size()/2.0);

            for(int x = 0; x<numOfLayouts;x++){
                LayoutInflater l = getLayoutInflater();
                View v = l.inflate(R.layout.subcategorything, null);
                TextView inflatedScore1 = v.findViewById(R.id.score1);
                TextView inflatedScore2 = v.findViewById(R.id.score2);

                correctNum = (Integer) subcategoryCorrect.get(subcategories.get(0));
                Log.d(subcategories.get(0), String.valueOf(subcategoryCorrect.get(subcategories.get(0))));
                totalNum = (Integer)subcategoryTotal.get(subcategories.get(0));
                Log.d(subcategories.get(0), String.valueOf(subcategoryTotal.get(subcategories.get(0))));
                correctDouble = correctNum.doubleValue();
                totalDouble = totalNum.doubleValue();
                String inflatedScore1Text = subcategories.get(0) + " " + f.format(correctDouble*100/totalDouble)+ "%";
                inflatedScore1.setText(inflatedScore1Text);
                subcategories.remove(0);
                try{
                    correctNum = (Integer) subcategoryCorrect.get(subcategories.get(0));

                    totalNum = (Integer)subcategoryTotal.get(subcategories.get(0));
                    correctDouble = correctNum.doubleValue();
                    totalDouble = totalNum.doubleValue();
                    String inflatedScore2Text = subcategories.get(0) + " " + f.format(correctDouble*100/totalDouble)+ "%";
                    inflatedScore2.setText(inflatedScore2Text);
                    subcategories.remove(0);
                }catch (Exception e){
                    inflatedScore2.setText("N/A");
                }
                subCateLinearLayout.addView(v);
            }
        }
    }
}
