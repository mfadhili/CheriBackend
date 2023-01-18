package com.mfadhili.cheri.data.domain.medical_record.subrecords;

/**
 * This is an EMBEDDABLE entity supporting Medical records
 * This section will hold Cognitive ability information regarding the medical record
 * The entity will be created in the DB as a separate child linked to the main medical record.
 * * */

import com.mfadhili.cheri.data.domain.medical_record.Medical_record;

import javax.persistence.*;

@Entity
@Table(name = "med_cognitive")
public class Cognitive_ability {
    @Column(name = "planning")
    
    private String planning;

    @Column(name = "memory")
    
    private String memory;

    @Column(name = "organisational")
    
    private String organisational;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

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
    public String getOrganisational() {
        return organisational;
    }

    public void setOrganisational(String organisational) {
        this.organisational = organisational;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getPlanning() {
        return planning;
    }

    public void setPlanning(String planning) {
        this.planning = planning;
    }
}