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
                String sql = "SELECT Interior.interiorID, Interior.interiorName, Interior.size, Interior.unit, Interior.mass, Interior.unitPrice, Interior.money, Interior.description, " +
                "Interior.image, Interior.projectID, Interior.createAt, Interior.updateAt, Interior.status, Interior.marterialD, Material.materialName, Material.price " +
                "FROM Interior INNER JOIN Material ON Interior.marterialD = Material.materialID " +
                "WHERE Interior.projectID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, projectID);
                rs = stm.executeQuery();
                list = new ArrayList<>();
                while(rs.next()){
                    int interiorID = rs.getInt("interiorID");
                    String interiorName = rs.getString("interiorName");
                    int size = rs.getInt("size");
                    int unit = rs.getInt("unit");
                    double mass = rs.getDouble("mass");
                    double unitPrice = rs.getDouble("unitPrice");
                    double money = rs.getDouble("money");
                    String description = rs.getString("description");
                    String image = rs.getString("image");
                    Timestamp createAt = rs.getTimestamp("createAt");
                    Timestamp updateAt = rs.getTimestamp("updateAt");
                    int status = rs.getInt("status");
                    int marterialD = rs.getInt("marterialD");
                    String materialName = rs.getString("materialName");
                    double price = rs.getDouble("price");
                    
                    InteriorDetailsDTO dto = new InteriorDetailsDTO(interiorID, interiorName, size, unit, mass, unitPrice, money, description, image, projectID, createAt, updateAt, status, marterialD, materialName, price);
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
