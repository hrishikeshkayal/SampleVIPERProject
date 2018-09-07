package com.codeeden.sampleviperproject.ui.home;

import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.codeeden.sampleviperproject.BR;
import com.codeeden.sampleviperproject.R;
import com.codeeden.sampleviperproject.ui.home.entity.view.HomeModel;

public class HomeActivity extends AppCompatActivity implements HomeModel.HomeModelCallBack,HomeContracts.View {

    private ViewDataBinding baseBinding;
    private HomeModel homeModel = new HomeModel();
    private HomeContracts.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        baseBinding.setVariable(BR.HomeModel, homeModel);
        baseBinding.setVariable(BR.HomeModelCallBack, this);

        presenter = new HomePresenter(this);
    }

    @Override
    public void onSuccess(String msg) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void sendData() {

    }

    @Override
    public void onClickGetButton() {
        presenter.getCurrentWeather();
    }
}
