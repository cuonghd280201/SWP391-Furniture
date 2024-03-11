/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectType;

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
public class ProjectTypeDAO {
    
//    private List<ProjectTypeDTO> listProjectType;
//    
//    public List<ProjectTypeDTO> getlistProjectType(){
//        return listProjectType;
//    }
    
    public List<ProjectTypeDTO> listProjectType() throws SQLException{
        List<ProjectTypeDTO> list = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "SELECT * FROM ProjectType";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                list = new ArrayList<>();
                while(rs.next()){
                    int projectTypeID = rs.getInt("projectTypeID");
                    String projectTypeName = rs.getString("projectTypeName");
                    int status = rs.getInt("status");
                    ProjectTypeDTO dto = new ProjectTypeDTO(projectTypeID, projectTypeName, status);
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
