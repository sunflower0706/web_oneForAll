package com.hcmute.oneforall.beans;

import com.hcmute.oneforall.key.RatingKey;
import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
    @EmbeddedId
    @Column(name = "idRT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private RatingKey id;

    @ManyToOne
    @MapsId("idMV")
    @JoinColumn(name = "idMV")
    private Movie movie;

    @ManyToOne
    @MapsId("idTK")
    @JoinColumn(name = "idTK")
    private Account account;

    @Column(name = "sao")
    private int sao;

    public void setId(RatingKey id) {
        this.id = id;
    }

    public RatingKey getId() {
        return id;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }

    public int getSao() {
        return sao;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", movie=" + movie +
                ", account=" + account +
                ", sao=" + sao +
                '}';
    }
}
