package com.example.albumdetailsusingmvvm.service.remoteService;

import com.example.albumdetailsusingmvvm.common.Constants;
import com.example.albumdetailsusingmvvm.model.Album;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlbumService {

    @GET(Constants.RELATIVE_URL)
    Single<Album> getAlbums(@Query("format") String format,
                            @Query("access-token") String access_token);
}
