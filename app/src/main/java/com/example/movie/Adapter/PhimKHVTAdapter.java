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


public class PhimKHVTAdapter extends BaseAdapter {
    Context context;
    ArrayList<Phim> arrayphimkhvt;

    public PhimKHVTAdapter(Context context, ArrayList<Phim> arrayphimkhvt) {
        this.context = context;
        this.arrayphimkhvt = arrayphimkhvt;
    }

    @Override
    public int getCount() {
        return arrayphimkhvt.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayphimkhvt.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        public TextView txttenphimkhvt,txtgiaphim,txtmotaphimkhvt;
        public ImageView imgphimkhvt;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_phimkhvt,null);
            viewHolder.txttenphimkhvt = (TextView) view.findViewById(R.id.textviewtenphimkhvt);
            viewHolder.txtgiaphim = (TextView) view.findViewById(R.id.textviewgiaphimkhvt);
            viewHolder.txtmotaphimkhvt = (TextView) view.findViewById(R.id.textviewmotaphimkhvt);
            viewHolder.imgphimkhvt = (ImageView) view.findViewById(R.id.imgphimkhvt);
            view.setTag(viewHolder);
        }else{
            viewHolder =(ViewHolder) view.getTag();
        }
        Phim phim =(Phim) getItem(i);
        viewHolder.txttenphimkhvt.setText(phim.getTenphim());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiaphim.setText("Giá: " + decimalFormat.format(phim.getGiaphim())+"Đ");
        viewHolder.txtmotaphimkhvt.setMaxLines(2);
        viewHolder.txtmotaphimkhvt.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotaphimkhvt.setText(phim.getMota());
        Picasso.with(context).load(phim.getHinhanhphim())
                .placeholder(R.drawable.load)
                .error(R.drawable.error)
                .into(viewHolder.imgphimkhvt);
        return view;
    }
}
