package com.example.todaysfortuneapp;

import android.content.Intent;
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
    //＜おみくじを引く機能を実装＞
    public void clicked(View v) {
        Random rand = new Random();
        int resultId = rand.nextInt(OmikujiItem.values().length);
        // ＜「TopActivity(トップ画面)から「ResultActivity」(結果画像)に遷移する」処理＞
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(ResultActivity.KEY_RESULT_ID, resultId);
        startActivity(intent);
    }
}