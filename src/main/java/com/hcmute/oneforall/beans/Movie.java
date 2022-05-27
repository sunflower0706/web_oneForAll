package com.hcmute.oneforall.beans;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column(name = "idMV")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "ten_phim")
    private String ten_phim;

    @Column(name = "nam")
    private String nam;

    @Column(name = "chat_luong")
    private String chat_luong;

    @Column(name = "quoc_gia")
    private String quoc_gia;

    @Column(name = "thoi_luong")
    private int thoi_luong;

    @Column(name = "mo_ta")
    private String mo_ta;

    public Movie(){}

    public Movie(int id, String ten_phim, String nam, String chat_luong, String quoc_gia, int thoi_luong, String mo_ta){
        this.id = id;
        this.ten_phim = ten_phim;
        this.nam = nam;
        this.chat_luong = chat_luong;
        this.quoc_gia = quoc_gia;
        this.thoi_luong = thoi_luong;
        this.mo_ta = mo_ta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTen_phim(String ten_phim) {
        this.ten_phim = ten_phim;
    }

    public String getTen_phim() {
        return ten_phim;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getNam() {
        return nam;
    }

    public void setChat_luong(String chat_luong) {
        this.chat_luong = chat_luong;
    }

    public String getChat_luong() {
        return chat_luong;
    }

    public void setQuoc_gia(String quoc_gia) {
        this.quoc_gia = quoc_gia;
    }

    public String getQuoc_gia() {
        return quoc_gia;
    }

    public void setThoi_luong(int thoi_luong) {
        this.thoi_luong = thoi_luong;
    }

    public int getThoi_luong() {
        return thoi_luong;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", ten_phim='" + ten_phim + '\'' +
                ", nam='" + nam + '\'' +
                ", chat_luong='" + chat_luong + '\'' +
                ", quoc_gia='" + quoc_gia + '\'' +
                ", thoi_luong=" + thoi_luong +
                ", mo_ta='" + mo_ta + '\'' +
                '}';
    }
}
