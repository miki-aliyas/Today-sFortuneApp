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
//   [clicked()]＝ボタンがクリックされた際に呼び出される動作。[View v]＝クリックされたビューを参照する。
    public void clicked(View v) {
        // 乱数を生成する
        Random rand = new Random();
//      [OmikujiItem.values().length]＝[OmikujiItem]の列挙型(enum)の要素数を取得する。
//      [rand.nextInt()]＝0から指定された数（[OmikujiItem]の列挙型(enum)の要素数）未満の乱数を生成。
//      [resultId]＝0から[OmikujiItem]の列挙型(enum)の要素数未満のランダムな整数が格納される。
        int resultId = rand.nextInt(OmikujiItem.values().length);
        // ＜「TopActivity(トップ画面)から「ResultActivity」(結果画像)に遷移する」処理＞
//      [Intent]クラスのオブジェクト[intent]を生成。（別のアクティビティを開始する）
//　     [this]＝現在のコンテキストを示す。
//      [ResultActivity.class]＝結果を表示するためのアクティビティのクラス
        Intent intent = new Intent(this, ResultActivity.class);
//      [putExtra()]を使用して[intent]に追加のデータを設定。[ResultActivity.KEY_RESULT_ID]＝結果IDを識別するためのキー。[ResultActivity]クラス内で定義された定数。
//      [resultId]おみくじの結果を表すランダムな整数。
        intent.putExtra(ResultActivity.KEY_RESULT_ID, resultId);
//      [startActivity()]を使用して、指定された[intent]を使って新しいアクティビティを開始。(「ResultActivity」(結果画像)が起動しおみくじの結果が表示される)
        startActivity(intent);
    }
}