package com.example.findus.findme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    Button mButtomSignUp;
    TextView msignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mButtomSignUp = (Button) findViewById(R.id.email_sign_up_button);
        msignIn = (TextView) findViewById(R.id.signup_login);

        mButtomSignUp.setOnClickListener(this);
        msignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mButtomSignUp){
            createAccount();
        }
        if (v == msignIn){
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private void createAccount() {

    }
}
