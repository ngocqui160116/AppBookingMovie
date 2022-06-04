package com.example.movie.Model;

public class Loaiphim {
    public int Id;
    public  String Tenloaiphim;
    public  String Hinhanhloaiphim;

    public Loaiphim(int id, String tenloaiphim, String hinhanhloaiphim) {
        Id = id;
        Tenloaiphim = tenloaiphim;
        Hinhanhloaiphim = hinhanhloaiphim;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenloaiphim() {
        return Tenloaiphim;
    }

    public void setTenloaiphim(String tenloaiphim) {
        Tenloaiphim = tenloaiphim;
    }

    public String getHinhanhloaiphim() {
        return Hinhanhloaiphim;
    }

    public void setHinhanhloaiphim(String hinhanhloaiphim) {
        Hinhanhloaiphim = hinhanhloaiphim;
    }
}
