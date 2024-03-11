/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author cdkhu
 */
public class MaterialDAO {
    
    public MaterialDTO getMaterialByID(int materialID) throws SQLException{
        MaterialDTO dto = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "SELECT * FROM Material WHERE materialID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, materialID);
                rs = stm.executeQuery();
                if(rs.next()){
                    String materialName = rs.getString("materialName");
                    double vauleLevel = rs.getDouble("valueLevel");
                    String description = rs.getString("desciprtion");
                    int status = rs.getInt("status");
                    dto = new MaterialDTO(materialID, materialName, vauleLevel, description, status);
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
    
    public List<MaterialDTO> listMaterial(String searchMaterialName) throws SQLException{
        List<MaterialDTO> list = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "SELECT * FROM Material WHERE materialName like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchMaterialName + "%");
                rs = stm.executeQuery();
                list = new ArrayList<>();
                while(rs.next()){
                    int materialID = rs.getInt("materialID");
                    String materialName = rs.getString("materialName");
                    double vauleLevel = rs.getDouble("valueLevel");
                    String description = rs.getString("desciprtion");
                    int status = rs.getInt("status");
                    MaterialDTO dto = new MaterialDTO(materialID, materialName, vauleLevel, description, status);
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
    
    public int getMaterialByName(String materialName) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int checkStatus = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "SELECT * FROM Material WHERE materialName = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, materialName);
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
    
    public int createMaterial(String materialName, double valueLevel, String desciprtion) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int createStatus = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "INSERT INTO Material VALUES (?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, materialName);
                stm.setDouble(2, valueLevel);
                stm.setString(3, desciprtion);
                stm.setInt(4, 1);
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
    
    public int updateMaterial(MaterialDTO material) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int updateStatus = 0;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "UPDATE Material SET materialName = ?, valueLevel = ?, desciprtion = ?, status = ? WHERE materialID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, material.getMaterialName());
                stm.setDouble(2, material.getValueLevel());
                stm.setString(3, material.getDesciprtion());
                stm.setInt(4, material.getStatus());
                stm.setInt(5, material.getMaterialID());
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
