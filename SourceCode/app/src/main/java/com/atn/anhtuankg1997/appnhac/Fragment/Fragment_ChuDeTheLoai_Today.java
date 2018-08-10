package com.atn.anhtuankg1997.appnhac.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atn.anhtuankg1997.appnhac.Model.ChuDe;
import com.atn.anhtuankg1997.appnhac.Model.ChuDeTheLoaiToday;
import com.atn.anhtuankg1997.appnhac.Model.TheLoai;
import com.atn.anhtuankg1997.appnhac.R;
import com.atn.anhtuankg1997.appnhac.Service.APIService;
import com.atn.anhtuankg1997.appnhac.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDeTheLoai_Today extends Fragment {

    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtxemthemchudetheloai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chudetheloai_today, container, false);
        horizontalScrollView = view.findViewById(R.id.HorizontalScrollView);
        txtxemthemchudetheloai = view.findViewById(R.id.xemthemchudetheloaicurrentday);

        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice= APIService.getService();
        Call<ChuDeTheLoaiToday> callback = dataservice.GetChuDeTheLoaiCurrentday();
        callback.enqueue(new Callback<ChuDeTheLoaiToday>() {
            @Override
            public void onResponse(Call<ChuDeTheLoaiToday> call, Response<ChuDeTheLoaiToday> response) {
                ChuDeTheLoaiToday theLoaiToday = response.body();

                final ArrayList<ChuDe> chuDeArrayList = new ArrayList<>();
                chuDeArrayList.addAll(theLoaiToday.getChuDe());

                final ArrayList<TheLoai> theLoaiArrayList= new ArrayList<>();
                theLoaiArrayList.addAll(theLoaiToday.getTheLoai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(580, 250);
                layoutParams.setMargins(10,20,10,30);

                for(int i =0 ; i<(chuDeArrayList.size()); i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView img = new ImageView(getActivity());
                    img.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(chuDeArrayList.get(i).getHinhChuDe() != null){
                        Picasso.with(getActivity()).load(chuDeArrayList.get(i).getHinhChuDe()).into(img);
                    }
                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(img);
                    linearLayout.addView(cardView);
                }

                for(int j =0 ; j<(chuDeArrayList.size()); j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView img = new ImageView(getActivity());
                    img.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(theLoaiArrayList.get(j).getHinhTheLoai() != null){
                        Picasso.with(getActivity()).load(theLoaiArrayList.get(j).getHinhTheLoai()).into(img);
                    }
                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(img);
                    linearLayout.addView(cardView);
                }
                horizontalScrollView.addView(linearLayout);


            }

            @Override
            public void onFailure(Call<ChuDeTheLoaiToday> call, Throwable t) {

            }
        });
    }
}
