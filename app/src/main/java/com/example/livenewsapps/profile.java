package com.example.livenewsapps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class profile extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    private TextView passInput2;
    private CheckBox ShowPass2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //SharedPrefrencesPertama
        TextView result = findViewById(R.id.detailusername2);
        sharedPreferences = getSharedPreferences("user_details",MODE_PRIVATE);
        result.setText(sharedPreferences.getString("username",null));

        //SharedPrefrencesKedua
        TextView kedua = findViewById(R.id.fullname);
        sharedPreferences = getSharedPreferences("user_details",MODE_PRIVATE);
        kedua.setText(sharedPreferences.getString("username",null));

        //SharedPrefrences Password
        TextView password = findViewById(R.id.pass_profile);
        sharedPreferences = getSharedPreferences("user_details",MODE_PRIVATE);
        password.setText(sharedPreferences.getString("password",null));

        //sharedPrefrenced Mail
        TextView emaildetail = findViewById(R.id.emaildetail);
        sharedPreferences = getSharedPreferences("user_details2",MODE_PRIVATE);
        emaildetail.setText(sharedPreferences.getString("email",null));

        //sharedPrefrenced Mail
        TextView emaildetail2 = findViewById(R.id.emaildetail2);
        sharedPreferences = getSharedPreferences("user_details2",MODE_PRIVATE);
        emaildetail2.setText(sharedPreferences.getString("email",null));

        //CheckBox Password
        passInput2 = findViewById(R.id.pass_profile);
        ShowPass2 = findViewById(R.id.checkpass);
        ShowPass2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(ShowPass2.isChecked()){
                    passInput2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    passInput2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        //Intent BackHome
        RelativeLayout backhome = (RelativeLayout) findViewById(R.id.backbutton);
        backhome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent a = new Intent (profile.this, MainActivity.class);
                startActivity(a);
            }




        });
    }
}