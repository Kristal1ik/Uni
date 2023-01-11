package com.example.fuzzy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_dop);

        String name = getIntent().getStringExtra("NAME");
        String pr = getIntent().getStringExtra("PROGRAM");
        int image = getIntent().getIntExtra("IMAGE", 0);
        String desc = getIntent().getStringExtra("DESCRIPTION");
        int gal1 = getIntent().getIntExtra("GAL1", 0);
        int gal2 = getIntent().getIntExtra("GAL2", 0);
        int gal3 = getIntent().getIntExtra("GAL3", 0);


        TextView name_TextView = findViewById(R.id.textView5);
        ImageView imageView6 = findViewById(R.id.imageView6);
        TextView description = findViewById(R.id.desc);
        ImageView image_gal1 = findViewById(R.id.gal1);
        ImageView image_gal2 = findViewById(R.id.gal2);
        ImageView image_gal3 = findViewById(R.id.gal3);


        name_TextView.setText(name);
        imageView6.setImageResource(image);
        description.setText(desc);
        image_gal1.setImageResource(gal1);
        image_gal2.setImageResource(gal2);
        image_gal3.setImageResource(gal3);

    }
}
