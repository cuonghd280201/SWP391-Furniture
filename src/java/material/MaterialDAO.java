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
                    dto = new MaterialDTO(materialID, materialName, vauleLevel, description);
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
    
    public List<MaterialDTO> getListMaterial() throws SQLException{
        List<MaterialDTO> list = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "SELECT * FROM Material";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                list = new ArrayList<>();
                while(rs.next()){
                    int materialID = rs.getInt("materialID");
                    String materialName = rs.getString("materialName");
                    double vauleLevel = rs.getDouble("valueLevel");
                    String description = rs.getString("desciprtion");
                    MaterialDTO dto = new MaterialDTO(materialID, materialName, vauleLevel, description);
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
