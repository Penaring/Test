package com.example.android.bullsandcows.Game.View;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.bullsandcows.Game.Presenter.GamePresenter;
import com.example.android.bullsandcows.Game.Serializable.GamePresenterSerializable;
import com.example.android.bullsandcows.R;
import com.example.android.bullsandcows.databinding.FragmentDisplayBinding;

/**
 * Created by Pena on 2017-04-23.
 */
public class DisplayFragment extends Fragment implements DisplayView {
    static final String EXTRA_PRESENTER = "presenter";

    FragmentDisplayBinding mBinding;

    public DisplayFragment() { }

    public static DisplayFragment newInstance(@NonNull GamePresenter presenter) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_PRESENTER, new GamePresenterSerializable(presenter));

        DisplayFragment fragment = new DisplayFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GamePresenterSerializable serializable = (GamePresenterSerializable)getArguments().getSerializable(EXTRA_PRESENTER);
        GamePresenter presenter = serializable.getData();
        presenter.attachDisplayView(this);

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_display, container, false);
        mBinding.setFragment(this);
        mBinding.setPresenter(presenter);

        return mBinding.getRoot();
    }

    @Override
    public void displayGameScore(String score) {
        mBinding.gameScoreText.setText(score);
    }

    @Override
    public void displayPlayerData(String playerData) {
        mBinding.playerDataText.setText(playerData);
    }

    @Override
    public void displayChance(int compareChance) {
        mBinding.chanceText.setText(String.valueOf(compareChance));
    }

    @Override
    public void showWinToast() {
        Toast.makeText(getActivity(), "Win :)", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoseToast() {
        Toast.makeText(getActivity(), "Lose T_T", Toast.LENGTH_SHORT).show();
    }

}
