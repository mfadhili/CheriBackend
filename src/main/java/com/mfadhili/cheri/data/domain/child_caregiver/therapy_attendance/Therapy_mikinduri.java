package com.mfadhili.cheri.data.domain.child_caregiver.therapy_attendance;

import com.mfadhili.cheri.data.domain.child_caregiver.caregiver.Caregiver;

import javax.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "therapy_meru")
public class Therapy_mikinduri {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "therapy_conditions")
    
    private Therapy_conditions therapy_conditions;

    @Column(name = "date")
    
    private LocalDate date;

    @Column(name = "time")
    
    private LocalTime time;

    @Enumerated
    @Column(name = "gross_motor")
    
    private session_results gross_motor;

    @Enumerated
    @Column(name = "fine_motor")
    
    private session_results fine_motor;

    @Enumerated
    @Column(name = "sensory")
    
    private session_results sensory;

    @Enumerated
    @Column(name = "adls")
    
    private session_results adls;

    @Column(name = "comments")
    
    private String comments;

   /** Connection to care giver*/
    @ManyToOne
    @JoinColumn(name = "caregiver_id")
    private Caregiver caregiver;

    /** getters and setters*/
    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public session_results getAdls() {
        return adls;
    }

    public void setAdls(session_results adls) {
        this.adls = adls;
    }

    public session_results getSensory() {
        return sensory;
    }

    public void setSensory(session_results sensory) {
        this.sensory = sensory;
    }

    public session_results getFine_motor() {
        return fine_motor;
    }

    public void setFine_motor(session_results fine_motor) {
        this.fine_motor = fine_motor;
    }

    public session_results getGross_motor() {
        return gross_motor;
    }

    public void setGross_motor(session_results gross_motor) {
        this.gross_motor = gross_motor;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Therapy_conditions getTherapy_conditions() {
        return therapy_conditions;
    }

    public void setTherapy_conditions(Therapy_conditions therapy_conditions) {
        this.therapy_conditions = therapy_conditions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}