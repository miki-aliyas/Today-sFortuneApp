package com.example.todaysfortuneapp;
//＜おみくじの結果を表す列挙型（enum）である[OmikujiItem]を定義＞

public enum OmikujiItem {
    DAIKICHI(R.drawable.daikichi, "大吉"),
    KICHI(R.drawable.kichi, "吉"),
    CHUKICHI(R.drawable.chukichi,"中吉"),
    SHOKICHI(R.drawable.shokichi,"小吉"),
    SUEKICHI(R.drawable.suekichi,"末吉"),
    KYO(R.drawable.kyo,"凶"),
    DAIKYO(R.drawable.daikyo,"大凶");

//  [resId]＝おみくじの結果に関連付けられた画像リソースのIDを保持するためのプライベートフィールド。
    private int resId;
//  [resultText]＝おみくじの結果に関連付けられたテキストを保持するためのプライベートフィールド。
    private String resultText;
//  それぞれの定数に関連付けられた画像リソースIDとテキストを受け取る
    private OmikujiItem(int resId, String resultText) {
        this.resId = resId;
        this.resultText = resultText;
    }

//  [getResId()]＝おみくじの結果に関連付けられた画像リソースのIDを取得する。
    public int getResId() {
        return this.resId;
    }
//  [getResultText()]＝おみくじの結果に関連付けられたテキストを取得する。
    public String getResultText() {
        return this.resultText;
    }
}
