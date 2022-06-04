package com.example.movie.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.movie.Model.Giohang;
import com.example.movie.Model.Phim;
import com.example.movie.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ChitietPhimActivity extends AppCompatActivity {
    Toolbar toolbarchitiet;
    ImageView imageViewchitiet;
    TextView txtten,txtgia,txtmota;
    Spinner spinner;
    Button btndatmua;
    int id = 0;
    String Tenchitiet = "";
    int Giachitiet = 0;
    String Motachitiet = "";
    String Hinhanhchitiet = "";
    int  Idphim = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_phim);
        Anhxa();
        ActionToolbar();
        GetInfomation();
        CatchEvenSpinner();
        EvenButton();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent = new Intent(getApplicationContext(), com.example.movie.Activity.Giohang.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void EvenButton() {
        btndatmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.manggiohang.size() > 0 ){
                    int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exits= false;
                    for(int i = 0;i < MainActivity.manggiohang.size();i++){
                        if(MainActivity.manggiohang.get(i).getIdphim() == id){
                            MainActivity.manggiohang.get(i).setSoluongphim(MainActivity.manggiohang.get(i).getSoluongphim() + sl);
                            if(MainActivity.manggiohang.get(i).getSoluongphim() >=10){
                                MainActivity.manggiohang.get(i).setSoluongphim(10);
                            }
                            MainActivity.manggiohang.get(i).setGiaphim(Giachitiet * MainActivity.manggiohang.get(i).getSoluongphim());
                            exits = true;
                        }
                    }
                    if(exits == false){
                        //không có phim trùng id
                        int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                        long Giamoi = soluong * Giachitiet;
                        MainActivity.manggiohang.add(new Giohang(id,Tenchitiet,Giamoi,Hinhanhchitiet,soluong));

                    }
                }else{
                    int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                    long Giamoi = soluong * Giachitiet;
                    MainActivity.manggiohang.add(new Giohang(id,Tenchitiet,Giamoi,Hinhanhchitiet,soluong));

                }
                Intent intent = new Intent(getApplicationContext(), com.example.movie.Activity.Giohang.class);
                startActivity(intent);
            }
        });
    }

    private void CatchEvenSpinner() {
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayadapter = new ArrayAdapter<Integer>(
                this, android.R.layout.simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(arrayadapter);
    }

    private void GetInfomation() {
       Phim phim = (Phim) getIntent().getSerializableExtra("thongtinphim");
       id = phim.getID();
       Tenchitiet = phim.getTenphim();
       Giachitiet = phim.getGiaphim();
       Hinhanhchitiet = phim.getHinhanhphim();
       Motachitiet = phim.getMota();
       Idphim = phim.getIDphim();
        txtten.setText(Tenchitiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtgia.setText("Giá: "+decimalFormat.format(Giachitiet)+ " Đ");
        txtmota.setText(Motachitiet);
        Picasso.with(getApplicationContext()).load(Hinhanhchitiet)
        .placeholder(R.drawable.load)
        .error(R.drawable.error)
        .into(imageViewchitiet);
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarchitiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarchitiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbarchitiet = (Toolbar) findViewById(R.id.toolbarchitietphim);
        imageViewchitiet = (ImageView) findViewById(R.id.imageviewchitietphim);
        txtten = (TextView) findViewById(R.id.textviewtenchitietphim);
        txtgia =(TextView) findViewById(R.id.textviewgiachitietphim);
        txtmota = (TextView) findViewById(R.id.textviewmotachitietphim);
        spinner = (Spinner) findViewById(R.id.Spinner);
        btndatmua = (Button) findViewById(R.id.buttondatmua);
    }


}