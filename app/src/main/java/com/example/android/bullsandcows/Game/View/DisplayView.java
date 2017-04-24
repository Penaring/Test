package com.example.android.bullsandcows.Game.View;

/**
 * Created by Pena on 2017-04-23.
 */
public interface DisplayView {

    void displayGameScore(String score);

    void displayPlayerData(String playerData);

    void displayChance(int compareChance);

    void showWinToast();

    void showLoseToast();

}
