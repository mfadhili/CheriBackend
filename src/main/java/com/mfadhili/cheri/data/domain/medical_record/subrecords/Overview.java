package com.mfadhili.cheri.data.domain.medical_record.subrecords;
/**
 * This is an EMBEDDABLE entity supporting Medical records
 * This section will give an overview report regarding the medical record
 * The entity will be created in the DB as a separate child linked to the main medical record.
 * * */

import com.mfadhili.cheri.data.domain.medical_record.Medical_record;

import javax.persistence.*;


@Entity
@Table(name = "med_overview")
public class Overview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "feeding_eating")
    
    private String feeding_eating;

    @Column(name = "dx")
    
    private String dx;

    @Column(name = "problems_identified")
    
    private String problems_identified;

    @Column(name = "ot_issues")
    
    private String ot_issues;

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
    public String getOt_issues() {
        return ot_issues;
    }

    public void setOt_issues(String ot_issues) {
        this.ot_issues = ot_issues;
    }

    public String getProblems_identified() {
        return problems_identified;
    }

    public void setProblems_identified(String problems_identified) {
        this.problems_identified = problems_identified;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx;
    }

    public String getFeeding_eating() {
        return feeding_eating;
    }

    public void setFeeding_eating(String feeding_eating) {
        this.feeding_eating = feeding_eating;
    }
}