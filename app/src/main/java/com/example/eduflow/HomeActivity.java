package com.example.eduflow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView tvWelcome = findViewById(R.id.tvWelcome);
        Button btnLogout = findViewById(R.id.btnLogout);

        SharedPreferences prefs =
                getSharedPreferences("EduFlowPrefs", MODE_PRIVATE);

        String name = prefs.getString("name", "Student");
        tvWelcome.setText("Welcome, " + name + "!");

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(
                    HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}


