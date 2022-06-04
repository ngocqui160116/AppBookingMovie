package com.example.movie.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movie.Model.Phim;
import com.example.movie.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PhimHDAdapter extends BaseAdapter {

    Context context;
    ArrayList<Phim> arrayphimhd;

    public PhimHDAdapter(Context context, ArrayList<Phim> arrayphimhd) {
        this.context = context;
        this.arrayphimhd = arrayphimhd;
    }

    @Override
    public int getCount() {
        return arrayphimhd.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayphimhd.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        public TextView txttenphimhd,txtgiaphim,txtmotaphimhd;
        public ImageView imgphimhd;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_phimhd,null);
            viewHolder.txttenphimhd = (TextView) view.findViewById(R.id.textviewtenphimhd);
            viewHolder.txtgiaphim = (TextView) view.findViewById(R.id.textviewgiaphimhd);
            viewHolder.txtmotaphimhd = (TextView) view.findViewById(R.id.textviewmotaphimhd);
            viewHolder.imgphimhd = (ImageView) view.findViewById(R.id.imgphimhd);
            view.setTag(viewHolder);
        }else{
            viewHolder =(ViewHolder) view.getTag();
        }
        Phim phim =(Phim) getItem(i);
        viewHolder.txttenphimhd.setText(phim.getTenphim());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiaphim.setText("Giá: " + decimalFormat.format(phim.getGiaphim())+"Đ");
        viewHolder.txtmotaphimhd.setMaxLines(2);
        viewHolder.txtmotaphimhd.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotaphimhd.setText(phim.getMota());
        Picasso.with(context).load(phim.getHinhanhphim())
                .placeholder(R.drawable.load)
                .error(R.drawable.error)
                .into(viewHolder.imgphimhd);
        return view;
    }
}
