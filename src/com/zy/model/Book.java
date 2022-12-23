/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zy.model;

/**
 *书籍类
 * @author 物竞天择适者生存
 */
public class Book {
    private int id;
    private String bookName;
    private String author;
    private String sex;
    private float price;
    private String bookDesc;
    private int bookTypeId;
    private int isflag;

    public Book() {
    }

    public Book(int id, String bookName, String author, String sex, float price, String bookDesc, int bookTypeId, int isflag) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.sex = sex;
        this.price = price;
        this.bookDesc = bookDesc;
        this.bookTypeId = bookTypeId;
        this.isflag = isflag;
    }
    public Book(int id, String bookName, String author, float price, String bookDesc){
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.bookDesc = bookDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public int getIsflag() {
        return isflag;
    }

    public void setIsflag(int isflag) {
        this.isflag = isflag;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", bookName=" + bookName + ", author=" + author + ", sex=" + sex + ", price=" + price + ", bookDesc=" + bookDesc + ", bookTypeId=" + bookTypeId + ", isflag=" + isflag + '}';
    }
    
    
}
