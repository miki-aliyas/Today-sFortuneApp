package com.example.todaysfortuneapp;

public enum OmikujiItem {
    DAIKICHI(R.drawable.daikichi, "大吉"),
    KICHI(R.drawable.kichi, "吉"),
    CHUKICHI(R.drawable.chukichi,"中吉"),
    SHOKICHI(R.drawable.shokichi,"小吉"),
    SUEKICHI(R.drawable.suekichi,"末吉"),
    KYO(R.drawable.kyo,"凶"),
    DAIKYO(R.drawable.daikyo,"大凶");

    private int resId;
    private String resultText;
    private OmikujiItem(int resId, String resultText) {
        this.resId = resId;
        this.resultText = resultText;
    }

    public int getResId() {
        return this.resId;
    }
    public String getResultText() {
        return this.resultText;
    }
}
