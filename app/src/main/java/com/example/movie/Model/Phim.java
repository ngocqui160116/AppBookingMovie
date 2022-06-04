package com.example.movie.Model;

import java.io.Serializable;

public class Phim  implements Serializable {
    public int ID;
    public  String Tenphim;
    public Integer Giaphim;
    public String Hinhanhphim;
    public  String Mota;
    public int IDphim;

    public Phim(int ID, String tenphim, Integer giaphim, String hinhanhphim, String mota, int IDphim) {
        this.ID = ID;
        Tenphim = tenphim;
        Giaphim = giaphim;
        Hinhanhphim = hinhanhphim;
        Mota = mota;
        this.IDphim = IDphim;
    }

    public Phim(int id, String tenphimhd, int giaphim, String hinhanhphimhd, String mota) {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenphim() {
        return Tenphim;
    }

    public void setTenphim(String tenphim) {
        Tenphim = tenphim;
    }

    public Integer getGiaphim() {
        return Giaphim;
    }

    public void setGiaphim(Integer giaphim) {
        Giaphim = giaphim;
    }

    public String getHinhanhphim() {
        return Hinhanhphim;
    }

    public void setHinhanhphim(String hinhanhphim) {
        Hinhanhphim = hinhanhphim;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getIDphim() {
        return IDphim;
    }

    public void setIDphim(int IDphim) {
        this.IDphim = IDphim;
    }
}
