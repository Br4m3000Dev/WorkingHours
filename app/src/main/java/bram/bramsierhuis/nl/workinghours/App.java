package bram.bramsierhuis.nl.workinghours;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class App extends Application {

    private WorkingHoursApi workingHoursApi;

    @Override
    public void onCreate() {
        super.onCreate();
        createApi();
    }

    private void createApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WorkingHoursApi.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        workingHoursApi = retrofit.create(WorkingHoursApi.class);
    }

    public WorkingHoursApi getWorkingHoursApi() {
        return workingHoursApi;
    }
}
