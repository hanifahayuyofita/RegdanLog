package com.example.regdanlog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText etRegEmail, etRegPassword;
    Button btnRegRegister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        etRegEmail = findViewById(R.id.etEmail);
        etRegPassword = findViewById(R.id.etPassword);
        btnRegRegister = findViewById(R.id.btnLogin);
        db = new DatabaseHelper(this);

        btnRegRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etRegEmail.getText().toString();
                String password = etRegPassword.getText().toString();
                Boolean checkEmail = db.checkEmail(email);
                if (checkEmail == false){
                    Boolean insert = db.insert(email, password);
                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Email Already Exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}