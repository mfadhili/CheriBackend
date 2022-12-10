package com.mfadhili.cheri.data.domain.Admin_Home;

import javax.persistence.*;
import jakarta.validation.constraints.Email;


import java.time.LocalDate;

@Entity
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "home_name")
    
    private String home_name;

    @Column(name = "home_email")
    
    @Email
    private String home_email;

    @Column(name = "created_at")
    
    private LocalDate createdAt;

    @Column(name = "updated_at")
    
    private LocalDate updatedAt;

    @Column(name = "telephone")
    
    private String telephone;

    /** Getters and setters*/
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getHome_email() {
        return home_email;
    }

    public void setHome_email(String home_email) {
        this.home_email = home_email;
    }

    public String getHome_name() {
        return home_name;
    }

    public void setHome_name(String home_name) {
        this.home_name = home_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** To string*/
    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", home_name='" + home_name + '\'' +
                ", home_email='" + home_email + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}