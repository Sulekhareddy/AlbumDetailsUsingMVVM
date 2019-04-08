package com.example.albumdetailsusingmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;

import com.example.albumdetailsusingmvvm.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initViews();

        AlbumViewModel albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel.class);
        albumViewModel.init();

        albumViewModel.getAlbumsStateMutableLiveData().observe(this, albumState -> {
            if(albumState != null){
                albumAdapter.setAlbumList(albumState.getResultList());
            }
        });

    }

    private void initViews() {
        albumAdapter = new AlbumAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(albumAdapter);
    }

}
