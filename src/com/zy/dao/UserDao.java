package com.zy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zy.model.Book;
import com.zy.model.BookAndBookType;
import com.zy.model.BookAndBorrow;
import com.zy.model.User;
import com.zy.utils.DButils;
import com.zy.utils.JDBCUtils;

public class UserDao {
        //登录方法
	public static List<User> login(String name, String pwd,String userid) {
		String sql = "select * from t_user where userName = ? and password = ? and userid = ?";
		List<User> jdbc_select = DButils.jdbc_select(sql, User.class, name, pwd,userid);// ����
		System.out.println(jdbc_select);

		return jdbc_select;

	}
        //注册方法
        public int reg(String name,String pwd){
            String sql = "INSERT INTO t_user(userName,PASSWORD,userid) VALUES(?,?,?) ";
            int jdbc_update = DButils.jdbc_update(sql, name,pwd,"0");
            return jdbc_update;
        }
        //表格初始化方法
        public List<BookAndBorrow> listBook(String userName){
                String sql = "SELECT t_book.id,bookName,author,btime FROM t_book\n" +
"INNER JOIN t_borrow\n" +
"ON t_book.id = t_borrow.bookid\n" +
"INNER JOIN t_user\n" +
"ON t_borrow.`userid` = t_user.`id`\n" +
"WHERE userName = ? \n" +
"AND btime IS NOT NULL\n" +
"AND rtime IS NULL ";
               
		PreparedStatement ps = null;
         
		ResultSet rs = null;
		Connection conn = null;
		conn = JDBCUtils.getConnection();
		List<BookAndBorrow> list = new ArrayList<BookAndBorrow>();
		try {
			ps = conn.prepareStatement(sql);
                        ps.setString(1, userName);
			rs = ps.executeQuery();
			while (rs.next()) {			
				String bookName = rs.getString("bookName");
				String author = rs.getString("author");
				Date rdate = rs.getDate("btime");
				BookAndBorrow book = new BookAndBorrow(bookName, author, rdate);
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, null, ps, conn);
		}
		return list;
        }
     //修改密码的方法
    public int updatePwd(String newpwd1, String name) {
        String sql ="UPDATE t_user SET PASSWORD = ? WHERE username = ? ";
        int i = DButils.jdbc_update(sql, newpwd1,name);
        return i;
    }
    //查询所有书籍
    public List<BookAndBookType> listAllBooks() {
        String sql = "select t_book.id,bookName,bookTypeName,author,price,bookDesc from t_book\n" +
"inner join t_booktype\n" +
"on t_book.`bookTypeId` = t_booktype.`id`";
            List<BookAndBookType> jdbc_select = DButils.jdbc_select(sql,BookAndBookType.class);
                
        return jdbc_select;
    }
    //查询书是否借出
    public List<Book> lookBook(int bookid){
        String sql = "SELECT * FROM t_book WHERE id = ? AND isflag = 1";
        List<Book> list = DButils.jdbc_select(sql, Book.class,bookid);
        return list;
    }
    //修改书籍标记  1代表借书,2代表还书
    public int updateBookIsFlag(int bookid,int type) {
        int result;
        if(type == 1){
            String sql = "UPDATE t_book SET isflag = 1 WHERE id = ?";
            result = DButils.jdbc_update(sql, bookid);
           
        }else{
            String sql = "UPDATE t_book SET isflag = 0 WHERE id = ?";
           result = DButils.jdbc_update(sql, bookid);
        }
        return result;
        
    }
     //像借书表中插入书籍
    public int insertBook(int userid, int bookid) {//这里面的是用户id而用户表里的是用户类型编号
        String sql = "insert into t_borrow(userid,bookid,btime) values(?,?,now())";
        int result = DButils.jdbc_update(sql, userid,bookid);
       return result;
    }
   /**
    * 通过用户名获取用户id
    * @param name
    * @return 
    */
    public int findId(String name){
        String sql = "SELECT * FROM t_user WHERE username = ? ";
        List<User> list = DButils.jdbc_select(sql, User.class, name);
        
        int id = list.get(0).getId();
        System.out.println(id);
        return id;
    }
    /**
     * 通过书名获取书籍Id
     * @param bookName
     * @return 
     */
    public int getBookId(String bookName) {
        String sql = "SELECT * FROM t_book WHERE bookName = ? ";
        List<Book> bookList = DButils.jdbc_select(sql, Book.class, bookName);
       for(Book book : bookList){
           System.out.println(book);
       }
        
        
        int bookId = bookList.get(0).getId();
        return bookId;
    }
    /**
     * 当读者还书时在借书表中对应位置增加还书时间
     * @param userId 用户名id
     * @param bookId 书籍id
     * @return 
     */
    public int updateRtime(int userId, int bookId) {
        String sql = "UPDATE t_borrow SET rtime = NOW() WHERE userid = ? AND bookid = ?";
        int result = DButils.jdbc_update(sql, userId,bookId);
        return result;
    }
    /**
     * 列出用户的借书历史
     * @param userId
     * @return 
     */
    public List<BookAndBorrow> listBookHistory(int userId) {
        //这里不能直接用DButils中的方法,因为牵涉到了类型转化的问题.
        String sql = "SELECT bookName,author,btime,rtime \n" +
                    "FROM t_book\n" +
                    "INNER JOIN t_borrow\n" +
                    "ON t_book.`id` = t_borrow.`bookid`\n" +
                    "WHERE userid = ? \n" +
                    "AND rtime IS NOT NULL";
               
		PreparedStatement ps = null;
         
		ResultSet rs = null;
		Connection conn = null;
		conn = JDBCUtils.getConnection();
		List<BookAndBorrow> listHistory = new ArrayList<BookAndBorrow>();
		try {
			ps = conn.prepareStatement(sql);
                        ps.setInt(1, userId);
                        //ps.setString(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {			
				String bookName = rs.getString("bookName");
				String author = rs.getString("author");                          
				Date bdate = rs.getDate("btime");
                                Date rtime = rs.getDate("rtime");
				BookAndBorrow book = new BookAndBorrow(bookName, author, bdate,rtime);
				listHistory.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, null, ps, conn);
		}
		return listHistory;
        
    }
/**
 * 列出自己没有的书
 * @return 
 */
    public List<Book> listNoHaveBooks() {
        
		String sql = "SELECT id,bookName,author,sex,price,bookDesc\n" +
"FROM t_book\n" +
"WHERE isflag = 0";
         List<Book> listBook = DButils.jdbc_select(sql, Book.class);
        return listBook;
        
    }

   
    

    

}
