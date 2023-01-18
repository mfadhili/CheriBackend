package com.mfadhili.cheri.data.domain.autism_record;

/**
 * With the help of collections the autism record is extended to have communication and Social records of the respective child.
 * Others_items also adds more information to the record, it is however a collection as well.
 * */


import javax.persistence.*;

import com.mfadhili.cheri.data.domain.autism_record.sub_records.Communication;
import com.mfadhili.cheri.data.domain.autism_record.sub_records.Other_items;
import com.mfadhili.cheri.data.domain.autism_record.sub_records.Social;
import org.hibernate.Hibernate;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "autism_record")
public class Autism_record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;



    /** Element collections */
    @ElementCollection
    @CollectionTable(name = "autism_record_communication", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<Communication> communication = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "autism_record_social", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<Social> social = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "autism_record_other_items", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<Other_items> other_items = new LinkedHashSet<>();


    /** getters and setters*/
    public Set<Other_items> getOther_items() {
        return other_items;
    }

    public void setOther_items(Set<Other_items> other_items) {
        this.other_items = other_items;
    }

    public Set<Social> getSocial() {
        return social;
    }

    public void setSocial(Set<Social> social) {
        this.social = social;
    }

    public Set<Communication> getCommunication() {
        return communication;
    }

    public void setCommunication(Set<Communication> communication) {
        this.communication = communication;
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
        Autism_record that = (Autism_record) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}