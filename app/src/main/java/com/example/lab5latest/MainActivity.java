package com.example.lab5latest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /** This holds the Text*/
    TextView pswd= null;
    /** this holds the password enteres*/
    EditText editText=null;
    /** this holds the button*/
    Button login=null;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pswd =findViewById(R.id.pswd);
        editText = findViewById(R.id.edittext);
        login = findViewById(R.id.login);

        login.setOnClickListener(clk -> {
            String password = editText.getText().toString();
            boolean isPasswordComplex = checkpassword(password);
            if (isPasswordComplex) {
                pswd.setText("Your password meets the requirements");
            } else {
                pswd.setText("You shall not pass!");
            }

        });


    }

    /**
     * This function check the complexity of the password
     *
     * @param pw the String object that we are checking
     * @return Return True if password fulfill all requirements
     */
    boolean checkpassword(String pw) {
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            }
            switch (c) {
                case '#':
                case '$':
                case '%':
                case '^':
                case '&':
                case '*':
                case '!':
                case '@':
                case '?':
                    foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(MainActivity.this, "Missing uppercase", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(MainActivity.this, "Missing Lowercase", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(MainActivity.this, "Missing Number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(MainActivity.this, "Missing Special character", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

}