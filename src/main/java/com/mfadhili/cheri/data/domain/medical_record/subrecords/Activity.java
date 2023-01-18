package com.mfadhili.cheri.data.domain.medical_record.subrecords;

/**
 * This is an EMBEDDABLE entity supporting Medical records
 * This section will hold Activity behavioural information regarding the medical record
 * The entity will be created in the DB as a separate child linked to the main medical record.
 * * */

import com.mfadhili.cheri.data.domain.medical_record.Medical_record;

import javax.persistence.*;

@Entity
@Table(name = "med_activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "medical_record_id")
    private Medical_record medical_record;

    public Medical_record getMedical_record() {
        return medical_record;
    }

    public void setMedical_record(Medical_record medical_record) {
        this.medical_record = medical_record;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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