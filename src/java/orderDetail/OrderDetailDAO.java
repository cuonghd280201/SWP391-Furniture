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
}
