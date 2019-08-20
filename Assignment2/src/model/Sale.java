package model;

import javax.swing.*;
import java.sql.Date;
import java.util.Observable;
import java.util.Observer;

public class Sale extends EntityObject  {
    private Book book;
    private Date sellingDate;
    private Integer quantity;
    private Double price;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
