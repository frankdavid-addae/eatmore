package com.example.eatmore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout clWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Eatmore);
        setContentView(R.layout.activity_main);

        clWelcome = findViewById(R.id.clWelcome);

        clWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clWelcome.setVisibility(View.GONE);
            }
        });
    }
}