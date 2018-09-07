package com.codeeden.sampleviperproject.ui.home;

public class HomeInteractor implements HomeContracts.Interactor{

    private HomeContracts.InteractorOutput output;

    public HomeInteractor(HomeContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void getCurrentWeatherData() {
        output.provideCurrentWeatherData();
    }
}
