package com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords;

/**
 * This is an EMBEDDABLE entity supporting Medical records
 * This section will hold Occupational Therapy information regarding the medical record
 * The entity will be created in the DB as a separate child linked to the main medical record.
 * * */

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Occup_therapy {
    @Column(name = "need_for_therapy")
    
    private String need_for_therapy;

    @Column(name = "wellness_support")
    
    private String wellness_support;

    @Column(name = "extensive_support")
    
    private String extensive_support;

    @Column(name = "referral_followup")
    
    private String referral_followup;

    /** Getters and setters*/
    public String getReferral_followup() {
        return referral_followup;
    }

    public void setReferral_followup(String referral_followup) {
        this.referral_followup = referral_followup;
    }

    public String getExtensive_support() {
        return extensive_support;
    }

    public void setExtensive_support(String extensive_support) {
        this.extensive_support = extensive_support;
    }

    public String getWellness_support() {
        return wellness_support;
    }

    public void setWellness_support(String wellness_support) {
        this.wellness_support = wellness_support;
    }

    public String getNeed_for_therapy() {
        return need_for_therapy;
    }

    public void setNeed_for_therapy(String need_for_therapy) {
        this.need_for_therapy = need_for_therapy;
    }
}