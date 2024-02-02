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
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class PriceRangeDAO {
     public List<PriceRange> selectPriceRangeList() {
        List<PriceRange> list = null;
        Connection con = DBUtils.getConnection();
        String sql;
        try {
            sql = "SELECT * from [dbo].[PriceRange]";
            PreparedStatement stm = con.prepareStatement(sql);
            //stm.setString(1, catelory);
            ResultSet rs = stm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                PriceRange brandList = new PriceRange(rs.getInt("priceRangeID"), rs.getString("priceRangeName"), rs.getString("priceRangeDescription"));
                list.add(brandList);
            }
            con.close();
        } catch (SQLException ex) {
        }
        return list;
    }
    
}
