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
}
