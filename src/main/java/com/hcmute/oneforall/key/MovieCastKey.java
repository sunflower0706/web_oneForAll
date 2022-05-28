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
}
