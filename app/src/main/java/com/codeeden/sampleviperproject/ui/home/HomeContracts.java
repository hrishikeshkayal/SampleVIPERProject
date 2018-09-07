package com.codeeden.sampleviperproject.ui.home;

public class HomeContracts {
    public interface Presenter{
        void getCurrentWeather();
    }

    public interface View{
       void onSuccess(String msg);
       void onError(String msg);
       void sendData();
    }

    public interface Interactor{
        void getCurrentWeatherData();
    }

    public interface InteractorOutput{
        void provideCurrentWeatherData();
    }

    public interface Router{
        void goToNext();
    }
}
