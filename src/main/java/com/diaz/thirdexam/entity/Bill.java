package com.diaz.thirdexam.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Diaz
 * @since 2019/1/30 14:31
 */
@Entity
@Table(name = "bill")
public class Bill implements Serializable {

    @Id
    @Column(name = "bill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bill_title")
    private String title;
    @Column(name = "bill_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
    @ManyToOne(targetEntity = BillType.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "bill_type_value", referencedColumnName = "type_id")
    @NotNull
    private BillType type;
    @Column(name = "bill_price")
    private Float price;
    @Column(name = "bill_explain")
    private String explain;

    public Bill() {
    }

    public Bill(String title, Date date, BillType type, Float price, String explain) {
        this.title = title;
        this.date = date;
        this.type = type;
        this.price = price;
        this.explain = explain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BillType getType() {
        return type;
    }

    public void setType(BillType type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", type=" + type.getTitle() +
                ", price=" + price +
                ", explain='" + explain + '\'' +
                '}';
    }
}
