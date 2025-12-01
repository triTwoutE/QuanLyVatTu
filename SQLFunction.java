/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyvattu;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author colan
 */

//Day la cac cau lenh thuc hien voi co so du lieu

public class SQLFunction {
    public List<VatTu> getAllVatTu() throws SQLException {
        //ketnoi voi db
        Connection conn = JDBCConnection.getConnection();
        String sql = "SELECT * FROM KhoVatTu";
        
        
        List<VatTu> vattus = new ArrayList<>();
        
        PreparedStatement preparedstatement = conn.prepareStatement(sql);
        ResultSet rs = preparedstatement.executeQuery();
        while(rs.next()){
            VatTu vattu = new VatTu();
            vattu.setId(rs.getString("Id"));
            vattu.setName(rs.getString("Name"));
            vattu.setAmount(rs.getInt("Amount"));
            vattu.setUnit(rs.getString("Unit"));
            vattu.setCategory(rs.getString("Category"));
            vattus.add(vattu);
        }
        return vattus;
        
    }
    
    public VatTu getVattuById(String id) {        
        try {
            Connection conn = JDBCConnection.getConnection();
            String sql = "SELECT * FROM KhoVatTu WHERE ID = ?";
            PreparedStatement preparedstatement = conn.prepareStatement(sql);
            preparedstatement.setString(1,id);
            ResultSet rs = preparedstatement.executeQuery();
            VatTu vattu = new VatTu();
            while(rs.next()){
                vattu.setId(rs.getString("Id"));
                vattu.setName(rs.getString("Name"));
                vattu.setAmount(rs.getInt("Amount"));
                vattu.setUnit(rs.getString("Unit"));
                vattu.setCategory(rs.getString("Category"));
            }
            return vattu;
        } catch (SQLException ex) {
            System.getLogger(SQLFunction.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
    
    public boolean existsById(String id){
        try {
            Connection conn = JDBCConnection.getConnection();
            String sql = "SELECT * FROM KhoVatTu WHERE ID = ?";
            PreparedStatement preparedstatement = conn.prepareStatement(sql);
            preparedstatement.setString(1,id);
            ResultSet rs = preparedstatement.executeQuery();
            return rs.next(); 
        } catch (SQLException ex) {
            System.getLogger(SQLFunction.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
    
    public void addVatTu(VatTu vattu){
        try {
            Connection conn = JDBCConnection.getConnection();
            String sql = "INSERT INTO project_java.KhoVatTu(Id, Name, Amount, Unit, Category) VALUES (?,?,?,?,?)";
            PreparedStatement preparedstatement = conn.prepareStatement(sql);
            preparedstatement.setString(1,vattu.getId());
            preparedstatement.setString(2,vattu.getName());
            preparedstatement.setInt(3,vattu.getAmount());
            preparedstatement.setString(4,vattu.getUnit());
            preparedstatement.setString(5,vattu.getCategory());
            int rs = preparedstatement.executeUpdate();
            //System.out.println(rs);
        } catch (SQLException ex) {
            System.getLogger(SQLFunction.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
            
        }
    
    public void delVatTu(String id){
        try {
            Connection conn = JDBCConnection.getConnection();
            String sql = "DELETE FROM KhoVatTu WHERE Id = ?";
            PreparedStatement preparedstatement = conn.prepareStatement(sql);
            preparedstatement.setString(1,id);
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(SQLFunction.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public void updateVatTu(VatTu vattu){
        try {
            Connection conn = JDBCConnection.getConnection();
            String sql = "UPDATE KhoVatTu SET Name = ?, Amount = ?, Unit = ?, Category = ? WHERE Id = ?";
            PreparedStatement preparedstatement = conn.prepareStatement(sql);
            preparedstatement.setString(1,vattu.getName());
            preparedstatement.setInt(2,vattu.getAmount());
            preparedstatement.setString(3,vattu.getUnit());
            preparedstatement.setString(4,vattu.getCategory());
            preparedstatement.setString(5,vattu.getId());
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(SQLFunction.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    
    
    public void closeVattu(){
        try {
            Connection conn = JDBCConnection.getConnection();
            conn.close();
        } catch (SQLException ex) {
            System.getLogger(SQLFunction.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
