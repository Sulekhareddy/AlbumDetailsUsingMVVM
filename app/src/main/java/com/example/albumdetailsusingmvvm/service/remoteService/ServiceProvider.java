package com.example.albumdetailsusingmvvm.service.remoteService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {

    private static final String BASE_URL = "https://gorest.co.in/";

    private AlbumService albumService;

    private static ServiceProvider serviceProvider;

    private ServiceProvider(){
        buildRetrofit();
    }

    public static ServiceProvider getInstance(){
        if(serviceProvider == null){
            serviceProvider = new ServiceProvider();
        }

        return serviceProvider;
    }

    private void buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        albumService = retrofit.create(AlbumService.class);
    }

    public AlbumService getAlbumService(){
        return albumService;
    }
}
