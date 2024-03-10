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
public class PriceRangeDAO {
    
    
    private List<PriceRange> priceRangeDtoList;
    public List<PriceRange> getPriceRangesDtoList() {
        return this.priceRangeDtoList;
    }
     public void loadAllPriceRange()
            throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        this.priceRangeDtoList = null;
        try {
            //1. make connection
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT priceRangeID, priceRangeName, priceRangeDescription FROM PriceRange";
                //3. create statement obj
                stm = con.createStatement();
                //4. execute query
                rs = stm.executeQuery(sql);
                //5 process result
                while (rs.next()) {                    
                    // get category DTO info
                    int priceRangeID = rs.getInt("priceRangeID");
                    String priceRangeName = rs.getString("priceRangeName");
                    String priceRangeDescription = rs.getString("priceRangeDescription");
                    PriceRange priceRangeDto = new PriceRange(priceRangeID, priceRangeName,priceRangeDescription);                                                            
                    // check categoryDto list not null
                    if (this.priceRangeDtoList == null) {
                        this.priceRangeDtoList = new ArrayList<>();
                    }// end check categoryDto list is null
                    // add to categoryDto list
                    this.priceRangeDtoList.add(priceRangeDto);
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
    }// end loadAllCategory

    public List<PriceRange> selectPriceRangeList() {
        List<PriceRange> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "SELECT * FROM [dbo].[PriceRange]";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                PriceRange priceRange = new PriceRange(rs.getInt("priceRangeID"), rs.getString("priceRangeName"), rs.getString("priceRangeDescription"));
                list.add(priceRange);
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
