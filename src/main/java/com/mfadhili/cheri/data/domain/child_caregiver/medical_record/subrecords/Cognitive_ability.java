package com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords;

/**
 * This is an EMBEDDABLE entity supporting Medical records
 * This section will hold Cognitive ability information regarding the medical record
 * The entity will be created in the DB as a separate child linked to the main medical record.
 * * */

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Cognitive_ability {
    @Column(name = "planning")
    
    private String planning;

    @Column(name = "memory")
    
    private String memory;

    @Column(name = "organisational")
    
    private String organisational;

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