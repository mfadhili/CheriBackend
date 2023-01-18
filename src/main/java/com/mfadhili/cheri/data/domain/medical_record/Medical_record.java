package com.mfadhili.cheri.data.domain.medical_record;

/** Due to Medical_record having many fields, the Entity has been broken into several collections
 *  The collections are drawn from sub records found in  a subpackage within the current directory.
 * */


import javax.persistence.*;

import com.mfadhili.cheri.data.domain.Admin_Home.caregiver.Caregiver;
import com.mfadhili.cheri.data.domain.child_guardian.child.Children;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "medical_record")
public class Medical_record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /** Relationship to sub records*/


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