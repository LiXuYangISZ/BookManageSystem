/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zy.view.user;

import com.zy.dao.UserDao;
import com.zy.model.BookAndBorrow;
import com.zy.utils.LoginConfig;
import com.zy.utils.StringUtil;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *我的书架界面
 * @author 物竞天择适者生存
 */
public class MyBookShelfFrm extends javax.swing.JFrame {

    /**
     * Creates new form MyBook
     */
    public MyBookShelfFrm() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bookNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        authorTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btimeTxt = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("我的书架");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "编号", "书名", "作者", "借书日期"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("书名");

        bookNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookNameTxtActionPerformed(evt);
            }
        });

        jLabel2.setText("作者");

        jLabel3.setText("借书日期");

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/归还.png"))); // NOI18N
        backBtn.setText("归还");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bookNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(btimeTxt))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41)
                        .addComponent(authorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(backBtn)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bookNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(authorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(backBtn)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookNameTxtActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // 点击表格行显示事件处理
        MyBookMousePressed(evt);
    }//GEN-LAST:event_jTable1MousePressed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // 归还书籍
        int row = jTable1.getRowCount();//获取用户书籍中的书籍数量
        if(row>0){
            this.backBtn.setEnabled(true);
            returnBook();//执行还书操作
        }else{
            JOptionPane.showMessageDialog(null, "对不起,您没有要还的书籍");
            this.backBtn.setEnabled(false);   
        }
        
    }//GEN-LAST:event_backBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyBookShelfFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyBookShelfFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyBookShelfFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyBookShelfFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyBookShelfFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorTxt;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField bookNameTxt;
    private javax.swing.JTextField btimeTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private  UserDao userDao = new UserDao();
    /**
     * 表格的初始化
     */
        private void initTable() {
       
                
        DefaultTableModel dtm =  (DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);//设置0行
        //查询出书籍
        String userName = LoginConfig.reader().get(0);
        List<BookAndBorrow> list =  userDao.listBook(userName);
        for(BookAndBorrow book : list){//向表格里面添加数据
            Vector v = new Vector<>();
            v.add(dtm.getRowCount()+1);
            v.add(book.getBookName());
            v.add(book.getAuthor());
            v.add(book.getBtime());
            dtm.addRow(v);
        }
    }

    private void init() {
        initTable();
        //禁用对书籍介绍的标签
        this.authorTxt.setEditable(false);
        this.bookNameTxt.setEditable(false);
        this.btimeTxt.setEditable(false);
    }
/**
 * 点击表格进行编辑
 * @param evt 
 */
    private void MyBookMousePressed(MouseEvent evt) {
        int row = jTable1.getSelectedRow(); //获得行号
        bookNameTxt.setText((String)jTable1.getValueAt(row, 1));
        authorTxt.setText((String)jTable1.getValueAt(row, 2));
        //btimeTxt.setText((String)jTable1.getValueAt(row, 3));
        btimeTxt.setText(String.format("%tY-%<tm-%<td", (Date)jTable1.getValueAt(row, 3)));
    }
    //在插入还书日期的过程中不必担心有多个记录,数据库会自动寻找符合条件的进行插入即使多行也没影响.
    /**
     * 归还书籍
     * 思路:1把book表中的isflag改成0
     *      2.在借书表中对应处插入一个还书日期
     */
    private void returnBook() {
        String bookName = this.bookNameTxt.getText(); 
        System.out.println("-----------"+bookName);
        if(StringUtil.isEmpty(bookName)){//如果没选中则给与提示
            JOptionPane.showMessageDialog(null, "请选择你要借阅的书籍!");
        }else{
            System.out.println("aaaaa");     
            int bookId = userDao.getBookId(bookName);
            System.out.println("sssssssss");
            String userName = LoginConfig.reader().get(0);
            int userId = userDao.findId(userName);
            int i = userDao.updateBookIsFlag(bookId,2);//还书
            if(i>0){
                int j = userDao.updateRtime(userId,bookId);
                if(j>0){
                    JOptionPane.showMessageDialog(null, "还书成功!");
                    initTable();
                    reset();
                }else{
                    JOptionPane.showMessageDialog(null, "还书失败!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "还书失败!");
            }
        }
        
    }

    private void reset() {
        this.bookNameTxt.setText("");
        this.authorTxt.setText("");
        this.btimeTxt.setText("");
        
    }


}

