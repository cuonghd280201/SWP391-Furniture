/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public int countAllProjects() {
        int numberOfOrders = 0;
        String query = "SELECT COUNT(*) AS NumberOfOrders FROM OrderDetail";
        try (Connection con = DBUtils.makeConnection();
                PreparedStatement stm = con.prepareStatement(query);
                ResultSet rs = stm.executeQuery()) {

            if (rs.next()) {
                numberOfOrders = rs.getInt("NumberOfOrders");
            }

        } catch (SQLException ex) {
            // Improve error logging here
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, "Error counting users", ex);
        }
        return numberOfOrders;
    }
}
