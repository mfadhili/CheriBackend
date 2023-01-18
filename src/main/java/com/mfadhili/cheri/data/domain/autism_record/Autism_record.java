package com.mfadhili.cheri.data.domain.autism_record;

/**
 * With the help of collections the autism record is extended to have communication and Social records of the respective child.
 * Others_items also adds more information to the record, it is however a collection as well.
 * */


import javax.persistence.*;

import com.mfadhili.cheri.data.domain.Admin_Home.caregiver.Caregiver;
import com.mfadhili.cheri.data.domain.autism_record.sub_records.Communication;
import com.mfadhili.cheri.data.domain.autism_record.sub_records.Other_items;
import com.mfadhili.cheri.data.domain.autism_record.sub_records.Social;
import com.mfadhili.cheri.data.domain.child_guardian.child.Children;
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

    @ManyToOne
    @JoinColumn(name = "children_id")
    private Children children;

    @ManyToOne
    @JoinColumn(name = "caregiver_id")
    private Caregiver caregiver;

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
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