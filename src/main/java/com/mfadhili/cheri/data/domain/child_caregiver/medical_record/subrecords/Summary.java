package com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords;

/**
 * This is an EMBEDDABLE entity supporting Medical records
 * This section will hold a general Summary regarding the medical record
 * The entity will be created in the DB as a separate child linked to the main medical record.
 * * */

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Summary {
    @Column(name = "allergies")
    
    private String allergies;

    @Column(name = "hearing_condition")
    
    private String hearing_condition;

    @Column(name = "physical_condition")
    
    private String physical_condition;

    @Column(name = "skin_condition")
    
    private String skin_condition;

    @Column(name = "speaking_condition")
    
    private String speaking_condition;

    @Column(name = "psychological_condition")
    
    private String psychological_condition;

    @Column(name = "others")
    
    private String others;

    /** Getters and setters*/
    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getPsychological_condition() {
        return psychological_condition;
    }

    public void setPsychological_condition(String psychological_condition) {
        this.psychological_condition = psychological_condition;
    }

    public String getSpeaking_condition() {
        return speaking_condition;
    }

    public void setSpeaking_condition(String speaking_condition) {
        this.speaking_condition = speaking_condition;
    }

    public String getSkin_condition() {
        return skin_condition;
    }

    public void setSkin_condition(String skin_condition) {
        this.skin_condition = skin_condition;
    }

    public String getPhysical_condition() {
        return physical_condition;
    }

    public void setPhysical_condition(String physical_condition) {
        this.physical_condition = physical_condition;
    }

    public String getHearing_condition() {
        return hearing_condition;
    }

    public void setHearing_condition(String hearing_condition) {
        this.hearing_condition = hearing_condition;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    /** To String*/
    @Override
    public String toString() {
        return "Summary{" +
                "allergies='" + allergies + '\'' +
                ", hearing_condition='" + hearing_condition + '\'' +
                ", physical_condition='" + physical_condition + '\'' +
                ", skin_condition='" + skin_condition + '\'' +
                ", speaking_condition='" + speaking_condition + '\'' +
                ", psychological_condition='" + psychological_condition + '\'' +
                ", others='" + others + '\'' +
                '}';
    }


}