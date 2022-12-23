/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zy.dao;

import com.zy.model.BookAndBookType;
import com.zy.model.BookType;
import com.zy.utils.DButils;
import java.util.List;

/**
 *
 * @author 物竞天择适者生存
 */
public class AdminDao {
/**
 * 查询该类别是否添加
 * @param bookTypeName
 * @return 
 */
    public List<BookType> selectBookTypeName(String bookTypeName) {
        String sql = "SELECT * FROM t_booktype WHERE bookTypeName = ? ";
        List<BookType> listBookType = DButils.jdbc_select(sql, BookType.class, bookTypeName);
        return listBookType;
    }
/**
 * 添加书籍类名
 * @param bookTypeName
 * @param bookTypeDesc 
 */
    public int addBookType(String bookTypeName, String bookTypeDesc) {
        String sql = "INSERT INTO t_booktype(bookTypeName,bookTypeDesc) VALUES(?,?)";
        int jdbc_update = DButils.jdbc_update(sql, bookTypeName,bookTypeDesc);
        return jdbc_update;
    }
    /**
     * 列出图书类型
     * @param bookTypeName
     * @return 
     */
    public List<BookType> listBookType(String bookTypeName) {
        String sql = "SELECT * FROM t_booktype WHERE bookTypeName LIKE ? ";
        List<BookType> bookTypeList = DButils.jdbc_select(sql, BookType.class, "%"+bookTypeName+"%");
        return bookTypeList;
    }
/**
 * 通过书籍编号修改书籍名称和描述
 * @param bookTypeId
 * @param bookTypeName
 * @param bookTypeDesc
 * @return 
 */
    public int updateBookTypeByTypeId(int bookTypeId, String bookTypeName, String bookTypeDesc) {
       String sql = "update t_booktype set bookTypeName = ? , bookTypeDesc = ? where id = ? ";
       int result = DButils.jdbc_update(sql, bookTypeName,bookTypeDesc,bookTypeId);
       return result;
    }
    /**
     * 删除书籍类型
     * @param bookTypeId
     * @return 
     */
    public int deleteBookType(int bookTypeId) {
        String sql = "delete  from t_booktype where id =  ? ";
        int result = DButils.jdbc_update(sql, bookTypeId);
        return result;
    }
    /**
     * 删除对应书籍类型的书
     * @param bookTypeId
     * @return 
     */
    public int deleteBooks(int bookTypeId) {
        String sql = "DELETE FROM t_book WHERE bookTypeId = ? ";
        int result = DButils.jdbc_update(sql, bookTypeId);
        return result;
    }
    /**
     * 通过书籍类型获得类型id
     * @param bookType
     * @return 
     */
    public int selectBookTypeId(String bookType) {
        String sql = "SELECT * FROM t_booktype WHERE bookTypeName = ? ";
        List<BookType> list = DButils.jdbc_select(sql, BookType.class, bookType);
        int bookId = list.get(0).getId();

        return bookId;
    }
    /**
     * 像书籍库中添加书籍
     * @param bookName
     * @param author
     * @param sex
     * @param price
     * @param bookDesc
     * @param bookTypeId
     * @param i
     * @return 
     */
    public int insertBook(String bookName, String author, String sex, float price, String bookDesc, int bookTypeId, int i) {
        String sql = "INSERT INTO t_book(bookName,author,sex,price,bookDesc,bookTypeId,isflag) \n" +
                        "VALUES(?,?,?,?,?,?,?)";
        int result = DButils.jdbc_update(sql, bookName,author,sex,price,bookDesc,bookTypeId,0);
        return result;
    }
/**
 * 
 * @param bookName
 * @param bookAuthor
 * @param bookType
 * @return 
 */
    public List<BookAndBookType> listBook(String bookName, String bookAuthor, String bookType) {
        String sql = "SELECT *\n" +
                    "FROM t_book\n" +
                    "INNER JOIN t_booktype\n" +
                    "ON t_book.`bookTypeId` = t_booktype.`id`\n" +
                    "WHERE bookName LIKE  ? \n" +
                    "AND author LIKE ? \n" +
                    "AND bookTypeName LIKE ? ";
       List<BookAndBookType> list=  DButils.jdbc_select(sql, BookAndBookType.class, "%"+bookName+"%","%"+bookAuthor+"%","%"+bookType+"%");        
        return list;
    }
    /**
     * 修改图书信息
     * @param bookId
     * @param bookName
     * @param bookAuthor
     * @param sex
     * @param bookPrice
     * @param bookDesc
     * @return 
     */

    /**
     * 修改图书信息
     * @param bookId
     * @param bookName
     * @param bookAuthor
     * @param sex
     * @param bookPrice
     * @param bookDesc
     * @return
     */
    public int updateBook(int bookId, String bookName, String bookAuthor, String sex, float bookPrice, String bookDesc,int bookTypeId) {
        String sql = "UPDATE t_book SET bookName = ? ,author = ? ,sex = ? ,price =  ? ,bookDesc = ? ,bookTypeId = ? \n" +
"WHERE id = ? ";
        int result = DButils.jdbc_update(sql, bookName,bookAuthor,sex,bookPrice,bookDesc,bookTypeId,bookId); 
        return result;
    }

    public int deleteBook(int bookId) {
        String sql = "DELETE FROM t_book WHERE id = ? ";
        int result = DButils.jdbc_update(sql, bookId);
        return result;
    }
    
  

}
