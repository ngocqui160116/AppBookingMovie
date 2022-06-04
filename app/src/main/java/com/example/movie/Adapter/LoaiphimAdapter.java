package com.example.movie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movie.Model.Loaiphim;
import com.example.movie.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaiphimAdapter extends BaseAdapter {
    ArrayList<Loaiphim> arrayListLoaiphim;
    Context context;

    public LoaiphimAdapter(ArrayList<Loaiphim> arrayListLoaiphim, Context context){
        this.arrayListLoaiphim = arrayListLoaiphim;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListLoaiphim.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListLoaiphim.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public  class ViewHolder{
        TextView txttenloaiphim;
        ImageView imgloaiphim;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listview_loaiphim,null);
            viewHolder.txttenloaiphim = (TextView) view.findViewById(R.id.textviewloaiphim);
            viewHolder.imgloaiphim = (ImageView) view.findViewById(R.id.imageLoaiphim);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)  view.getTag();
         }
        Loaiphim loaiphim = (Loaiphim)  getItem(i);
        viewHolder.txttenloaiphim.setText(loaiphim.getTenloaiphim());
        Picasso.with(context).load(loaiphim.getHinhanhloaiphim())
                .placeholder(R.drawable.load)
                .error(R.drawable.error)
                .into(viewHolder.imgloaiphim);
        return view;
    }
}
