package com.example.movie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.Activity.ChitietPhimActivity;
import com.example.movie.Model.Phim;
import com.example.movie.R;
import com.example.movie.Ultil.CheckConnection;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PhimAdapter extends RecyclerView.Adapter<PhimAdapter.ItemHolder> {
    Context context;
    ArrayList<Phim> arrayphim ;

    public PhimAdapter(Context context, ArrayList<Phim> arrayphim) {
        this.context = context;
        this.arrayphim = arrayphim;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_phimmoinhat,null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Phim phim = arrayphim.get(position);
        holder.txttenphim.setText(phim.getTenphim());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiaphim.setText("Giá :" + decimalFormat.format( phim.getGiaphim())+ " đ");
        Picasso.with(context).load(phim.getHinhanhphim())
                .placeholder(R.drawable.load)
                .error(R.drawable.error)
                .into(holder.imghinhphim);
    }

    @Override
    public int getItemCount() {
        return arrayphim.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imghinhphim;
        public TextView txttenphim,txtgiaphim;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imghinhphim = itemView.findViewById(R.id.imgviewphim);
            txttenphim = itemView.findViewById(R.id.textviewtenphim);
            txtgiaphim = itemView.findViewById(R.id.textviewgiaphim);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChitietPhimActivity.class);
                    intent.putExtra("thongtinphim",arrayphim.get(getAdapterPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
            });
        }
    }
}
