package com.example.albumdetailsusingmvvm.view;

import android.util.Log;

import com.example.albumdetailsusingmvvm.model.AlbumState;
import com.example.albumdetailsusingmvvm.model.Result;
import com.example.albumdetailsusingmvvm.service.Repository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class AlbumViewModel extends ViewModel {

    private MutableLiveData<AlbumState> albumsStateMutableLiveData = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    Repository repository;

    public void init(){
        repository = new Repository();
        getAlbums();
    }

    private void getAlbums() {
        compositeDisposable.add(repository.getAlbums()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .map(this::getAlbumState)
                            .subscribe(albumState -> {
                                albumsStateMutableLiveData.setValue(albumState);
                            }, throwable -> Log.d("TAG", throwable.getMessage())));
    }

    public MutableLiveData<AlbumState> getAlbumsStateMutableLiveData() {
        return albumsStateMutableLiveData;
    }

    private AlbumState getAlbumState(List<Result> results){
        AlbumState albumState = new AlbumState();
        albumState.addAll(results);
        return albumState;
    }
}
