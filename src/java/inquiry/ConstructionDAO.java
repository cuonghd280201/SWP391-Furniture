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
public class ConstructionDAO {
    
  public List<Construction> selectConstructionList() {
        List<Construction> list = null;
        Connection con = DBUtils.getConnection();
        String sql;
        try {
            sql = "SELECT * from [dbo].[Construction]";
            PreparedStatement stm = con.prepareStatement(sql);
            //stm.setString(1, catelory);
            ResultSet rs = stm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Construction brandList = new Construction(rs.getInt("constructionID"), rs.getString("constructionName"), rs.getString("constructionDescription"));
                list.add(brandList);
            }
            con.close();
        } catch (SQLException ex) {
        }
        return list;
    }
    
}
