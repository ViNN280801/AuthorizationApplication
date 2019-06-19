package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mEnterButtonMainActivity, mCancelButtonMainActivity;

    EditText mEditTextUsername = findViewById(R.id.edittext_activity_main_username_field);
    EditText mEditTextPassword = findViewById(R.id.edittext_activity_main_password_field);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEnterButtonMainActivity = findViewById(R.id.button_activity_main_login);
        mEditTextPassword = findViewById(R.id.edittext_activity_main_password_field);

        mCancelButtonMainActivity = findViewById(R.id.button_activity_main_cancel);

        mEnterButtonMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditTextUsername.getText().toString().equals("admin") &&
                        mEditTextPassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mCancelButtonMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void login(View view) {
        if (mEditTextUsername.getText().toString().equals("admin") && mEditTextPassword.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "You are authorized successfully!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Login or password is wrong!", Toast.LENGTH_SHORT).show();
        }
    }
}