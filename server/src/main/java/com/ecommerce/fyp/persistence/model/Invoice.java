package com.ecommerce.fyp.persistence.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_ID")
    private Integer id;

    @Column(name = "Creation_date")
    private Date creationDate;

    @Column(name = "Customer_Name")
    private String name;

    @Column(name = "Customer_Address")
    private String address;

    @Column(name = "Customer_Phone_Number")
    private String phoneNumber;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceOrder> invoiceOrders;

    public Invoice() {

    }

    public Invoice(Integer id, Date creationDate, String name, String address, String phoneNumber, List<InvoiceOrder> invoiceOrders) {
        this.id = id;
        this.creationDate = creationDate;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.invoiceOrders = invoiceOrders;
    }

    public Invoice(Date creationDate, String name, String address, String phoneNumber, List<InvoiceOrder> invoiceOrders) {
        this.creationDate = creationDate;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.invoiceOrders = invoiceOrders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<InvoiceOrder> getOrders() {
        return invoiceOrders;
    }

    public void setOrders(List<InvoiceOrder> invoiceOrders) {
        this.invoiceOrders = invoiceOrders;
    }
}
