/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inquiry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class ScaleDAO {
    
      private List<Scale> scaleDtoList;
    public List<Scale> getScalesDtoList() {
        return this.scaleDtoList;
    }
     public void loadAllScale()
            throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        this.scaleDtoList = null;
        try {
            //1. make connection
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT scaleID, scaleName, scaleDescription FROM Scale";
                //3. create statement obj
                stm = con.createStatement();
                //4. execute query
                rs = stm.executeQuery(sql);
                //5 process result
                while (rs.next()) {                    
                    // get category DTO info
                    int scaleID = rs.getInt("scaleID");
                    String scaleName = rs.getString("scaleName");
                    String scaleDescription = rs.getString("scaleDescription");
                    Scale constructionDto = new Scale(scaleID, scaleName,scaleDescription);                                                            
                    // check categoryDto list not null
                    if (this.scaleDtoList == null) {
                        this.scaleDtoList = new ArrayList<>();
                    }// end check categoryDto list is null
                    // add to categoryDto list
                    this.scaleDtoList.add(constructionDto);
                }// end process rs
            }// end check con not null
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List<Scale> selectScaleList() {
        List<Scale> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "SELECT * FROM [dbo].[Scale]";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Scale scale = new Scale(rs.getInt("scaleID"), rs.getString("scaleName"), rs.getString("scaleDescription"));
                list.add(scale);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // In lỗi ra console để theo dõi và gỡ lỗi
        } finally {
            // Đóng tài nguyên trong khối finally để đảm bảo luôn được thực hiện, ngay cả khi có ngoại lệ xảy ra
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); // In lỗi ra console để theo dõi và gỡ lỗi
            }
        }
        return list;
    }

}
