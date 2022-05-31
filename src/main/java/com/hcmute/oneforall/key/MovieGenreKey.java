package com.hcmute.oneforall.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class MovieGenreKey implements Serializable {
    @Column(name = "idGR")
    private int idGR;

    @Column(name = "idMV")
    private int idMV;

    public void setIdMV(int idMV) {
        this.idMV = idMV;
    }

    public void setIdGR(int idGR) {
        this.idGR = idGR;
    }

    public int getIdMV() {
        return idMV;
    }

    public int getIdGR() {
        return idGR;
    }
}
