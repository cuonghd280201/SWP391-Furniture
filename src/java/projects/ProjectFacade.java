package projects;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectFacade {
    public List<Project> selectAllProjects() {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT * FROM Project";
        
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Project project = new Project();
                project.setProjectID(resultSet.getString("ProjectID").trim());
                project.setProjectName(resultSet.getString("ProjectName"));
                project.setScale(resultSet.getString("Scale"));
                project.setDescription(resultSet.getString("Description"));
                project.setImage(resultSet.getString("Image"));
                project.setCreateAt(resultSet.getString("CreateAt"));
                project.setUpdateAt(resultSet.getString("UpdateAt"));
                project.setStatus(resultSet.getString("Status"));
                project.setPrice(resultSet.getFloat("Price"));
                project.setProjectTypeID(resultSet.getString("ProjectTypeID"));

                projects.add(project);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Number of projects retrieved: " + projects.size()); // Thêm dòng này

        return projects;
    }
}
