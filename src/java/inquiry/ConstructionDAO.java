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
public class ConstructionDAO {
    
     public boolean removeContruction(int constructionID)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. make connection
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "DELETE FROM Construction Where constructionID = ?;";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, constructionID);
                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    
     public Construction geConstructionDetial(int constructionID)
            throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Construction result = null;
        try {
            //1. make connection
            connection = DBUtils.makeConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "SELECT constructionName, constructionDescription FROM Construction Where constructionID = ?";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, constructionID);
                //4. execute query
                rs = stm.executeQuery(); // do phia tren da nap roi nen ko can truyen them tham so de nap vao bo nho
                //5. process result
                if (rs.next()) {
                    // get recipe DTO info
                    String constructionName = rs.getString("constructionName");
                    String constructionDescription = rs.getString("constructionDescription");
                    
                    Construction recipeDto = new Construction(constructionName, constructionDescription);
                    result = recipeDto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    
     public boolean updateContruction(Construction construction, int constructionID)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1.  make connection
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "UPDATE Construction SET constructionName= ?, constructionDescription = ? WHERE (constructionID = ?);";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, construction.getConstructionName());
                stm.setString(2, construction.getConstructionDescription());
                stm.setInt(3, constructionID);
                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
     public boolean insertContruction(Construction construction)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1.  make connection
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "INSERT INTO Construction \n"
                        + "(constructionName,constructionDescription) \n"
                        + "    VALUES (?, ?);";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, construction.getConstructionName());
                stm.setString(2, construction.getConstructionDescription());
                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }


    private List<Construction> constructionDtoList;

    public List<Construction> getConstructionsDtoList() {
        return this.constructionDtoList;
    }

    public void loadAllContruction()
            throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        this.constructionDtoList = null;
        try {
            //1. make connection
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT constructionID, constructionName , constructionDescription FROM Construction";
                //3. create statement obj
                stm = con.createStatement();
                //4. execute query
                rs = stm.executeQuery(sql);
                //5 process result
                while (rs.next()) {
                    // get category DTO info
                    int constructionID = rs.getInt("constructionID");
                    String constructionName = rs.getString("constructionName");
                    String constructionDescription = rs.getString("constructionDescription");
                    Construction constructionDto = new Construction(constructionID, constructionName, constructionDescription);
                    // check categoryDto list not null
                    if (this.constructionDtoList == null) {
                        this.constructionDtoList = new ArrayList<>();
                    }// end check categoryDto list is null
                    // add to categoryDto list
                    this.constructionDtoList.add(constructionDto);
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
    }// end loadAllCategory functio

    public List<Construction> selectConstructionList() {
        List<Construction> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "SELECT * FROM [dbo].[Construction]";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Construction construction = new Construction(rs.getInt("constructionID"), rs.getString("constructionName"), rs.getString("constructionDescription"));
                list.add(construction);
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
