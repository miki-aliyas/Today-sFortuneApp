package com.example.todaysfortuneapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class TopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void clicked(View v) {
        Button button = findViewById(R.id.button01);
        TextView resulttext = findViewById(R.id.resultText);
        ImageView resultImage = findViewById(R.id.resultImage);
        FrameLayout frameLayout = findViewById(R.id.main);

        String[] drawFortune = {"大吉","吉","中吉","小吉","末吉","凶","大凶"};
        Random rand = new Random();
        int randomIndex = rand.nextInt(drawFortune.length);
        String randomElement = drawFortune[randomIndex];
        button.setText(randomElement);
        resulttext.setText("今日の運勢は…");

        String fileName;
        switch (randomElement) {
            case "大吉":
                fileName = "daikichi";
                break;
            case "吉":
                fileName = "kichi";
                break;
            case "中吉":
                fileName = "chukichi";
                break;
            case "小吉":
                fileName = "shokichi";
                break;
            case "末吉":
                fileName = "suekichi";
                break;
            case "凶":
                fileName = "kyo";
                break;
            case "大凶":
                fileName = "daikyo";
                break;
            default:
                fileName = "unknown";
                break;
        }
        String imageName = fileName;
        int imageResId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        resultImage.setImageResource(imageResId);

        String result_bg = "result_bg";
        int result_bgId = getResources().getIdentifier(result_bg, "drawable", getPackageName());
        frameLayout.setBackgroundResource(result_bgId);
    }
}