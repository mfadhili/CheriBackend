package com.mfadhili.cheri.data.domain.child_caregiver.caregiver;

import com.mfadhili.cheri.data.domain.Gender;

import javax.persistence.*;


@Entity
@Table(name = "caregiver")
public class Caregiver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    
    private String first_name;

    @Column(name = "last_name")
    
    private String last_name;

    @Column(name = "national_id")
    
    private String national_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    
    private Gender gender;

    @Column(name = "telephone")
    
    private String telephone;



    /** Getters and setters*/
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
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
        return "Caregiver{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", national_id='" + national_id + '\'' +
                ", gender=" + gender +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}