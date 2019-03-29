package profoundmasteryinidiocy.gmail.com.schedulermaybe.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.Data.DatabaseHandler;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.Model.Question;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.R;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.Requests.LoginRequest;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.Requests.writeBugRequest;

public class home extends AppCompatActivity {

    private DatabaseHandler db;
    private List<String> allTopics;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private Spinner bugType;
    private Spinner dropdown;
    private Button back;
    //BOTTOM NAV LISTENER
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
                    Toast.makeText(getApplicationContext(), "This feature isn't available yet!", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };


    //XML LAYOUT INITS
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
    private Button reportBug;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //INIT XML STUFF

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

         //GET TOPICS OF EACH CATEGORY
        final List<String> cateF = db.getTopicListByCategory("fbla_essentials");
        final List<String> cateB = db.getTopicListByCategory("business_skills");
        final List<String> cateC = db.getTopicListByCategory("competitive_events");

        //SETS UP THE EXPLORE TOPICS
        for(int x = 0; x<topicTexts.length;x++){
            int index = (int) Math.floor(Math.random()*allTopics.size());
            Log.d("the num", String.valueOf(index));
            try{
                selectedTopic = allTopics.get(index);
                topicTexts[x].setText(selectedTopic);

                //FINDS OUT WHICH CATEGORY ITS IN
                inFBLA = cateF.contains(selectedTopic);
                inBSkills = cateB.contains(selectedTopic);
                inCEvents = cateC.contains(selectedTopic);
                allTopics.remove(allTopics.get(index));

                //OPENS THE TOPIC SELECTION PAGE WITH THE GIVEN CATEGORY AND TOPIC
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


        //HOME NAVIGATION
        CardView testButton = findViewById(R.id.test);
        CardView createButton = findViewById(R.id.create);
        CardView profileButton = findViewById(R.id.viewStats);

        //GO TO TEST ACTIVITY
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categorySelectionIntent = new Intent(home.this, categorySelection.class);
                home.this.startActivity(categorySelectionIntent);
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This feature isn't available yet!", Toast.LENGTH_SHORT).show();

            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This feature isn't available yet!", Toast.LENGTH_SHORT).show();

            }
        });

        //BUG REPORT BUTTON
        reportBug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBugReport();
            }
        });

    }
    private void createBugReport() {
        //GETS XML AND INFLATES IT
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.bugreport, null);
        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        Button sendButton = view.findViewById(R.id.sendBugButton);
        Button exitButton  = view.findViewById(R.id.cancel_bug);
        final EditText et = view.findViewById(R.id.bug_details);
        bugType = view.findViewById(R.id.bug_type_select);

        //DROPDOWN PARAMETERS
        String[] bugTypes = new String[]{"Malfunctioning components", "Question Error", "App crashes", "Other"};


        //SET UP DROPDOWN ADAPTER
        final ArrayAdapter<String> bugtypeselect = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, bugTypes){

            Typeface font = ResourcesCompat.getFont(getContext(), R.font.open_sans_bold);

            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                view.setTypeface(font);
//        view.setTextSize();
                return view;
            }

            // Affects opened state of the spinner
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getDropDownView(position, convertView, parent);
                view.setTypeface(font);
                return view;
            }

        };
        bugType.setAdapter(bugtypeselect);

        //WRITES THE BUG REPORT TO REMOTE SERVER
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String category = bugType.getSelectedItem().toString();
                String details = et.getText().toString();

                writeBugRequest br = new writeBugRequest(category, details, null);

                //Starts the request
                RequestQueue queue = Volley.newRequestQueue(home.this);
                queue.add(br);
                };

            });


        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });




    }

}
