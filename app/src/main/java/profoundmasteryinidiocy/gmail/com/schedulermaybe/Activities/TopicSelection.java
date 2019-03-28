package profoundmasteryinidiocy.gmail.com.schedulermaybe.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.Data.DatabaseHandler;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.Model.Question;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.R;

public class TopicSelection extends AppCompatActivity {

    private DatabaseHandler db;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private Spinner questionCount;
    private Spinner dropdown;
    private Button back;

    //BOTTOM NAVIGATION LISTENER
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(TopicSelection.this, home.class);
                    TopicSelection.this.startActivity(intent);
                    return true;
                case R.id.navigation_test:
                    Intent categorySelectionIntent = new Intent(TopicSelection.this, categorySelection.class);
                    TopicSelection.this.startActivity(categorySelectionIntent);
                    return true;
                case R.id.navigation_profile:
                    Toast.makeText(getApplicationContext(), "This feature isn't available yet!", Toast.LENGTH_SHORT).show();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_selection);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        dropdown = findViewById(R.id.topicSelect);
        db = new DatabaseHandler(this);
        back = findViewById(R.id.backhome);

        //BACK BUTTON CONFIG
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categorySelection = new Intent(TopicSelection.this, profoundmasteryinidiocy.gmail.com.schedulermaybe.Activities.categorySelection.class);
                startActivity(categorySelection);
            }
        });


        Bundle extras = getIntent().getExtras();
        String category = extras.getString("Category");
        List<String> topicList = db.getTopicListByCategory(category);
        Log.d("The category", topicList.toString());

        //SET UP SPINNER DROPDOWN ADAPTER
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, topicList){
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
        dropdown.setAdapter(adapter);
//        if(extras.getString("topic")!=null){
//            dropdown.setSelection(adapter.getPosition(extras.getString("topic")));
//        }


        //START QUIZ TRIGGER
        Button goButton = findViewById(R.id.popup_button);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createQuizStartPopup(dropdown.getSelectedItem().toString());
            }
        });
    }
    private void createQuizStartPopup(final String topic) {
        //GETS XML AND INFLATES IT
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.quiz_start_popup, null);
        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        Button startQuizButton = view.findViewById(R.id.start_button);
        Button exitButton  = view.findViewById(R.id.close_button);
         questionCount = view.findViewById(R.id.question_select);

         //DROPDOWN PARAMETERS
         List<Integer> numChoices = new Integer[]{5, 10, 15, 20};
        //SET UP DROPDOWN ADAPTER
        ArrayAdapter<Integer> questionsNumSelect = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, numChoices){
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

        //START THE QUIZ
        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quizIntent = new Intent(TopicSelection.this, QuizActivity.class);
                quizIntent.putExtra("topic", topic);
                quizIntent.putExtra("Number", questionCount.getSelectedItem().toString());
                startActivity(quizIntent);
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        questionCount.setAdapter(questionsNumSelect);



    }


}
