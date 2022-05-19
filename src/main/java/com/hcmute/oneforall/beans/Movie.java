package com.hcmute.oneforall.beans;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "TenMV")
    private String movieName;

    @Column(name = "TheLoai")
    private String category;

    @Column(name = "XepHang")
    private int rank;

    @Column(name = "Sao")
    private double start;

    @Column(name = "Avt")
    private String avt;

    public Movie(){}
    public Movie(int id, String movieName, String category, int rank, double start, String avt){
        this.id = id;
        this.movieName = movieName;
        this.category = category;
        this.rank = rank;
        this.start = start;
        this.avt = avt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getStart() {
        return start;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getAvt() {
        return avt;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", category='" + category + '\'' +
                ", rank=" + rank +
                ", start=" + start +
                ", avt='" + avt + '\'' +
                '}';
    }
}
