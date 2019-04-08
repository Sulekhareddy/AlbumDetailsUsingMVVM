package com.example.albumdetailsusingmvvm.service.remoteService;

import com.example.albumdetailsusingmvvm.common.Constants;
import com.example.albumdetailsusingmvvm.model.Result;

import java.util.List;

import io.reactivex.Single;

public class AlbumDataSource {

    AlbumService albumService;

    public AlbumDataSource() {
        albumService = ServiceProvider.getInstance().getAlbumService();
    }

    public Single<List<Result>> getAlbums(){
        return albumService.getAlbums(Constants.FORMAT, Constants.ACCESS_TOKEN)
                .flatMap(album -> Single.just(album.getResult()));
    }
}
