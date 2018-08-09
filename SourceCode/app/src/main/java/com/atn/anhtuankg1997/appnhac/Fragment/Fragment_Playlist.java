package com.atn.anhtuankg1997.appnhac.Fragment;

import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atn.anhtuankg1997.appnhac.Model.Playlist;
import com.atn.anhtuankg1997.appnhac.R;
import com.atn.anhtuankg1997.appnhac.Service.APIService;
import com.atn.anhtuankg1997.appnhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Playlist extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist, container,false);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        retrofit2.Call<List<Playlist>> callback = dataservice.GetPlayListCurrentDay();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> mangarraylist = (ArrayList<Playlist>) response.body();
                Log.d("BBB", mangarraylist.get(0).getTenPlayList());
            }

            @Override
            public void onFailure(retrofit2.Call<List<Playlist>> call, Throwable t) {

            }
        });
    }
}
