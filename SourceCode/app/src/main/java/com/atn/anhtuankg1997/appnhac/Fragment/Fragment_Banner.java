package com.atn.anhtuankg1997.appnhac.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atn.anhtuankg1997.appnhac.Adapter.BannerAdapter;
import com.atn.anhtuankg1997.appnhac.Model.Quangcao;
import com.atn.anhtuankg1997.appnhac.R;
import com.atn.anhtuankg1997.appnhac.Service.APIService;
import com.atn.anhtuankg1997.appnhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Banner extends Fragment {

    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter bannerAdapter;
    Runnable runnable; //Sau khoảng thời gian thì thực hiện
    Handler handler;
    int CurrentItem; //Lưu giá trị banner đang chạy

    private void anhxa(){
        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.indicatordefault);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container,false);
        anhxa();
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Quangcao>> callback = dataservice.GetDataBanner();
        callback.enqueue(new Callback<List<Quangcao>>() {
            @Override
            public void onResponse(Call<List<Quangcao>> call, Response<List<Quangcao>> response) {
                ArrayList<Quangcao> banner = (ArrayList<Quangcao>) response.body();
                bannerAdapter = new BannerAdapter(getActivity(), banner);
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);
                handler = new Handler();
                runnable =  new Runnable() {
                    @Override
                    public void run() {
                        CurrentItem = viewPager.getCurrentItem();
                        if(CurrentItem >= viewPager.getAdapter().getCount()){
                            CurrentItem = 0;
                        }
                        viewPager.setCurrentItem(CurrentItem, true);
                        handler.postDelayed(runnable, 4000);
                    }
                };
                handler.postDelayed(runnable,4000);
            }

            @Override
            public void onFailure(Call<List<Quangcao>> call, Throwable t) {

            }
        });
    }


}
