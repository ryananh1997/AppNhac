package com.atn.anhtuankg1997.appnhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atn.anhtuankg1997.appnhac.Model.Playlist;
import com.atn.anhtuankg1997.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DanhsachcacplaylistAdapter extends  RecyclerView.Adapter<DanhsachcacplaylistAdapter.ViewHolder>{

    Context context;
    ArrayList<Playlist> mangplaylist;

    public DanhsachcacplaylistAdapter(Context context, ArrayList<Playlist> mangplaylist) {
        this.context = context;
        this.mangplaylist = mangplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_cac_playlist, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlist playlist = mangplaylist.get(position);
        Picasso.with(context).load(playlist.getHinhPlayList()).into(holder.imageHinhnen);
        holder.txtTenplaylist.setText(playlist.getTenPlayList());
    }

    @Override
    public int getItemCount() {
        return mangplaylist.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageHinhnen;
        TextView txtTenplaylist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageHinhnen = itemView.findViewById(R.id.imageviewdanhsachplaylist);
            txtTenplaylist = itemView.findViewById(R.id.textviewtendanhsachcacplaylist);
        }
    }
}
