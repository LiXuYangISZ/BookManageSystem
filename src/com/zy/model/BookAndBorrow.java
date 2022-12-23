/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zy.model;

import java.util.Date;

/**
 *
 * @author 物竞天择适者生存
 */
public class BookAndBorrow {
    private int id;
    private String bookName;
    private String author;
    private String sex;
    private float price;
    private String bookDesc;
    private int bookTypeId;
    private int isflag;
     private int id2;
    private int userid;
    private int bookid;
    private Date btime;
    private Date rtime;

    public BookAndBorrow() {
    }
    

    public BookAndBorrow(int id, String bookName, String author, Date btime) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.btime = btime;
    }

    public BookAndBorrow(String bookName, String author, Date btime) {
        this.bookName = bookName;
        this.author = author;
        this.btime = btime;
    }
    public BookAndBorrow(String bookName,String author,Date btime,Date rtime){
        this.bookName = bookName;
        this.author = author;
        this.btime = btime;
        this.rtime = rtime;
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

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }
    
    
    
}
