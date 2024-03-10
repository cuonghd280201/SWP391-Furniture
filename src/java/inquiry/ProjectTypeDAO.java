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
public class ProjectTypeDAO {

    private List<ProjectType> projectTypeDtoList;

    public List<ProjectType> getProjectTypesDtoList() {
        return this.projectTypeDtoList;
    }

    public void loadAllProjectType()
            throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        this.projectTypeDtoList = null;
        try {
            //1. make connection
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT projectTypeID, projectTypeName, status FROM ProjectType";
                //3. create statement obj
                stm = con.createStatement();
                //4. execute query
                rs = stm.executeQuery(sql);
                //5 process result
                while (rs.next()) {
                    // get category DTO info
                    int projectTypeID = rs.getInt("projectTypeID");
                    String projectTypeName = rs.getString("projectTypeName");
                    String status = rs.getString("status");
                    ProjectType projectTypeDto = new ProjectType(projectTypeID, projectTypeName, status);
                    // check categoryDto list not null
                    if (this.projectTypeDtoList == null) {
                        this.projectTypeDtoList = new ArrayList<>();
                    }// end check categoryDto list is null
                    // add to categoryDto list
                    this.projectTypeDtoList.add(projectTypeDto);
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

    public List<ProjectType> selectProjectTypeList() {
        List<ProjectType> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "SELECT * FROM [dbo].[ProjectType]";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                ProjectType projectType = new ProjectType(rs.getInt("projectTypeID"), rs.getString("projectTypeName"), rs.getString("status"));
                list.add(projectType);
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
