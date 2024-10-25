package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Customer customer;

    private String content;

    // Getters và Setters
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", item=" + (item != null ? item.getName() : "null") +  // Lấy tên của item nếu không null
                ", customer=" + (customer != null ? customer.getUsername() : "null") +  // Lấy tên của customer nếu không null
                ", content='" + content + '\'' +
                '}';
    }
}
