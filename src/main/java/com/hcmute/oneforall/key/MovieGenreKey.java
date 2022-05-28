package com.hcmute.oneforall.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MovieGenreKey implements Serializable {
    @Column(name = "idGR")
    private int idGR;

    @Column(name = "idMV")
    private int idMV;
}
