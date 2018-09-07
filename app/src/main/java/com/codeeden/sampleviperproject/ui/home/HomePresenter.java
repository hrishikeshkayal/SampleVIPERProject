package com.codeeden.sampleviperproject.ui.home;

import android.content.Context;

public class HomePresenter implements HomeContracts.Presenter, HomeContracts.InteractorOutput{

    private HomeContracts.Router router;
    private HomeContracts.Interactor interactor;
    private HomeContracts.View view;

    public HomePresenter(HomeContracts.View view) {
        this.view = view;
        router = new HomeRouter((Context) view);
        interactor = new HomeInteractor(this);
    }

    @Override
    public void provideCurrentWeatherData() {
        view.onSuccess("If success");
        view.onSuccess("If error");
        router.goToNext();
    }

    @Override
    public void getCurrentWeather() {
        interactor.getCurrentWeatherData();
    }
}
