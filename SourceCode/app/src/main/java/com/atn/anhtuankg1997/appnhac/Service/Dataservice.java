package com.atn.anhtuankg1997.appnhac.Service;

import com.atn.anhtuankg1997.appnhac.Model.Playlist;
import com.atn.anhtuankg1997.appnhac.Model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {

    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();


    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlayListCurrentDay();

}
