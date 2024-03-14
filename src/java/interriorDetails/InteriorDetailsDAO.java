/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interriorDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import projectDetails.ProjectDetailsDTO;
import utils.DBUtils;

/**
 *
 * @author cdkhu
 */
public class InteriorDetailsDAO {
    public List<InteriorDetailsDTO> listInteriorDetailsByProjectID(int projectID) throws SQLException{
        List<InteriorDetailsDTO> list = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "SELECT Interior.interiorID, Interior.interiorName, Interior.size, Interior.unit, Interior.mass, Interior.unitPrice, Interior.description, Interior.image, OrderDetail.projectID, " +
                "Interior.createAt, Interior.updateAt, OrderDetail.status, Interior.marterialID, Material.materialName, Material.valueLevel, OrderDetail.interiorQuantity, OrderDetail.interiorMoney " +
                "FROM Interior " +
                "INNER JOIN Material ON Interior.marterialID = Material.materialID " +
                "INNER JOIN OrderDetail ON Interior.interiorID = OrderDetail.interiorID " +
                "WHERE OrderDetail.projectID = ? AND OrderDetail.Status = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, projectID);
                stm.setInt(2, 1);
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
                    Timestamp createAt = rs.getTimestamp("createAt");
                    Timestamp updateAt = rs.getTimestamp("updateAt");
                    int status = rs.getInt("status");
                    int marterialD = rs.getInt("marterialID");
                    String materialName = rs.getString("materialName");
                    double valueLevel = rs.getDouble("valueLevel");
                    int interiorQuantity = rs.getInt("interiorQuantity");
                    double interiorMoney = rs.getDouble("interiorMoney");
                    
                    InteriorDetailsDTO dto = new InteriorDetailsDTO(interiorID, interiorName, size, unit, mass, unitPrice, description, image, projectID, createAt, updateAt, status, marterialD, materialName, valueLevel, interiorQuantity, interiorMoney);
                    list.add(dto);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
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
    
    public List<InteriorDetailsDTO> listInterior(String searchinteriorName) throws SQLException{
        List<InteriorDetailsDTO> list = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.makeConnection();
            if(con != null){
                String sql = "SELECT Interior.interiorID, Interior.interiorName, Interior.size, Interior.mass, Interior.unitPrice, Interior.description, Interior.image, " +
                             "Interior.createAt, Interior.updateAt, Interior.status, Interior.marterialID, Material.materialName, Material.valueLevel " +
                             "FROM Interior " +
                             "INNER JOIN Material ON Interior.marterialID = Material.materialID " +
                             "WHERE Interior.interiorName like ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%"+searchinteriorName+"%");
                rs = stm.executeQuery();
                list = new ArrayList<>();
                while(rs.next()){
                    int interiorID = rs.getInt("interiorID");
                    String interiorName = rs.getString("interiorName");
                    int size = rs.getInt("size");
                    double mass = rs.getDouble("mass");
                    double unitPrice = rs.getDouble("unitPrice");
                    String description = rs.getString("description");
                    String image = rs.getString("image");
                    Timestamp createAt = rs.getTimestamp("createAt");
                    Timestamp updateAt = rs.getTimestamp("updateAt");
                    int status = rs.getInt("status");
                    int marterialD = rs.getInt("marterialID");
                    String materialName = rs.getString("materialName");
                    double valueLevel = rs.getDouble("valueLevel");
                    
                    InteriorDetailsDTO dto = new InteriorDetailsDTO(interiorID, interiorName, size, 0, mass, unitPrice, description, image, 0, createAt, updateAt, status, marterialD, materialName, valueLevel, 0, 0.0);
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
    
    public InteriorDetailsDTO getInteriorByID(int interiorID) throws SQLException{
        InteriorDetailsDTO dto = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.makeConnection();
            if(con != null){
                String sql = "SELECT Interior.interiorID, Interior.interiorName, Interior.size, Interior.mass, Interior.unitPrice, Interior.description, Interior.image, " +
                             "Interior.createAt, Interior.updateAt, Interior.status, Interior.marterialID, Material.materialName, Material.valueLevel " +
                             "FROM Interior " +
                             "INNER JOIN Material ON Interior.marterialID = Material.materialID " +
                             "WHERE Interior.interiorID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, interiorID);
                rs = stm.executeQuery();
                if(rs.next()){
                    String interiorName = rs.getString("interiorName");
                    int size = rs.getInt("size");
                    double mass = rs.getDouble("mass");
                    double unitPrice = rs.getDouble("unitPrice");
                    String description = rs.getString("description");
                    String image = rs.getString("image");
                    Timestamp createAt = rs.getTimestamp("createAt");
                    Timestamp updateAt = rs.getTimestamp("updateAt");
                    int status = rs.getInt("status");
                    int marterialD = rs.getInt("marterialID");
                    String materialName = rs.getString("materialName");
                    double valueLevel = rs.getDouble("valueLevel");
                    dto = new InteriorDetailsDTO(interiorID, interiorName, size, 0, mass, unitPrice, description, image, 0, createAt, updateAt, status, marterialD, materialName, valueLevel, 1, 0.0);
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
}
