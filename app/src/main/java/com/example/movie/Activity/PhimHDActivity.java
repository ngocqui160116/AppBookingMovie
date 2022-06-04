package com.example.movie.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.movie.Adapter.PhimHDAdapter;
import com.example.movie.Adapter.PhimKHVTAdapter;
import com.example.movie.Model.Phim;
import com.example.movie.R;
import com.example.movie.Ultil.CheckConnection;
import com.example.movie.Ultil.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhimHDActivity extends AppCompatActivity {
    Toolbar toolbarphimhd;
    ListView lvphimhd;
    PhimHDAdapter phimHDAdapter;
    ArrayList<Phim> mangphimhd;
    int idphimhd = 0;
    int page =1;
    View footerview;
    boolean isLoading = false;
    mHandler mHandler;
    boolean limitdata =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phim_hdactivity);
        Anhxa();
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            GetIdloaiphim();
            ActionToolBar();
            GetData(page);
            LoadMoreData();
        }
        else{
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại internet");
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

    private void LoadMoreData() {
        lvphimhd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ChitietPhimActivity.class);
                intent.putExtra("thongtinphim",mangphimhd.get(i));
                startActivity(intent);
            }
        });
        lvphimhd.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int i) {

            }

            @Override
            public void onScroll(AbsListView absListview, int FirstItem, int VisibleItem, int TotalItem) {
                if(FirstItem + VisibleItem == TotalItem && TotalItem != 0 && isLoading == false && limitdata == false){
                    isLoading = true;
                    ThreadData threadData = new ThreadData();
                    threadData.start();
                }
            }
        });
    }

    private void GetData(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.Duongdanphimhd + String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id =0;
                String Tenphimhd ="";
                int Giaphim = 0;
                String Hinhanhphimhd ="";
                String Mota = "";
                int Idphimhd =0;
                if(response != null && response.length() != 2){
                    lvphimhd.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for(int i = 0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            Tenphimhd = jsonObject.getString("tenphim");
                            Giaphim = jsonObject.getInt("giaphim");
                            Hinhanhphimhd = jsonObject.getString("hinhanhphim");
                            Mota = jsonObject.getString("mota");
                            Idphimhd = jsonObject.getInt("idphim");
                            mangphimhd.add(new Phim(id,Tenphimhd,Giaphim,Hinhanhphimhd,Mota,Idphimhd));
                            phimHDAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }else{
                   limitdata = true;
                    lvphimhd.removeFooterView(footerview);
                    CheckConnection.ShowToast_Short(getApplicationContext(),"Đã hết dữ liệu");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //truyền dữ liệu cho server dưới dạng hashmap<key,value>
                HashMap<String,String> param = new HashMap<String,String>();
                param.put("idphim",String.valueOf(idphimhd));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarphimhd);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarphimhd.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetIdloaiphim() {
        idphimhd = getIntent().getIntExtra("idloaiphim",-1);
    }

    private void Anhxa() {
        toolbarphimhd = (Toolbar) findViewById(R.id.toolbarphimhd);
        lvphimhd = (ListView) findViewById(R.id.listviewphimhd);
        mangphimhd = new ArrayList<>();
        phimHDAdapter = new PhimHDAdapter(getApplicationContext(),mangphimhd);
        lvphimhd.setAdapter(phimHDAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = inflater.inflate(R.layout.progressbar,null);
        mHandler = new mHandler();
    }

    public class mHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0:
                    lvphimhd.addFooterView(footerview);
                    break;
                case 1:
                    GetData(++page);
                    isLoading = false;
                    break;
            }
            super.handleMessage(msg);
        }
    }

    public class ThreadData extends Thread{
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message =mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }
}