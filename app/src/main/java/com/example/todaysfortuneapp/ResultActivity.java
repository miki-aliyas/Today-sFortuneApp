package com.example.todaysfortuneapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    public static final String KEY_RESULT_ID = "com.example.todaysfortuneapp.key_result_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int resultId = getIntent().getIntExtra(KEY_RESULT_ID, -1);
        OmikujiItem item = OmikujiItem.values()[resultId];
        // 画像をセットする
        ImageView resultImg = findViewById(R.id.resultImage);
        resultImg.setImageResource(item.getResId());

        TextView resultText = findViewById(R.id.resultText);
        resultText.setText(item.getResultText());
    }
}