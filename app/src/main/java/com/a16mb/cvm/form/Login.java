package com.a16mb.cvm.form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    EditText et1,et2;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1=(EditText)findViewById(R.id.etemail1);
        et2=(EditText)findViewById(R.id.etpassword1);
        btn=(Button)findViewById(R.id.btnlogin);
        tv=(TextView)findViewById(R.id.tvnew);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Login.this, Signup.class);
                startActivity(in);
            }
        });

    }
}
