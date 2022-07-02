package com.example.livenewsapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Upload extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Button delete;
    EditText judul;
    EditText caption;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        TextView result2 = findViewById(R.id.detailusername);
        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        result2.setText(sharedPreferences.getString("username", null));

        TextView textView = findViewById(R.id.timetext);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm ");
        String currentDateandTime = dateFormat.format(new Date());
        textView.setText(currentDateandTime);

        //Delete Button
        delete = findViewById(R.id.btn_detele);
        judul = findViewById(R.id.edit_judul);
        caption = findViewById(R.id.edit_caption);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                judul.setText("");
                caption.getText().clear();
                Toast.makeText(Upload.this, "Clear Success", Toast.LENGTH_SHORT).show();
            }
        });

    }
}