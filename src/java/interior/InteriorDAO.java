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
/**
 *
 * @author Admin
 */
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
                    dto = new InteriorDTO(interiorID, interiorName, size, unit, mass, unitPrice, description, image, projectID, createAt, updateAt, status, marterialID);
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
                    InteriorDTO dto = new InteriorDTO(interiorID, interiorName, size, unit, mass, unitPrice, description, image, projectID, createAt, updateAt, status, marterialID);
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
                    InteriorDTO dto = new InteriorDTO(interiorID, interiorName, size, unit, mass, unitPrice, description, image, projectID, createAt, updateAt, status, marterialID);
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
    
}
