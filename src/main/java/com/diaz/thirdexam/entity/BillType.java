package com.diaz.thirdexam.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Diaz
 * @since 2019/1/30 14:31
 */
@Entity
@Table(name = "bill_type")
public class BillType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long value;
    @Column(name = "type_name")
    private String title;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, targetEntity = Bill.class, mappedBy = "id", fetch = FetchType.LAZY)
    private Set<Bill> bills = new HashSet<>();

    public BillType() {
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "BillType{" +
                "value=" + value +
                ", title='" + title + '\'' +
                ", bills=" + bills +
                '}';
    }
}
