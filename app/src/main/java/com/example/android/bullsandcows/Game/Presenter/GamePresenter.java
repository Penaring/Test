package com.example.android.bullsandcows.Game.Presenter;

import com.example.android.bullsandcows.Game.Model.GameData;
import com.example.android.bullsandcows.Game.View.DisplayView;

/**
 * Created by Pena on 2017-04-23.
 */
public class GamePresenter {

    DisplayView mDisplayView;
    GameData    mGameData;

    public void attachDisplayView(DisplayView displayView) {
        mDisplayView = displayView;
    }

    public void detachViews() {
        mDisplayView = null;
    }

    public void setGameData(GameData gameData) {
        mGameData = gameData;
    }

    public void startGame() {
        if (mGameData == null)
            return;

        mGameData.startGame();

        if (mDisplayView != null) {
            mDisplayView.displayPlayerData(mGameData.getPlayerInputData());
            mDisplayView.displayGameScore(mGameData.calcGameScore());
            mDisplayView.displayChance(mGameData.getCompareChance());
        }
    }

    public void inputPlayerData(int playerData) {
        if (mGameData == null)
            return;

        mGameData.inputPlayerData(playerData);

        if (mDisplayView != null) {
            mDisplayView.displayPlayerData(mGameData.getPlayerInputData());
        }
    }

    public void backPlayerData() {
        if (mGameData == null)
            return;

        mGameData.backPlayerData();

        if (mDisplayView != null) {
            mDisplayView.displayPlayerData(mGameData.getPlayerInputData());
        }
    }

    public void calcGameScore() {
        if (mGameData == null)
            return;

        String result = mGameData.calcGameScore();

        if (mDisplayView != null) {
            mDisplayView.displayChance(mGameData.getCompareChance());
            mDisplayView.displayGameScore(result);

            if (result.equals("S3B0"))
                mDisplayView.showWinToast();
            else if (mGameData.getCompareChance() == 0)
                mDisplayView.showLoseToast();
        }
    }

}
