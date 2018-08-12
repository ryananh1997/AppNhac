package com.atn.anhtuankg1997.appnhac.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atn.anhtuankg1997.appnhac.Adapter.BaihathotAdapter;
import com.atn.anhtuankg1997.appnhac.Model.BaiHat;
import com.atn.anhtuankg1997.appnhac.R;
import com.atn.anhtuankg1997.appnhac.Service.APIService;
import com.atn.anhtuankg1997.appnhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_BaiHatHot extends Fragment {

    View view;
    RecyclerView recyclerViewBaiHatHot;
    BaihathotAdapter baihathotAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihathot, container, false);
        recyclerViewBaiHatHot = view.findViewById(R.id.recyclerviewBaiHatHot);

        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHat>> callback = dataservice.GetBaiHatHot();
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                ArrayList<BaiHat> baiHatArrayList= (ArrayList<BaiHat>) response.body();
                baihathotAdapter = new BaihathotAdapter(getActivity(), baiHatArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewBaiHatHot.setLayoutManager(linearLayoutManager);
                recyclerViewBaiHatHot.setAdapter(baihathotAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }
}
