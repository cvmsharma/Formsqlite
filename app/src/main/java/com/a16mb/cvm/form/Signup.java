package com.a16mb.cvm.form;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText et1, et2, et3, et4;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        et1 = (EditText) findViewById(R.id.etname);
        et2 = (EditText) findViewById(R.id.etemail);
        et3 = (EditText) findViewById(R.id.etphone);
        et4 = (EditText) findViewById(R.id.etpassword);
        btn = (Button) findViewById(R.id.btnsignup);
        tv = (TextView) findViewById(R.id.tvalready);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1 = new Intent(Signup.this, Login.class);
                startActivity(in1);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et1.getText().toString();
                String phone = et2.getText().toString();
                String email = et3.getText().toString();
                String password = et4.getText().toString();

                if (name.equalsIgnoreCase("") || phone.equalsIgnoreCase("") || email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                    if (name.equalsIgnoreCase("")) {
                        et1.setError("Please enter your name.");
                    }
                    if (phone.equalsIgnoreCase("")) {
                        et2.setError("Please enter your email id.");

                    }
                    if (email.equalsIgnoreCase("")) {
                        et3.setError("Please enter your Mobile No.");

                    }
                    if (password.equalsIgnoreCase("")) {
                        et4.setError("Please enter your Password.");

                    }

                } else {
                    DbHelper db = new DbHelper(getApplicationContext());
                    db.insertRecord(name, email, phone, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}

