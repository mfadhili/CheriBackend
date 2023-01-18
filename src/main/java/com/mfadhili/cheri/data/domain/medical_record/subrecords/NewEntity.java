package com.mfadhili.cheri.data.domain.medical_record.subrecords;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NewEntity {
    @Column(name = "tryer")
    private String tryer;

    public String getTryer() {
        return tryer;
    }

    public void setTryer(String tryer) {
        this.tryer = tryer;
    }
}