package projects;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import images.ImageDTO;

public class ProjectFacade {

    public Project getProjectById(int projectID) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Project result = null;

        try {
            // 1. Tạo kết nối
            connection = DBUtils.getConnection();

            if (connection != null) {
                // 2. Tạo câu lệnh SQL
                String sql = "SELECT p.projectName, p.scale, p.createAt, p.updateAt, p.description, p.status, p.price, p.userID, p.projectTypeID, i.imageID, i.imageURL "
                        + "FROM Project p "
                        + "LEFT JOIN tblImage i ON p.projectID = i.projectID "
                        + "WHERE p.projectID = ?";
                stm = connection.prepareStatement(sql);
                stm.setInt(1, projectID);

                // 3. Thực thi truy vấn
                rs = stm.executeQuery();

                // 4. Xử lý kết quả
                if (rs.next()) {
                    String projectName = rs.getString("projectName");
                    String description = rs.getString("description");
                    String scale = rs.getString("scale");
                    String createAt = rs.getString("createAt");
                    String updateAt = rs.getString("updateAt");
                    String status = rs.getString("status");
                    float price = rs.getFloat("price");
                    String projectTypeID = rs.getString("projectTypeID");
                    int imageID = rs.getInt("imageID");
                    String imageURL = rs.getString("imageURL");

                    ImageDTO image = new ImageDTO(imageID, imageURL);
                    Project project = new Project(projectName, scale, description, createAt, updateAt, status, price, projectTypeID, image);
                    result = project;
                }
            }
        } finally {
            // 5. Đóng các tài nguyên
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        // 6. Trả về kết quả
        return result;
    }

    public int countAllProjects() {
        int numberOfProjects = 0;
        String query = "SELECT COUNT(*) AS NumberOfProjects FROM Project";
        try (Connection con = DBUtils.getConnection();
                PreparedStatement stm = con.prepareStatement(query);
                ResultSet rs = stm.executeQuery()) {

            if (rs.next()) {
                numberOfProjects = rs.getInt("NumberOfProjects");
            }

        } catch (SQLException ex) {
            // Improve error logging here
            Logger.getLogger(ProjectFacade.class.getName()).log(Level.SEVERE, "Error counting users", ex);
        }
        return numberOfProjects;
    }

    public List<Project> selectAllProjects() {
        String query = "SELECT p.projectID, p.projectName, p.scale, p.createAt, p.updateAt, p.description, p.status, p.price, p.userID, p.projectTypeID, i.imageID, i.imageURL FROM Project p LEFT JOIN tblImage i ON p.projectID = i.projectID";

        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Project> projectDtoList = new ArrayList<>(); // Initialize list outside try block

        try {
            connection = DBUtils.getConnection();
            stm = connection.prepareStatement(query);
            rs = stm.executeQuery();

            while (rs.next()) {
                int projectID = rs.getInt("projectID");
                String projectName = rs.getString("projectName");
                String description = rs.getString("description");
                String scale = rs.getString("scale");
                String createAt = rs.getString("createAt");
                String updateAt = rs.getString("updateAt");
                String status = rs.getString("status");
                float price = rs.getFloat("price");
                String projectTypeID = rs.getString("projectTypeID");
                int imgId = rs.getInt("imageID");
                String imgLink = rs.getString("imageURL");
                ImageDTO image = new ImageDTO(imgId, imgLink);
                Project projectDto = new Project(projectID, projectName, scale, description, createAt, updateAt, status, price, projectTypeID, image);
                projectDtoList.add(projectDto);
            }

            System.out.println("Number of projects retrieved: " + projectDtoList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ProjectFacade.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources in finally block
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return projectDtoList;
    }

}
