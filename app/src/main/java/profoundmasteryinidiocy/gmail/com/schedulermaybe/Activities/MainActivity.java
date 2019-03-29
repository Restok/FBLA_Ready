package profoundmasteryinidiocy.gmail.com.schedulermaybe.Activities;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.Data.DatabaseHandler;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.Model.Question;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.Requests.LoginRequest;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.R;
//import android.content.Context;

public class MainActivity extends AppCompatActivity {
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Layout Elements
        final EditText username = findViewById(R.id.log_usrname);
        final EditText pass = findViewById(R.id.log_pass);
        final Button bLogin = findViewById(R.id.login);
        final Button register = findViewById(R.id.register);
//        final ConstraintLayout mainActivity = findViewById(R.id.login_main);
//        mainActivity.setBackground(getDrawable(R.drawable.appbackground));
        //Change to register activity when register button is clicked

        db = new DatabaseHandler(this);
        Log.d("questions", db.getAllQuestions().toString());


        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(MainActivity.this, Register.class);
                MainActivity.this.startActivity(registerIntent);

            }
        });

        //Init login process if login is clicked
        bLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //Get response variable from PHP file
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            int points = jsonResponse.getInt("points");
                            //change to home if succeeded
                            if(success){
                                Intent intent = new Intent(MainActivity.this, home.class);
                                intent.putExtra("points", points);
                                MainActivity.this.startActivity(intent);
                            }else{

                            //alert failed if not
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();}
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                String usernameString = username.getText().toString();
                String passwordString = pass.getText().toString();

                LoginRequest loginRequest = new LoginRequest(usernameString, passwordString, responseListener);

                //Starts the request
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);

            }
        });

    }

}
