package com.example.livenewsapps;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private EditText passInput;
    private CheckBox ShowPass;
    private EditText username;
    private EditText email;
    Button sign;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = findViewById(R.id.username_login);
        email = findViewById(R.id.email);
        passInput = findViewById(R.id.pass_signup);
        ShowPass = findViewById(R.id.showpasssignup);

//        SharedPreferences
        sharedPreferences = getSharedPreferences("user_details2", MODE_PRIVATE);
        sharedPreferences.contains("username");
        sharedPreferences.contains("email");
        sharedPreferences.contains("password");

        //CheckBoxCode
        ShowPass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(ShowPass.isChecked()){
                    passInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    passInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        //EditTextCode
        sign = findViewById(R.id.btn_signup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String usernamesign = username.getText().toString();
//                String passsign = passInput.getText().toString();
                String mailsign = email.getText().toString();

                if(mailsign.isEmpty()){
                    email.setError("DI ISI !! ");
                    email.requestFocus();
                }else {
                    Toast.makeText(SignUp.this, "Sign Up Success", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("username", usernamesign);
//                    editor.putString("password", passsign);
                    editor.putString("email", mailsign);
                    editor.apply();
                    Intent i = new Intent(SignUp.this, Login.class);
                    startActivity(i);
                }}
        });
    }
}