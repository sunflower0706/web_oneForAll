package com.hcmute.oneforall.beans;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director {
    @Id
    @Column(name = "idDT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ho")
    private String ho;

    @Column(name = "ten")
    private String ten;

    @OneToMany(mappedBy = "director")
    private Set<MovieDirector> movieDirectors;

    public Director(){}

    public Director(int id, String ho, String ten){
        this.id = id;
        this.ho = ho;
        this.ten = ten;
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

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", ho='" + ho + '\'' +
                ", ten='" + ten + '\'' +
                '}';
    }
}
