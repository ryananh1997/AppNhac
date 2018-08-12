package com.atn.anhtuankg1997.appnhac.Service;

import com.atn.anhtuankg1997.appnhac.Model.Album;
import com.atn.anhtuankg1997.appnhac.Model.BaiHat;
import com.atn.anhtuankg1997.appnhac.Model.ChuDeTheLoaiToday;
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

    @GET("chudevatheloaitrongngay.php")
    Call<ChuDeTheLoaiToday> GetChuDeTheLoaiCurrentday();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatduocthich.php")
    Call<List<BaiHat>> GetBaiHatHot();


}
