package com.ecommerce.fyp.persistence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "InvoiceOrder")
public class InvoiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;

    public InvoiceOrder() {

    }

    public InvoiceOrder(Integer id, Product product, int quantity, double price, Invoice invoice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.invoice = invoice;
    }

    public InvoiceOrder(Product product, int quantity, double price, Invoice invoice) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.invoice = invoice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
