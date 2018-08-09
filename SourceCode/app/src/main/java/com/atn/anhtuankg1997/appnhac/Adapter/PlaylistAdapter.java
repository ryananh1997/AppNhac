package com.atn.anhtuankg1997.appnhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atn.anhtuankg1997.appnhac.Model.Playlist;
import com.atn.anhtuankg1997.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {


    class ViewHolder{
        TextView txtTenplaylist;
        ImageView imgBackground, imgPlaylist;

    }

    public PlaylistAdapter(Context context, int resource, List<Playlist> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist, null);
            viewHolder =  new ViewHolder();
            viewHolder.txtTenplaylist = convertView.findViewById(R.id.textviewtenplaylist);
            viewHolder.imgPlaylist = convertView.findViewById(R.id.imageviewplaylist);
            viewHolder.imgBackground = convertView.findViewById(R.id.imageviewbackgroundplaylist);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhPlayList()).into(viewHolder.imgBackground);
        Picasso.with(getContext()).load(playlist.getIconPlayList()).into(viewHolder.imgPlaylist);
        viewHolder.txtTenplaylist.setText(playlist.getTenPlayList());


        return convertView;
    }
}
