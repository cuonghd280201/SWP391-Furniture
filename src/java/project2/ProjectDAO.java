/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author cdkhu
 */
public class ProjectDAO {
    public List<ProjectDTO> listProject(String searchProjectName) throws SQLException{
        List<ProjectDTO> list = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "SELECT * FROM Project WHERE projectName like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchProjectName + "%");
                rs = stm.executeQuery();
                list = new ArrayList<>();
                LocalDateTime localdatetime = LocalDateTime.now();
                while(rs.next()){
                    int projectID = rs.getInt("projectID");
                    String projectName = rs.getString("projectName");
                    String scale = rs.getString("scale");
                    String description = rs.getString("description");
                    String image = rs.getString("image");
                    Timestamp createAt = rs.getTimestamp("createAt");
//                    Timestamp createAt = Timestamp.valueOf(localdatetime);
                    Timestamp updateAt = rs.getTimestamp("updateAt");
                    int status = rs.getInt("status");
                    double price = rs.getDouble("price");
                    int userID = rs.getInt("userID");
                    int projectTypeID = rs.getInt("projectTypeID");
                    
                    ProjectDTO dto = new ProjectDTO(projectID, projectName, scale, description, image, createAt, updateAt, status, price/100, userID, projectTypeID);
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
    
    public int getProjectByName(String projectName) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int checkStatus = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "SELECT * FROM Project WHERE projectName = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, projectName);
                rs = stm.executeQuery();
                if(rs.next()){
                    checkStatus = 1;
                }
            }
        }catch(Exception e){
            
        }finally{
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return checkStatus;
    }
    
    public int getCurrentCreatProjectByUserID(int userID, String projectName) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int projectID = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "SELECT projectID FROM Project WHERE userID = ? AND projectName = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, userID);
                stm.setString(2, projectName);
                rs = stm.executeQuery();
                if(rs.next()){
                    projectID = rs.getInt("projectID");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return projectID;
    }
    
    public int createProject(String projectName, String scale, String description, String image, Timestamp createAt, double price, int userID, int projectTypeID) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int createStatus = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                
                String sql = "INSERT INTO Project VALUES (?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, projectName);
                stm.setString(2, scale);
                stm.setString(3, description);
                stm.setString(4, image);
                stm.setTimestamp(5, createAt);
                stm.setTimestamp(6, null);
                stm.setInt(7, 1);
                stm.setDouble(8, price);
                stm.setInt(9, userID);
                stm.setInt(10, projectTypeID);
                int row = stm.executeUpdate();
                if(row > 0){
                    createStatus = 1;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return createStatus;
    }
}