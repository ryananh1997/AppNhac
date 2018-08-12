package com.atn.anhtuankg1997.appnhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atn.anhtuankg1997.appnhac.Model.BaiHat;
import com.atn.anhtuankg1997.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaihathotAdapter extends RecyclerView.Adapter<BaihathotAdapter.ViewHolder> {

    Context context;
    ArrayList<BaiHat> baiHatArrayList;

    public BaihathotAdapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_baihathot, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = baiHatArrayList.get(position);
        holder.txttencasi.setText(baiHat.getCaSi());
        holder.txttenbaihat.setText(baiHat.getTenBaiHat());
        Picasso.with(context).load(baiHat.getHinhBaiHat()).into(holder.imgHinh);
    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        TextView txttenbaihat, txttencasi;
        ImageView imgHinh, imgLuotthich;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.textviewtenbaihathot);
            txttencasi = itemView.findViewById(R.id.textviewtencasibaihathot);
            imgHinh = itemView.findViewById(R.id.imageviewbaihathot);
            imgLuotthich = itemView.findViewById(R.id.imageviewluotthich);

        }
    }
}
