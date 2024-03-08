/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quotation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import utils.DBUtils;

/**
 *
 * @author cdkhu
 */
public class QuotationDAO {
    public boolean CreateQuotation(int projectID, Timestamp startDate, Timestamp endDate, int status, int userID) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                LocalDateTime now = LocalDateTime.now();
                Timestamp local = Timestamp.valueOf(now);
                
                String sql = "INSERT INTO Quotation VALUES (?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, projectID);
                stm.setTimestamp(2, startDate);
                stm.setTimestamp(3, endDate);
                stm.setTimestamp(4, local);
                stm.setInt(5, status);
                stm.setInt(6, userID);
                int row = stm.executeUpdate();
                if(row > 0){
                    check = true;
                }
            }
            
        }catch(Exception e){
            
        }finally{
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return check;
    }
}
