package com.example.android.bullsandcows.Game.Model;

/**
 * Created by Pena on 2017-04-23.
 */
public class GameData {

    int mComputerInputData[] = new int[3];
    int mPlayerInputData[] = new int[3];

    int mPlayerInputCursor;
    int mChanceCount;

    boolean mGameOver;

    static GameData mInstance = null;

    private GameData() { }

    public static GameData getInstance() {
        if (mInstance == null)
            mInstance = new GameData();

        return mInstance;
    }

    public void startGame() {
        for (int i = 0; i < 3; i++) {
            mComputerInputData[i] = (int)(Math.random() * 9) + 1;

            for (int j = 0; j < i; j++) {
                if (mComputerInputData[i] == mComputerInputData[j])
                {
                    i--;

                    break;
                }
            }
        }

        for (int i = 0; i < 3; i++) mPlayerInputData[i] = 0;

        mPlayerInputCursor = 0;
        mChanceCount       = 9;

        mGameOver = false;
    }

    public boolean inputPlayerData(int playerInput) {
        if (mPlayerInputCursor == 3)
            return false;

        for (int i = 0; i < mPlayerInputCursor; i++) {
            if (mPlayerInputData[i] == playerInput)
                return false;
        }

        mPlayerInputData[mPlayerInputCursor++] = playerInput;

        return true;
    }

    public boolean backPlayerData() {
        if (mPlayerInputCursor == 0)
            return false;

        mPlayerInputCursor--;

        return true;
    }

    public String getPlayerInputData() {
        String data = "";

        for (int i = 0; i < mPlayerInputCursor; i++) {
            data += mPlayerInputData[i];
        }

        return data;
    }

    public boolean isCompareChanceAvailable() {
        return mChanceCount != 0;
    }

    public int getCompareChance() {
        return mChanceCount;
    }

    public String calcGameScore() {
            if (mPlayerInputCursor != 3)
            return "More Info!";
        else if (mGameOver || !isCompareChanceAvailable())
            return "Game Over";
        else
            mChanceCount--;

        boolean strikeTable[] = new boolean[3];

        int strikeCount = 0;
        int ballCount   = 0;

        for (int i = 0; i < 3; i++) strikeTable[i] = false;

        for (int i = 0; i < 3; i++) {
            if (mComputerInputData[i] == mPlayerInputData[i]) {
                strikeTable[i] = true;
                strikeCount++;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (strikeTable[i])
                continue;

            for (int j = 0; j < 3; j++) {
                if (strikeTable[j])
                    continue;;

                if (mComputerInputData[i] == mPlayerInputData[j]) {
                    ballCount++;
                    break;
                }
            }
        }

        if (strikeCount == 3 || mChanceCount == 0)
            mGameOver = true;

        return "S" + strikeCount + "B" + ballCount;
    }

}
