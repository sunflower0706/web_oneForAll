package com.hcmute.oneforall.beans;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @Column(name = "idAT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ho")
    private String ho;

    @Column(name = "ten")
    private String ten;

    @Column(name = "gioi_tinh")
    private boolean gioi_tinh;

    @OneToMany(mappedBy = "actor")
    private Set<MovieCast> movieCasts;

    public Actor(){}

    public Actor(int id, String ho, String ten, boolean gioi_tinh){
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.gioi_tinh = gioi_tinh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getHo() {
        return ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setGioi_tinh(boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public boolean isGioi_tinh() {
        return gioi_tinh;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", ho='" + ho + '\'' +
                ", ten='" + ten + '\'' +
                ", gioi_tinh=" + gioi_tinh +
                '}';
    }
}
