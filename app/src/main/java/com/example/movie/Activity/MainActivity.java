package com.example.movie.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.movie.Adapter.LoaiphimAdapter;
import com.example.movie.Adapter.PhimAdapter;
import com.example.movie.Model.Giohang;
import com.example.movie.Model.Loaiphim;
import com.example.movie.Model.Phim;
import com.example.movie.R;
import com.example.movie.Ultil.CheckConnection;
import com.example.movie.Ultil.Server;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Instant;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    //ViewFlipper viewFlipper;
    RecyclerView recyclerViewmanhinhchinh;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;

    ArrayList<Loaiphim> mangloaiphim;
    LoaiphimAdapter loaiphimAdapter;
    int id =0;
    String tenloaiphim = "";
    String hinhanhloaiphim = "";
    ArrayList<Phim> mangphim;
    PhimAdapter phimAdapter;

    ViewFlipper viewBanner;
    Animation enter, exit;

    //mảng toàn cục để lưu giỏ hàng
    public static ArrayList<Giohang> manggiohang;

    private Instant Picasso;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        //Animation chuyen hinh banner
        enter = AnimationUtils.loadAnimation(this, R.anim.anim_enter);
        exit = AnimationUtils.loadAnimation(this, R.anim.anim_exit);

        //Hien thi banner
        viewBanner.setInAnimation(enter);
        viewBanner.setOutAnimation(exit);
        viewBanner.setFlipInterval(3000);
        viewBanner.setAutoStart(true);
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){


            ActionBar();
//            ActionViewFlipper();
            GetDuLieuLoaiPhim();
            GetDuLieuPhimMoiNhat();
            CatchOnItemListView();

        }else{
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối!");
            finish();
        }

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

    private void CatchOnItemListView() {
        listViewmanhinhchinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,MainActivity.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        //đóng thanh menu
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,PhimHDActivity.class);
                            intent.putExtra("idloaiphim",mangloaiphim.get(i).getId());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,PhimKHVTActivity.class);
                            intent.putExtra("idloaiphim",mangloaiphim.get(i).getId());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,ThongTinActivity.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,Thongtinkhachhang.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }

    private void GetDuLieuPhimMoiNhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongdanPhimmoinhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    int ID = 0;
                    String Tenphim = "";
                    Integer Giaphim = 0;
                    String Hinhanhphim = "";
                    String Motaphim = "";
                    int IDphim = 0;
                    for(int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            Tenphim = jsonObject.getString("tenphim");
                            Giaphim = jsonObject.getInt("giaphim");
                            Hinhanhphim = jsonObject.getString("hinhanhphim");
                            Motaphim = jsonObject.getString("mota");
                            mangphim.add(new Phim(ID,Tenphim,Giaphim,Hinhanhphim,Motaphim,IDphim));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            } 
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void GetDuLieuLoaiPhim() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongdanLoaiphim, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    for(int i = 0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenloaiphim = jsonObject.getString("tenloaiphim");
                            hinhanhloaiphim = jsonObject.getString("hinhanhloaiphim");
                            mangloaiphim.add(new Loaiphim(id,tenloaiphim,hinhanhloaiphim));
                            loaiphimAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    mangloaiphim.add(3,new Loaiphim(0,"Liên hệ","https://tamquatthanthien.vn/uploads/news/2020_03/telephone-icon.png"));
                    mangloaiphim.add(4,new Loaiphim(0,"Thông tin","https://png.pngtree.com/png-vector/20190916/ourlarge/pngtree-info-icon-for-your-project-png-image_1731084.jpg"));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

//    private  void ActionViewFlipper(){
//        ArrayList<String> mangquancao = new ArrayList<>();
//        mangquancao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9LsE9oSfhRlv8QMF3-OsH-wYPQw3FOhM6OA&usqp=CAU");
//        mangquancao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvPTP3zMoEPCiokV3GV22vkd_bMvMfb4BzbQ&usqp=CAU");
//        mangquancao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGOcwCZXonjcVf09g_cdzucq4k0_RiiA7XcA&usqp=CAU");
//        mangquancao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvUacgD2CMs_IRDxnwqXn_FYZbLUWq-M_qZQ&usqp=CAU");
//        for(int i=0;i<mangquancao.size();i++){
//            ImageView imageView = new ImageView(getApplicationContext());
//            //Picasso.with(getBaseContext()).load(mangquancao.get(i)).into(imageView);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            viewFlipper.addView(imageView);
//        }
//        viewFlipper.setFlipInterval(5000);
//        viewFlipper.setAutoStart(true);
//        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
//        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
//        viewFlipper.setInAnimation(animation_slide_in);
//        viewFlipper.setOutAnimation(animation_slide_out);
//    }

    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa() {
        viewBanner = (ViewFlipper) findViewById(R.id.viewlipper);
        toolbar = (Toolbar) findViewById(R.id.toolbarmanhinhchinh);
        //viewFlipper = (ViewFlipper) findViewById(R.id.viewlipper);
        recyclerViewmanhinhchinh = (RecyclerView) findViewById(R.id.recyclerview);
        navigationView = (NavigationView) findViewById(R.id.navigatonview);
        listViewmanhinhchinh = (ListView) findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);

        // đỗ dữ liệu cho thanh menu
        mangloaiphim = new ArrayList<>();
        mangloaiphim.add(0,new Loaiphim(0,"Trang chính","https://sachluat.com.vn/images/home-icon.png"));
        loaiphimAdapter = new LoaiphimAdapter(mangloaiphim, getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaiphimAdapter);

        mangphim = new ArrayList<>();
        phimAdapter = new PhimAdapter(getApplicationContext(), mangphim);
        recyclerViewmanhinhchinh.setHasFixedSize(true);
        recyclerViewmanhinhchinh.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerViewmanhinhchinh.setAdapter(phimAdapter);

        //kiểm tra mảng giỏ hàng để tránh mất dữ liệu
        if(manggiohang !=null){

        }else{
            manggiohang = new ArrayList<>();
        }
    }
}
