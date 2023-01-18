package com.mfadhili.cheri.data.domain.medical_record.subrecords;

/**
 * This is an EMBEDDABLE entity supporting Medical records
 * This section will hold Physique information regarding the medical record
 * The entity will be created in the DB as a separate child linked to the main medical record.
 * * */

import com.mfadhili.cheri.data.domain.medical_record.Medical_record;

import javax.persistence.*;


@Entity
@Table(name = "med_physique")
public class Physique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "head_circumference")
    
    private String head_circumference;

    @Column(name = "hair_col_dist")
    
    private String hair_col_dist;

    @Column(name = "observable_features")
    
    private String observable_features;

    @Column(name = "body_alignment")
    
    private String body_alignment;

    @Column(name = "auditory")
    
    private String auditory;

    @Column(name = "olfactory")
    
    private String olfactory;

    @Column(name = "gastro")
    
    private String gastro;

    @Column(name = "tactile")
    
    private String tactile;

    @Column(name = "perceptual")
    
    private String perceptual;

    @Column(name = "visual")
    
    private String visual;

    @Column(name = "balance")
    
    private String balance;

    @Column(name = "scars_deforms")
    
    private String scars_deforms;

    @Column(name = "play_leisure")
    
    private String play_leisure;

    @Column(name = "other_conditions")
    
    private String other_conditions;

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
    public String getOther_conditions() {
        return other_conditions;
    }

    public void setOther_conditions(String other_conditions) {
        this.other_conditions = other_conditions;
    }

    public String getPlay_leisure() {
        return play_leisure;
    }

    public void setPlay_leisure(String play_leisure) {
        this.play_leisure = play_leisure;
    }

    public String getScars_deforms() {
        return scars_deforms;
    }

    public void setScars_deforms(String scars_deforms) {
        this.scars_deforms = scars_deforms;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getVisual() {
        return visual;
    }

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public String getPerceptual() {
        return perceptual;
    }

    public void setPerceptual(String perceptual) {
        this.perceptual = perceptual;
    }

    public String getTactile() {
        return tactile;
    }

    public void setTactile(String tactile) {
        this.tactile = tactile;
    }

    public String getGastro() {
        return gastro;
    }

    public void setGastro(String gastro) {
        this.gastro = gastro;
    }

    public String getOlfactory() {
        return olfactory;
    }

    public void setOlfactory(String olfactory) {
        this.olfactory = olfactory;
    }

    public String getAuditory() {
        return auditory;
    }

    public void setAuditory(String auditory) {
        this.auditory = auditory;
    }

    public String getBody_alignment() {
        return body_alignment;
    }

    public void setBody_alignment(String body_alignment) {
        this.body_alignment = body_alignment;
    }

    public String getObservable_features() {
        return observable_features;
    }

    public void setObservable_features(String observable_features) {
        this.observable_features = observable_features;
    }

    public String getHair_col_dist() {
        return hair_col_dist;
    }

    public void setHair_col_dist(String hair_col_dist) {
        this.hair_col_dist = hair_col_dist;
    }

    public String getHead_circumference() {
        return head_circumference;
    }

    public void setHead_circumference(String head_circumference) {
        this.head_circumference = head_circumference;
    }


}