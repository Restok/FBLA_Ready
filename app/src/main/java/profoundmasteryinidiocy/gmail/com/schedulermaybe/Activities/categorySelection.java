package profoundmasteryinidiocy.gmail.com.schedulermaybe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Selection;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.R;

public class categorySelection extends AppCompatActivity {

    private TextView mTextMessage;
    private CardView fblaCard;
    private CardView businessCard;
    private CardView eventsCard;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(categorySelection.this, home.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_test:
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
        setContentView(R.layout.activity_test);

        fblaCard = findViewById(R.id.fbla_card);
        businessCard = findViewById(R.id.business_card);
        eventsCard = findViewById(R.id.events_card);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //JUST A CLICK LISTENER FOR EACH CATEGORY DIRECTING TO THEIR TOPIC SELECTION PAGE
        fblaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topicSelectIntent = new Intent(categorySelection.this, TopicSelection.class);
                topicSelectIntent.putExtra("Category", "fbla_essentials");
                categorySelection.this.startActivity(topicSelectIntent);
            }
        });
        businessCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topicSelectIntent = new Intent(categorySelection.this, TopicSelection.class);
                topicSelectIntent.putExtra("Category", "business_skills");

                categorySelection.this.startActivity(topicSelectIntent);
            }
        });
        eventsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topicSelectIntent = new Intent(categorySelection.this, TopicSelection.class);
                topicSelectIntent.putExtra("Category", "competitive_events");

                categorySelection.this.startActivity(topicSelectIntent);
            }
        });
        //--------------------------------------------------------------------------------
    }
}



//    @Override
//    public void onClick(View v) {
//
//        switch(v.getId()){
//            case R.id.fbla_card:
//                Intent topicSelectIntent = new Intent(categorySelection.this, TopicSelection.class);
//                categorySelection.this.startActivity(topicSelectIntent);
//                topicSelectIntent.putExtra("Category", "fbla_essentials");
//                break;
//            case R.id.business_card:
//                Intent topicSelectIntent2 = new Intent(categorySelection.this, TopicSelection.class);
//
//                topicSelectIntent2.putExtra("Category", "business_skills");
//                categorySelection.this.startActivity(topicSelectIntent2);
//                break;
//            case R.id.events_card:
//                Intent topicSelectIntent3 = new Intent(categorySelection.this, TopicSelection.class);
//                topicSelectIntent3.putExtra("Category", "competitive_events");
//                categorySelection.this.startActivity(topicSelectIntent3);
//                break;
//
//
//        }
//    }
//}
