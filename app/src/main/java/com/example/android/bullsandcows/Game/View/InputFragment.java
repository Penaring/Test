package com.example.android.bullsandcows.Game.View;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.bullsandcows.Game.Presenter.GamePresenter;
import com.example.android.bullsandcows.Game.Serializable.GamePresenterSerializable;
import com.example.android.bullsandcows.R;
import com.example.android.bullsandcows.databinding.FragmentInputBinding;

/**
 * Created by Pena on 2017-04-23.
 */
public class InputFragment extends Fragment {
    static final String EXTRA_PRESENTER = "presenter";

    FragmentInputBinding mBinding;

    public InputFragment() { }

    public static InputFragment newInstance(@NonNull GamePresenter presenter) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_PRESENTER, new GamePresenterSerializable(presenter));

        InputFragment fragment = new InputFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GamePresenterSerializable serializable = (GamePresenterSerializable)getArguments().getSerializable(EXTRA_PRESENTER);
        final GamePresenter presenter = serializable.getData();

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_input, container, false);
        mBinding.setFragment(this);
        mBinding.setPresenter(presenter);

        mBinding.num1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1
                presenter.inputPlayerData(1);
            }
        });

        mBinding.num2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2
                presenter.inputPlayerData(2);
            }
        });

        mBinding.num3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3
                presenter.inputPlayerData(3);
            }
        });

        mBinding.num4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 4
                presenter.inputPlayerData(4);
            }
        });

        mBinding.num5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 5
                presenter.inputPlayerData(5);
            }
        });

        mBinding.num6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 6
                presenter.inputPlayerData(6);
            }
        });

        mBinding.num7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 7
                presenter.inputPlayerData(7);
            }
        });

        mBinding.num8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 8
                presenter.inputPlayerData(8);
            }
        });

        mBinding.num9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 9
                presenter.inputPlayerData(9);
            }
        });

        mBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back
                presenter.backPlayerData();
            }
        });

        mBinding.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calc
                presenter.calcGameScore();
            }
        });

        return mBinding.getRoot();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
