package com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords;
/**
 * This is an EMBEDDABLE entity supporting Medical records
 * This section will give an overview report regarding the medical record
 * The entity will be created in the DB as a separate child linked to the main medical record.
 * * */

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Overview {
    @Column(name = "feeding_eating")
    
    private String feeding_eating;

    @Column(name = "dx")
    
    private String dx;

    @Column(name = "problems_identified")
    
    private String problems_identified;

    @Column(name = "ot_issues")
    
    private String ot_issues;

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