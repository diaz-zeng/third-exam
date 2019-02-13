package com.diaz.thirdexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Diaz
 * @since 2019/1/30 14:31
 *
 * 账单类型实体类
 */
@Entity
@Table(name = "bill_type")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class BillType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long value;
    @Column(name = "type_name")
    private String title;

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

}
