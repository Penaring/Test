package com.example.android.bullsandcows.Game.View;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.bullsandcows.Game.Model.GameData;
import com.example.android.bullsandcows.Game.Presenter.GamePresenter;
import com.example.android.bullsandcows.R;
import com.example.android.bullsandcows.databinding.ActivityMainBinding;

public class GameActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GamePresenter presenter = new GamePresenter();
        presenter.setGameData(GameData.getInstance());

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setActivity(this);
        mBinding.setPresenter(presenter);

        FragmentManager     fm  = getFragmentManager();
        FragmentTransaction fmt = fm.beginTransaction();
        fmt.replace(R.id.display_framelayout, DisplayFragment.newInstance(presenter));
        fmt.replace(R.id.input_framelayout,   InputFragment.  newInstance(presenter));
        fmt.commit();

        presenter.startGame();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mBinding.getPresenter().detachViews();
    }
}
