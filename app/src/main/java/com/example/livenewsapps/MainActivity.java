package com.example.livenewsapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SharedPrefrences
        TextView result = findViewById(R.id.detailusername);
        sharedPreferences = getSharedPreferences("user_details",MODE_PRIVATE);
        result.setText(sharedPreferences.getString("username",null));

        //Waktu
        TextView textView = findViewById(R.id.timetext);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm ");
        String currentDateandTime = dateFormat.format(new Date());
        textView.setText(currentDateandTime);

        //Intent LinierLayout Upload Berita
        LinearLayout uploadberita = (LinearLayout) findViewById(R.id.uploadberita);
        uploadberita.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent upload = new Intent(MainActivity.this,Upload.class);
                startActivity(upload);
            }
        });

        //Intent LinierLayout List NeWS
        LinearLayout listnews = (LinearLayout) findViewById(R.id.listnews);
        listnews.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent list = new Intent(MainActivity.this, listnews.class);
                startActivity(list);
            }
        });

        //Intent LinierLayout Trusted News
        LinearLayout beritaterpercaya = (LinearLayout) findViewById(R.id.trustednews);
        beritaterpercaya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent trusted = new Intent(MainActivity.this, trustednews.class);
                startActivity(trusted);
            }
        });

        //Intent Profil
        LinearLayout profileinfo =(LinearLayout) findViewById(R.id.profileintent);
        profileinfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent profile = new Intent (MainActivity.this , profile.class);
                startActivity(profile);
            }
        });

        //Intent FAB Icon
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Upload.class);
                startActivity(i);
            }
        });
    }
}