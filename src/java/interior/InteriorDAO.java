/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interior;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;


public class InteriorDAO {
    
    public InteriorDTO getInteriorByID(int interiorID) throws SQLException{
        InteriorDTO dto = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{

            con = DBUtils.makeConnection();
            if(con != null){
                String sql = "SELECT * FROM Interior WHERE interiorID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, interiorID);
                rs = stm.executeQuery();
                if(rs.next()){
                    String interiorName = rs.getString("interiorName");
                    int size = rs.getInt("size");
                    int unit = rs.getInt("unit");
                    double mass = rs.getDouble("mass");
                    double unitPrice = rs.getDouble("unitPrice");
                    String description = rs.getString("description");
                    String image = rs.getString("image");
                    int projectID = rs.getInt("projectID");
                    Timestamp createAt = rs.getTimestamp("createAt");
                    Timestamp updateAt = rs.getTimestamp("updateAt");
                    int status = rs.getInt("status");
                    int marterialID = rs.getInt("marterialID");
                    dto = new InteriorDTO(interiorID, interiorName, size, unit, mass, unitPrice, 0.0, description, image, projectID, createAt, updateAt, status, marterialID);
                }
            }
        }catch(Exception e){
            
        }finally{
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return dto;
    }
    
    public List<InteriorDTO> getListInterior() throws SQLException{
        List<InteriorDTO> list = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.makeConnection();
            if(con != null){
                String sql = "SELECT * FROM Interior";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                list = new ArrayList<>();
                while(rs.next()){
                    int interiorID = rs.getInt("interiorID");
                    String interiorName = rs.getString("interiorName");
                    int size = rs.getInt("size");
                    int unit = rs.getInt("unit");
                    double mass = rs.getDouble("mass");
                    double unitPrice = rs.getDouble("unitPrice");
                    String description = rs.getString("description");
                    String image = rs.getString("image");
                    int projectID = rs.getInt("projectID");
                    Timestamp createAt = rs.getTimestamp("createAt");
                    Timestamp updateAt = rs.getTimestamp("updateAt");
                    int status = rs.getInt("status");
                    int marterialID = rs.getInt("materialID");
                    InteriorDTO dto = new InteriorDTO(interiorID, interiorName, size, unit, mass, unitPrice, 0.0, description, image, projectID, createAt, updateAt, status, marterialID);
                    list.add(dto);
                }
            }
        }catch(Exception e){
            
        }finally{
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return list;
    }
    
    public List<InteriorDTO> getListInteriorByName(String searchinteriorName) throws SQLException{
        List<InteriorDTO> list = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.makeConnection();
            if(con != null){
                String sql = "SELECT * FROM Interior WHERE interiorName like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%"+searchinteriorName+"%");
                rs = stm.executeQuery();
                list = new ArrayList<>();
                while(rs.next()){
                    int interiorID = rs.getInt("interiorID");
                    String interiorName = rs.getString("interiorName");
                    int size = rs.getInt("size");
                    int unit = rs.getInt("unit");
                    double mass = rs.getDouble("mass");
                    double unitPrice = rs.getDouble("unitPrice");
                    String description = rs.getString("description");
                    String image = rs.getString("image");
                    int projectID = rs.getInt("projectID");
                    Timestamp createAt = rs.getTimestamp("createAt");
                    Timestamp updateAt = rs.getTimestamp("updateAt");
                    int status = rs.getInt("status");
                    int marterialID = rs.getInt("marterialID");
                    InteriorDTO dto = new InteriorDTO(interiorID, interiorName, size, unit, mass, unitPrice, 0.0, description, image, projectID, createAt, updateAt, status, marterialID);
                    list.add(dto);
                }
            }
        }catch(Exception e){
            
        }finally{
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return list;
    }
    
    public int getInteriorByName(String interiorName) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int checkStatus = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "SELECT * FROM Interior WHERE interiorName = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, interiorName);
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
    
    public int createInterior(String interiorName, int size, double mass, double unitPrice, String desciprtion, String image, Timestamp createAt, int materialID) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int createStatus = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "INSERT INTO Interior VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, interiorName);
                stm.setInt(2, size);
                stm.setInt(3, 0);
                stm.setDouble(4, mass);
                stm.setDouble(5, unitPrice);
                stm.setDouble(6, 0.0);
                stm.setString(7, desciprtion);
                stm.setString(8, image);
                stm.setInt(9, 0);
                stm.setTimestamp(10, createAt);
                stm.setTimestamp(11, null);
                stm.setInt(12, 1);
                stm.setInt(13, materialID);
                int row = stm.executeUpdate();
                if(row > 0){
                    createStatus = 1;
                }
            }
        }catch(Exception e){
            
        }finally{
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return createStatus;
    }
    
    public int updateInterior(InteriorDTO interior) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int updateStatus = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "UPDATE Interior SET interiorName = ?, size = ?, mass = ?, unitPrice = ?, description = ?, image = ?, updateAt = ?, status = ?, marterialID = ? WHERE interiorID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, interior.getInteriorName());
                stm.setInt(2, interior.getSize());
                stm.setDouble(3, interior.getMass());
                stm.setDouble(4, interior.getUnitPrice());
                stm.setString(5, interior.getDescription());
                stm.setString(6, interior.getImage());
                stm.setTimestamp(7, interior.getUpdateAt());
                stm.setInt(8, interior.getStatus());
                stm.setInt(9, interior.getMaterialID());
                stm.setInt(10, interior.getInteriorID());
                int row = stm.executeUpdate();
                if(row > 0){
                    updateStatus = 1;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return updateStatus;
    }
}
