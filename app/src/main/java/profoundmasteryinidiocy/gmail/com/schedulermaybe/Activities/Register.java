package profoundmasteryinidiocy.gmail.com.schedulermaybe.Activities;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.Requests.RegisterRequest;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.R;

public class Register extends AppCompatActivity {

    protected
    @Override void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText emailInp = (EditText) findViewById(R.id.reg_email);
        final EditText usernameInp = (EditText) findViewById(R.id.reg_username);
        final EditText passInp = (EditText) findViewById(R.id.reg_password);
        final Button bRegister = (Button) findViewById(R.id.reg_btn);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = usernameInp.getText().toString();
                final String password = passInp.getText().toString();
                final String email = emailInp.getText().toString();


                //CREATES A NEW LISTENER
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //CREATES A JSON OBJECT FROM THE RESPONSE
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            Log.i("JsonObject", (jsonObject.toString()));
                            //REDIRECT TO LOGIN PAGE UPON SUCCESS

                            if(success){
                                Intent intent = new Intent(Register.this, MainActivity.class);
                                Register.this.startActivity(intent);
                            }else{
                            //CREATES A BUILDER DIALOG WHEN FAILED

                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                //MAKES CLASS REGISTER REQUEST THAT SENDS A REQUEST TO Register.php
                RegisterRequest registerRequest = new RegisterRequest(username, password, email, responseListener);

                //I don't know what this does but it doesn't work without it
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerRequest);

            }
        });

//        final TextView tReturn = (TextView) findViewById(R.id.returnBtn);
//
//        tReturn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent login =
//            }
//        });

    }


}
