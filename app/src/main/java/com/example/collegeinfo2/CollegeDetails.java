package com.example.collegeinfo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class CollegeDetails extends AppCompatActivity {

    ImageView img;
    TextView tv1,tv2;
    WebView website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_details);

        img=findViewById(R.id.image1);
        tv1=findViewById(R.id.textViewTitle);
        tv2=findViewById(R.id.textViewDescription);
        website=findViewById(R.id.web40);


       img.setImageResource(getIntent().getIntExtra("image",0));
       tv1.setText(getIntent().getStringExtra("Title"));
       tv2.setText(getIntent().getStringExtra("desc"));
       website.loadUrl(getIntent().getStringExtra("website"));



    }
}