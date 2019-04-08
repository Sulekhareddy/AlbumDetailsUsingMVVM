package com.example.albumdetailsusingmvvm.service;

import com.example.albumdetailsusingmvvm.model.Result;
import com.example.albumdetailsusingmvvm.service.remoteService.AlbumDataSource;

import java.util.List;

import io.reactivex.Single;

public class Repository {

    AlbumDataSource albumDataSource;

    public Repository() {
        albumDataSource = new AlbumDataSource();
    }

    public Single<List<Result>> getAlbums(){
        return albumDataSource.getAlbums();
    }
}
