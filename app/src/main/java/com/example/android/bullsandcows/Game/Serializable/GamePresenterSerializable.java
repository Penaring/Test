package com.example.android.bullsandcows.Game.Serializable;

import com.example.android.bullsandcows.Game.Presenter.GamePresenter;

import java.io.Serializable;

/**
 * Created by Pena on 2017-04-24.
 */
public class GamePresenterSerializable implements Serializable {
    private GamePresenter mData;

    public GamePresenterSerializable(GamePresenter data) {
        mData = data;
    }

    public GamePresenter getData() {
        return mData;
    }
}
