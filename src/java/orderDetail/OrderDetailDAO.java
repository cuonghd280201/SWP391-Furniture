/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class OrderDetailDAO {
    public int createOrderDetail(int interiorID, int projectID, int interiorQuantity, double interiorMoney, int status) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int createStatus = 0;
        try{
            con = DBUtils.makeConnection();
            if(con != null){
                String sql = "INSERT INTO OrderDetail VALUES (?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, interiorID);
                stm.setInt(2, projectID);
                stm.setInt(3, 0);
                stm.setInt(4, interiorQuantity);
                stm.setDouble(5, interiorMoney);
                stm.setInt(6, status);
                int row = stm.executeUpdate();
                if(row > 0){
                    createStatus = 1;
                }
            }
        }catch(Exception e){
            
        }finally{
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return createStatus;
    }
    
    public int changeOrderDetailStatus(int projectID, int status) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int updateStatus = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "UPDATE OrderDetail SET status = ? WHERE projectID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, status);
                stm.setInt(2, projectID);
                int row = stm.executeUpdate();
                if(row > 0){
                    updateStatus = 1;
                }
            }
        }catch(Exception e){
            
        }finally{
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return updateStatus;
    }
    
    public int changeOrderDetailQuantity(int projectID, int interiorID, int quantity) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int updateStatus = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "UPDATE OrderDetail SET interiorQuantity = ? WHERE projectID = ? AND interiorID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setInt(2, projectID);
                stm.setInt(3, interiorID);
                int row = stm.executeUpdate();
                if(row > 0){
                    updateStatus = 1;
                }
            }
        }catch(Exception e){
            
        }finally{
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return updateStatus;
    }
    
    public int removeOrderDetailInterior(int projectID, int interiorID) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int updateStatus = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "UPDATE OrderDetail SET status = ? WHERE projectID = ? AND interiorID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, 0);
                stm.setInt(2, projectID);
                stm.setInt(3, interiorID);
                int row = stm.executeUpdate();
                if(row > 0){
                    updateStatus = 1;
                }
            }
        }catch(Exception e){
            
        }finally{
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return updateStatus;
    }
}
