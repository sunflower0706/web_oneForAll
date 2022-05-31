package com.hcmute.oneforall.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MovieDirectorKey implements Serializable {
    @Column(name = "idDT")
    private int idDT;

    @Column(name = "idMV")
    private int idMV;

    public void setIdMV(int idMV) {
        this.idMV = idMV;
    }

    public void setIdDT(int idDT) {
        this.idDT = idDT;
    }

    public int getIdMV() {
        return idMV;
    }

    public int getIdDT() {
        return idDT;
    }
}
