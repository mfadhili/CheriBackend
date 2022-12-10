package com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords;

/**
 * This is an EMBEDDABLE entity supporting Medical records
 * This section will hold Activity behavioural information regarding the medical record
 * The entity will be created in the DB as a separate child linked to the main medical record.
 * * */

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Activity {
    @Column(name = "feeding_eating")
    
    private String feeding_eating;

    @Column(name = "dressing_skills")
    
    private String dressing_skills;

    @Column(name = "hygiene_skills")
    
    private String hygiene_skills;

    @Column(name = "domestic_skills")
    
    private String domestic_skills;

    @Column(name = "communication_skills")
    
    private String communication_skills;

    /** Getters and setters*/
    public String getCommunication_skills() {
        return communication_skills;
    }

    public void setCommunication_skills(String communication_skills) {
        this.communication_skills = communication_skills;
    }

    public String getDomestic_skills() {
        return domestic_skills;
    }

    public void setDomestic_skills(String domestic_skills) {
        this.domestic_skills = domestic_skills;
    }

    public String getHygiene_skills() {
        return hygiene_skills;
    }

    public void setHygiene_skills(String hygiene_skills) {
        this.hygiene_skills = hygiene_skills;
    }

    public String getDressing_skills() {
        return dressing_skills;
    }

    public void setDressing_skills(String dressing_skills) {
        this.dressing_skills = dressing_skills;
    }

    public String getFeeding_eating() {
        return feeding_eating;
    }

    public void setFeeding_eating(String feeding_eating) {
        this.feeding_eating = feeding_eating;
    }
}