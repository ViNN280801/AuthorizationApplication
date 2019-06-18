package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button enterButtonMainActivity, cancelButtonMainActivity;
    EditText editTextNameFieldMainActivity, editTextPasswordFieldMainActivity;

    EditText username = (EditText)findViewById(R.id.editTextNameFieldMainActivity);
    EditText password = (EditText)findViewById(R.id.editTextPasswordFieldMainActivity);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterButtonMainActivity = (Button)findViewById(R.id.button);
        editTextNameFieldMainActivity = (EditText)findViewById(R.id.editTextNameFieldMainActivity);
        editTextPasswordFieldMainActivity = (EditText)findViewById(R.id.editTextPasswordFieldMainActivity);

        cancelButtonMainActivity = (Button)findViewById(R.id.button2);

        enterButtonMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextNameFieldMainActivity.getText().toString().equals("admin") &&
                        editTextPasswordFieldMainActivity.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelButtonMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void login(View view) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "You are authorized successfully!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Login or password is wrong!", Toast.LENGTH_SHORT).show();
        }
    }
}