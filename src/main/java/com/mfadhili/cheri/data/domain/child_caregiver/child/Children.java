package com.mfadhili.cheri.data.domain.child_caregiver.child;

/**
 * Entity created for Children's record table in the database
 * The entity is related to Parents' record table
 * */

import com.mfadhili.cheri.data.domain.Gender;
import com.mfadhili.cheri.data.domain.child_caregiver.autism_record.Autism_record;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.child_caregiver.parent.Parents;

import javax.persistence.*;


import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "children")
public class Children {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    
    private String first_name;

    @Column(name = "last_name")
    
    private String last_name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "update_at")
    private LocalDate updateAt;

    @Column(name = "consent_form")
    private URL consent_form;

    /** Getters and setters*/
    public URL getConsent_form() {
        return consent_form;
    }

    public void setConsent_form(URL consent_form) {
        this.consent_form = consent_form;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** To String*/
    @Override
    public String toString() {
        return "Children{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender=" + gender +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                ", consent_form=" + consent_form +
                '}';
    }
}