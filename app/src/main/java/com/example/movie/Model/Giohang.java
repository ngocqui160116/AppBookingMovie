package com.example.movie.Model;

public class Giohang {
    public int idphim;
    public String tenphim;
    public long giaphim;
    public String hinhphim;
    public int soluongphim;

    public Giohang(int idphim, String tenphim, long giaphim, String hinhphim, int soluongphim) {
        this.idphim = idphim;
        this.tenphim = tenphim;
        this.giaphim = giaphim;
        this.hinhphim = hinhphim;
        this.soluongphim = soluongphim;
    }

    public int getIdphim() {
        return idphim;
    }

    public void setIdphim(int idphim) {
        this.idphim = idphim;
    }

    public String getTenphim() {
        return tenphim;
    }

    public void setTenphim(String tenphim) {
        this.tenphim = tenphim;
    }

    public long getGiaphim() {
        return giaphim;
    }

    public void setGiaphim(long giaphim) {
        this.giaphim = giaphim;
    }

    public String getHinhphim() {
        return hinhphim;
    }

    public void setHinhphim(String hinhphim) {
        this.hinhphim = hinhphim;
    }

    public int getSoluongphim() {
        return soluongphim;
    }

    public void setSoluongphim(int soluongphim) {
        this.soluongphim = soluongphim;
    }
}
