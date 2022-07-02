package com.example.livenewsapps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText passInput;
    private CheckBox ShowPass;
    //SharedPrefrence
    Intent intent;
    EditText textUsername, textPassword;
    Button masuk;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //SharedPreference
        textUsername = findViewById(R.id.username_login);
        textPassword = findViewById(R.id.pass_login);
        masuk = findViewById(R.id.btn_login);

        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        sharedPreferences.contains("username");
        sharedPreferences.contains("password");

        //Login Code
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = textUsername.getText().toString();
                String pw = textPassword.getText().toString();

                if (uname.isEmpty()) {
                    textUsername.setError("MustBeFilled");
                    textUsername.requestFocus();
                } else if (pw.isEmpty()) {
                    textPassword.setError("Must be Filled");
                    textPassword.requestFocus();
                } else {
                    Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", uname);
                    editor.putString("password", pw);
                    editor.apply();
                    intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
            }
//                if(uname.isEmpty() ){
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("username", uname);
//                    editor.putString("password", pw);
//                    editor.apply();
//                            intent = new Intent(Login.this, MainActivity.class);
//                            startActivity(intent);
//                }else {
//                    Toast.makeText(Login.this,"Data Not Valid",Toast.LENGTH_SHORT).show();
//                }
//
//            }
        });

        //CheckBoxCode
        passInput = findViewById(R.id.pass_login);
        ShowPass = findViewById(R.id.showpasslogin);
        ShowPass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(ShowPass.isChecked()){
                    passInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    passInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        //IntentCode
//        Button btn = (Button) findViewById(R.id.btn_login);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(Login.this, MainActivity.class);
//                startActivity(i);
//            }
//        });
    }
}