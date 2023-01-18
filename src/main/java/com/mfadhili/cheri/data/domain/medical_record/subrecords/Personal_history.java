package com.mfadhili.cheri.data.domain.medical_record.subrecords;

/**
 * This is an EMBEDDABLE entity supporting Medical records
 * This section will hold Personal History information regarding the medical record
 * The entity will be created in the DB as a separate child linked to the main medical record.
 * * */

import com.mfadhili.cheri.data.domain.medical_record.Medical_record;

import javax.persistence.*;


@Entity
@Table(name = "med_history")
public class Personal_history {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "language")
    
    private String language;

    @Column(name = "inquiry_referral")
    
    private String inquiry_referral;

    @Column(name = "social_status")
    
    private String social_status;

    @Column(name = "postnatal_immunisation")
    
    private String postnatal_immunisation;

    @Column(name = "chief_complain")
    
    private String chief_complain;

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

    public String getChief_complain() {
        return chief_complain;
    }

    public void setChief_complain(String chief_complain) {
        this.chief_complain = chief_complain;
    }

    public String getPostnatal_immunisation() {
        return postnatal_immunisation;
    }

    public void setPostnatal_immunisation(String postnatal_immunisation) {
        this.postnatal_immunisation = postnatal_immunisation;
    }

    public String getSocial_status() {
        return social_status;
    }

    public void setSocial_status(String social_status) {
        this.social_status = social_status;
    }

    public String getInquiry_referral() {
        return inquiry_referral;
    }

    public void setInquiry_referral(String inquiry_referral) {
        this.inquiry_referral = inquiry_referral;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}