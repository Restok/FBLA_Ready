package profoundmasteryinidiocy.gmail.com.schedulermaybe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.Data.DatabaseHandler;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.Model.Question;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.R;

public class home extends AppCompatActivity {

    private DatabaseHandler db;
    private List<String> allTopics;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_test:
                    Intent categorySelectionIntent = new Intent(home.this, categorySelection.class);
                    home.this.startActivity(categorySelectionIntent);
                    return true;
                case R.id.navigation_profile:
                    return true;
            }
            return false;
        }
    };
    private TextView topic1;
    private TextView topic2;
    private TextView topic3;
    private TextView topic4;
    private CardView tcard1;
    private CardView tcard2;
    private CardView tcard3;
    private CardView tcard4;

    private List<String> selectedTopics = new ArrayList<>();
    private List<String> categories = new ArrayList<>();
    private boolean inFBLA;
    private boolean inBSkills;
    private boolean inCEvents;
    private String selectedTopic;
    private TextView[] topicTexts;
    private CardView[] clickCards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        db = new DatabaseHandler(this);
        allTopics = db.getTopicList();
        topic1 = findViewById(R.id.topic1);
        topic2 = findViewById(R.id.topic2);
        topic3 = findViewById(R.id.topic3);
        topic4 = findViewById(R.id.topic4);
        tcard1 = findViewById(R.id.topic1_card);
        tcard2 = findViewById(R.id.topic2_card);
        tcard3 = findViewById(R.id.topic3_card);
        tcard4 = findViewById(R.id.topic4_card);
         topicTexts = new TextView[]{topic1, topic2, topic3, topic4};
         clickCards = new CardView[]{tcard1, tcard2, tcard3, tcard4};
        final List<String> cateF = db.getTopicListByCategory("fbla_essentials");
        final List<String> cateB = db.getTopicListByCategory("business_skills");
        final List<String> cateC = db.getTopicListByCategory("competitive_events");
        Log.d("HOWMANY", String.valueOf(allTopics.size()));
        for(int x = 0; x<topicTexts.length;x++){
            int index = (int) Math.floor(Math.random()*allTopics.size());
            Log.d("the num", String.valueOf(index));
            try{
                selectedTopic = allTopics.get(index);
                topicTexts[x].setText(selectedTopic);

                 inFBLA = cateF.contains(selectedTopic);
                inBSkills = cateB.contains(selectedTopic);
               inCEvents = cateC.contains(selectedTopic);
                allTopics.remove(allTopics.get(index));
                clickCards[x].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent topicSelection = new Intent(home.this, TopicSelection.class);
                        topicSelection.putExtra("topic", selectedTopic);
                        if(inFBLA){
                            topicSelection.putExtra("Category", "fbla_essentials");
                        }
                        else if(inBSkills){
                            topicSelection.putExtra("Category", "business_skills");
                        }
                        else if(inCEvents){
                            topicSelection.putExtra("Category", "competitive_events");
                        }
                        startActivity(topicSelection);
                    }
                });
            }catch(Exception e){
                Log.d("YOANERROR", e.toString());
                break;

            }
        }

        TextView points = findViewById(R.id.pointvalue);
//        Intent intent = getIntent();
//        int pointsval = intent.getIntExtra("points", 0);
//        points.setText(String.valueOf(pointsval));

        CardView testButton = findViewById(R.id.test);


        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categorySelectionIntent = new Intent(home.this, categorySelection.class);
                home.this.startActivity(categorySelectionIntent);
            }
        });
    }

}
