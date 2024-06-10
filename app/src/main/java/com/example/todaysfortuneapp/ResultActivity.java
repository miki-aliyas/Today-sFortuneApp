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
//        ＜おみくじの結果を表示する＞
//        [getIntent()]このアクティビティが開始された際のインテントを取得。
//        [getIntExtra()]インテントから指定されたキー (KEY_RESULT_ID) に関連付けられた整数値を取得する。もし指定されたキーが存在しない場合は、デフォルト値として[-1]を返す。
//        [resultId]には、取得した整数値が格納される。
        int resultId = getIntent().getIntExtra(KEY_RESULT_ID, -1);
//        [OmikujiItem.values()]＝[OmikujiItem]という列挙型の全ての要素を配列として返す。
//        [resultId]＝配列のインデックスとして使用され、対応する[OmikujiItem]の要素が取得される。
//        取得した要素は[item]に代入される
        OmikujiItem item = OmikujiItem.values()[resultId];
        //[findViewById()]＝指定されたビューID[R.id.resultImage]に対応するビューを取得する。
        //[resultImg]には、取得した[ImageView]のオブジェクトが格納される。（結果画像を取得する）
        ImageView resultImg = findViewById(R.id.resultImage);
//       [item.getResId()]＝[item]に関連付けられた画像リソースのIDを取得する。
//       [R.id.resultImage]＝レイアウトXMLファイル内で定義された[ImageView]のID。
//       取得した画像リソースのIDは、resultImg のイメージとして設定される。
        resultImg.setImageResource(item.getResId());

//       [findViewById()]＝指定されたビューID[R.id.resultText]に対応するビューを取得する。
//       [R.id.resultText]＝レイアウトXMLファイル内で定義された[TextView]のID。
//      [resultText]には、取得した[TextView]オブジェクトが格納される。
        TextView resultText = findViewById(R.id.resultText);
//      [item.getResultText()]＝[item]に関連付けられたテキストを取得する。
//      取得したテキストは[resultText]のテキストとして設定される。
        resultText.setText(item.getResultText());
    }
    //ResultActivityのレイアウトと戻るボタンが表示された後、ボタンがクリックされるとTopActivityに移動する処理
    public void backtotop(View v) {
//  新しく`Intent`オブジェクトを作成し、このアクティビティ(`this`)からTopActivityを起動するように指定する処理
        Intent intent = new Intent(this, TopActivity.class);
//  Intentに基づいて新しいアクティビティを起動する。（戻るボタンを押したときにTopActivityに移動する処理）
        startActivity(intent);
    }
}