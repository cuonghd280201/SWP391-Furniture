/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author cdkhu
 */
public class ProjectDetailsDAO {
    public List<ProjectDetailsDTO> searchListProjectDetailsByName(String searchProjectName) throws SQLException{
        List<ProjectDetailsDTO> list = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "SELECT Project.projectID, Project.projectName, Project.scale, Project.description, Project.createAt, Project.updateAt, " +
                "Project.price, Project.userID, tblUser.firstName, tblUser.lastName, Project.projectTypeID, ProjectType.projectTypeName, Project.status " +
                "FROM Project " +
                "INNER JOIN ProjectType ON Project.projectTypeID = ProjectType.projectTypeID " +
                "INNER JOIN tblUser ON Project.userID = tblUser.userID " +
                "WHERE Project.projectName like ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchProjectName + "%");
                rs = stm.executeQuery();
                list = new ArrayList<>();
                while(rs.next()){
                    int projectID = rs.getInt("projectID");
                    String projectName = rs.getString("projectName");
                    String scale = rs.getString("scale");
                    String description = rs.getString("description");
                    Timestamp createAt = rs.getTimestamp("createAt");
                    Timestamp updateAt = rs.getTimestamp("updateAt");
                    double price = rs.getDouble("price");
                    int userID = rs.getInt("userID");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    int projectTypeID = rs.getInt("projectTypeID");
                    String projectTypeName = rs.getString("projectTypeName");
                    int status = rs.getInt("status");
                    
                    ProjectDetailsDTO dto = new ProjectDetailsDTO(projectID, projectName, scale, description, createAt, updateAt, price/100, userID, firstName, lastName, projectTypeID, projectTypeName, status);
                    list.add(dto);
                }
            }
        }catch(Exception e){
            
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
      
      return list;
    }
}
