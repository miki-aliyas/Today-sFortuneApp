package com.example.todaysfortuneapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.AsyncTask;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResultActivity extends AppCompatActivity {
    public static final String KEY_RESULT_ID = "com.example.todaysfortuneapp.key_result_id";

    // LINE Notifyのアクセストークンを定義
    private static final String TOKEN = "M7bHDTSc1LIDeoq7vh4VxNw66V3ceQ1WwfUgMFvEozN";

    private String lineResultText;
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
        //＜おみくじの結果を表示する＞
        int resultId = getIntent().getIntExtra(KEY_RESULT_ID, -1);
        OmikujiItem item = OmikujiItem.values()[resultId];

        ImageView resultImg = findViewById(R.id.resultImage);
        resultImg.setImageResource(item.getResId());

        TextView resultText = findViewById(R.id.resultText);
        lineResultText = item.getResultText();

        resultText.setText(item.getResultText());
    }
    //<「トップページに戻る」ボタンが表示された後、クリックされる際の処理>
    public void backToTop(View v) {
        // LINEに送信するメッセージを定義
        String linemsg = "あなたのおみくじ結果は" + lineResultText + "でした。";

        // LINEメッセージ送信の関数を呼び出し
        new SendMessageTask().execute(linemsg);

        //　TopActivityに移動する処理
        getOnBackPressedDispatcher().onBackPressed();
    }
    private static class SendMessageTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            String msg = params[0];
            try {
                // APIエンドポイントのURLを定義
                URL url = new URL("https://notify-api.line.me/api/notify");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                // HTTPリクエストヘッダーの設定
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Authorization", "Bearer " + TOKEN);
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                // ペイロードの設定
                String payload = "message=" + msg;

                // HTTPリクエストの送信
                conn.setDoOutput(true);
                try (OutputStream os = conn.getOutputStream()) {
                    os.write(payload.getBytes());
                    os.flush();
                }

                // レスポンスコードの取得
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // 成功
                } else {
                    // エラー処理
                }
                conn.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}