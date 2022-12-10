package com.mfadhili.cheri.data.domain.child_caregiver.medical_record;

/** Due to Medical_record having many fields, the Entity has been broken into several collections
 *  The collections are drawn from sub records found in  a subpackage within the current directory.
 * */


import javax.persistence.*;

import com.mfadhili.cheri.data.domain.child_caregiver.caregiver.Caregiver;
import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.*;
import org.hibernate.Hibernate;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "medical_record")
public class Medical_record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /** Element collections*/
    @ElementCollection
    @CollectionTable(name = "medical_record_summary", joinColumns = @JoinColumn(name = "owner_id"))
    @Column(name = "summary")
    private Set<Summary> summary = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "medical_record_occup_therapy", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<Occup_therapy> occup_therapy = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "medical_record_cognitive_ability", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<Cognitive_ability> cognitive_ability = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "medical_record_personal_history", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<Personal_history> personal_history = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "medical_record_physique", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<Physique> physique = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "medical_record_activity", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<Activity> activity = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "medical_record_overview", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<Overview> overview = new LinkedHashSet<>();

    /** Relationship to children main record*/
    @ManyToOne
    @JoinColumn(name = "children_id")
    private Children children_id;

    /** The relationship to caregiver who will make the record*/
    @ManyToOne
    @JoinColumn(name = "caregiver_id")
    private Caregiver caregiver;

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public Children getChildren_id() {
        return children_id;
    }

    public void setChildren_id(Children children_id) {
        this.children_id = children_id;
    }


    /** Getters and setters*/
    public Set<Overview> getOverview() {
        return overview;
    }

    public void setOverview(Set<Overview> overview) {
        this.overview = overview;
    }

    public Set<Activity> getActivity() {
        return activity;
    }

    public void setActivity(Set<Activity> activity) {
        this.activity = activity;
    }

    public Set<Physique> getPhysique() {
        return physique;
    }

    public void setPhysique(Set<Physique> physique) {
        this.physique = physique;
    }

    public Set<Personal_history> getPersonal_history() {
        return personal_history;
    }

    public void setPersonal_history(Set<Personal_history> personal_history) {
        this.personal_history = personal_history;
    }

    public Set<Cognitive_ability> getCognitive_ability() {
        return cognitive_ability;
    }

    public void setCognitive_ability(Set<Cognitive_ability> cognitive_ability) {
        this.cognitive_ability = cognitive_ability;
    }

    public Set<Occup_therapy> getOccup_therapy() {
        return occup_therapy;
    }

    public void setOccup_therapy(Set<Occup_therapy> occup_therapy) {
        this.occup_therapy = occup_therapy;
    }

    public Set<Summary> getSummary() {
        return summary;
    }

    public void setSummary(Set<Summary> summary) {
        this.summary = summary;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Medical_record that = (Medical_record) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}