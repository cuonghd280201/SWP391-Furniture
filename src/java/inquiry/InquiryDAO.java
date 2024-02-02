/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inquiry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class InquiryDAO {

    public boolean create(Inquiry inquiry) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("insert into Inquiry values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stm.setInt(1, inquiry.getInquiryID());
            stm.setInt(2, inquiry.getProjectID());
            stm.setString(3, inquiry.getUserID());
            stm.setInt(4, inquiry.getStatus());
            stm.setString(5, inquiry.getCreateAt());
            stm.setString(6, inquiry.getUpdateAt());
            stm.setString(7, inquiry.getDescription());
            stm.setInt(8, inquiry.getConstructionID());
            stm.setInt(9, inquiry.getScaleID());
            stm.setInt(10, inquiry.getPriceRangeID());
            stm.setInt(11, inquiry.getProjectTypeID());
            int count = stm.executeUpdate();
            if (count == 0) {
                result = false;
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

}
