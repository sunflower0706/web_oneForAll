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
}
