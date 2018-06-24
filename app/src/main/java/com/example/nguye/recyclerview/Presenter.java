package com.example.nguye.recyclerview;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter {
    MainView view;
    public Presenter(MainView view) {
        this.view = view;
    }

    public void loadInfoAndroid(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.learn2crack.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            RequestInterface requestInterface = retrofit.create(RequestInterface.class);
            Call<JSONResponse> call = requestInterface.getJSOn();
            call.enqueue(new Callback<JSONResponse>() {
                @Override
                public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                    if(response != null && response.isSuccessful() && response.body() != null){
                        if(view != null){
                            view.loadJSONSuccess(response.body().getAndroidVersions());
                        }
                    }
            }

                @Override
                public void onFailure(Call<JSONResponse> call, Throwable t) {
                    //Log.d("Error", t.getMessage());
                    view.loadJSONFail(t.getMessage());
                }
            });
        }

}
