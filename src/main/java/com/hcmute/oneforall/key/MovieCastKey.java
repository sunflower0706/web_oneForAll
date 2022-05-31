package com.hcmute.oneforall.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MovieCastKey implements Serializable {
    @Column(name = "idAT")
    private int idAT;

    @Column(name = "idMV")
    private int idMV;

    public void setIdMV(int idMV) {
        this.idMV = idMV;
    }

    public void setIdAT(int idAT) {
        this.idAT = idAT;
    }

    public int getIdMV() {
        return idMV;
    }

    public int getIdAT() {
        return idAT;
    }
}
