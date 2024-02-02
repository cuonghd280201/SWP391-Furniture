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
public class ScaleDAO {
    public List<Scale> selectConstructionList() {
        List<Scale> list = null;
        Connection con = DBUtils.getConnection();
        String sql;
        try {
            sql = "SELECT * from [dbo].[Scale]";
            PreparedStatement stm = con.prepareStatement(sql);
            //stm.setString(1, catelory);
            ResultSet rs = stm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Scale brandList = new Scale(rs.getInt("scaleID"), rs.getString("scaleName"), rs.getString("scaleDescription"));
                list.add(brandList);
            }
            con.close();
        } catch (SQLException ex) {
        }
        return list;
    }
    
}
