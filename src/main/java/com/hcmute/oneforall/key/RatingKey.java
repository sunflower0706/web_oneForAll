package com.hcmute.oneforall.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RatingKey implements Serializable {
    @Column(name = "idTK")
    private int idTK;

    @Column(name = "idMV")
    private int idMV;

    public void setIdMV(int idMV) {
        this.idMV = idMV;
    }

    public void setIdTK(int idTK) {
        this.idTK = idTK;
    }

    public int getIdMV() {
        return idMV;
    }

    public int getIdTK() {
        return idTK;
    }
}
