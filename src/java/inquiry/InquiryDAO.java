/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inquiry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projects.Project;
import utils.DBUtils;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class InquiryDAO {

    public boolean rejectInquiry(int inquiryID)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. make connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "update Inquiry set statusInquiry = 3 where inquiryID = ?";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, inquiryID);
                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean approvedInquiry(int inquiryID)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. make connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "update Inquiry set statusInquiry = 2 where inquiryID = ?";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, inquiryID);
                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean insertInquiry(Inquiry inquiry)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1.  make connection
            con = DBUtils.getConnection();
            Date now = Date.valueOf(LocalDate.now());

            if (con != null) {
                //2. create sql string
                String sql = "INSERT INTO Inquiry \n"
                        + "	(userID, constructionID , scaleID, priceRangeID, projectTypeID, description, statusInquiry, createAt) \n"
                        + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, inquiry.getUserID());
                stm.setInt(2, inquiry.getConstructionID());
                stm.setInt(3, inquiry.getScaleID());
                stm.setInt(4, inquiry.getProjectTypeID());
                stm.setInt(5, inquiry.getPriceRangeID());
                stm.setString(6, inquiry.getDescription());
                stm.setInt(7, 1);
                stm.setDate(8, now);
                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public List<Inquiry> selectAllInquirys() {
        List<Inquiry> inquirys = new ArrayList<>();
        String query = "SELECT * FROM Inquiry";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Inquiry inquiry = new Inquiry();
                inquiry.setInquiryID(resultSet.getInt("InquiryID"));
                inquiry.setProjectID(resultSet.getInt("ProjectID"));
                inquiry.setUserID(resultSet.getInt("UserID"));
                inquiry.setDescription(resultSet.getString("Description"));
                inquiry.setStatusInquiry(resultSet.getInt("StatusInquiry"));
                inquiry.setCreateAt(resultSet.getDate("CreateAt"));
                inquiry.setUpdateAt(resultSet.getDate("UpdateAt"));
                inquiry.setScaleID(resultSet.getInt("ScaleID"));
                inquiry.setProjectTypeID(resultSet.getInt("ProjectTypeID"));
                inquiry.setPriceRangeID(resultSet.getInt("PriceRangeID"));
                inquiry.setConstructionID(resultSet.getInt("ConstructionID"));
                inquirys.add(inquiry);
            }

            System.out.println("Number of projects retrieved: " + inquirys.size());
        } catch (SQLException ex) {
            Logger.getLogger(InquiryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Đóng tài nguyên
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(InquiryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return inquirys;
    }

    public List<Inquiry> displayAll(int loginUserId, int page, int pageSize) throws SQLException {
        List<Inquiry> inquiriesList = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int offset = (page - 1) * pageSize;

        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "SELECT inquiryID, projectID, Inquiry.userID, statusInquiry, createAt, updateAt, description, Inquiry.constructionID, Construction.constructionName, Inquiry.scaleID, Scale.scaleName, Inquiry.priceRangeID, PriceRange.priceRangeName, Inquiry.projectTypeID, ProjectType.projectTypeName FROM Inquiry inner join (select userID from tblUser where userID = ?) as saveUser on Inquiry.userID = saveUser.userID INNER JOIN Construction ON Construction.constructionID = Inquiry.constructionID INNER JOIN Scale ON Scale.scaleID = Inquiry.scaleID INNER JOIN PriceRange ON PriceRange.priceRangeID = Inquiry.priceRangeID INNER JOIN ProjectType ON ProjectType.projectTypeID = Inquiry.projectTypeID ORDER BY inquiryID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                stm = connection.prepareStatement(sql);
                stm.setInt(1, loginUserId);
                stm.setInt(2, offset); // Set the offset
                stm.setInt(3, pageSize); // Set the fetch count
                rs = stm.executeQuery();
                while (rs.next()) {
                    int inquiryID = rs.getInt("InquiryID");
                    int projectID = rs.getInt("ProjectID");
                    int userID = rs.getInt("UserID");
                    int statusInquiry = rs.getInt("StatusInquiry");
                    Date createdAt = rs.getDate("CreateAt");
                    Date updatedAt = rs.getDate("UpdateAt");
                    String description = rs.getString("Description");
                    int constructionID = rs.getInt("ConstructionID");
                    String constructionName = rs.getString("ConstructionName");
                    Construction construction = new Construction(constructionID, constructionName);
                    int priceRangeID = rs.getInt("PriceRangeID");
                    String priceRangeName = rs.getString("PriceRangeName");
                    PriceRange priceRange = new PriceRange(priceRangeID, priceRangeName);
                    int scaleID = rs.getInt("ScaleID");
                    String scaleName = rs.getString("ScaleName");
                    Scale scale = new Scale(scaleID, scaleName);
                    int projectTypeID = rs.getInt("ProjectTypeID");
                    String projectTypeName = rs.getString("ProjectTypeName");
                    ProjectType projectType = new ProjectType(projectTypeID, projectTypeName);

                    Inquiry inquiryDto = new Inquiry(inquiryID, projectID, userID, statusInquiry, createdAt, updatedAt, description, constructionID, scaleID, priceRangeID, projectTypeID, construction, scale, projectType, priceRange);
                    if (inquiriesList == null) {
                        inquiriesList = new ArrayList<>();
                    }
                    inquiriesList.add(inquiryDto);
                }
            }
        } finally {
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
                ex.printStackTrace();
            }
        }
        return inquiriesList;
    }

    public List<Inquiry> displayAllInquirysByStaff(int page, int pageSize) throws SQLException {
        List<Inquiry> inquiriesList = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int offset = (page - 1) * pageSize;

        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "SELECT inquiryID, projectID, Inquiry.userID, statusInquiry, createAt, updateAt, description, Inquiry.constructionID, Construction.constructionName, Inquiry.scaleID, Scale.scaleName, Inquiry.priceRangeID, PriceRange.priceRangeName, Inquiry.projectTypeID, ProjectType.projectTypeName FROM Inquiry INNER JOIN Construction ON Construction.constructionID = Inquiry.constructionID INNER JOIN Scale ON Scale.scaleID = Inquiry.scaleID INNER JOIN PriceRange ON PriceRange.priceRangeID = Inquiry.priceRangeID INNER JOIN ProjectType ON ProjectType.projectTypeID = Inquiry.projectTypeID ORDER BY inquiryID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                stm = connection.prepareStatement(sql);
                stm.setInt(1, offset); // Set the offset
                stm.setInt(2, pageSize); // Set the fetch count
                rs = stm.executeQuery();
                while (rs.next()) {
                    int inquiryID = rs.getInt("InquiryID");
                    int projectID = rs.getInt("ProjectID");
                    int userID = rs.getInt("UserID");
                    int statusInquiry = rs.getInt("StatusInquiry");
                    Date createdAt = rs.getDate("CreateAt");
                    Date updatedAt = rs.getDate("UpdateAt");
                    String description = rs.getString("Description");
                    int constructionID = rs.getInt("ConstructionID");
                    String constructionName = rs.getString("ConstructionName");
                    Construction construction = new Construction(constructionID, constructionName);
                    int priceRangeID = rs.getInt("PriceRangeID");
                    String priceRangeName = rs.getString("PriceRangeName");
                    PriceRange priceRange = new PriceRange(priceRangeID, priceRangeName);
                    int scaleID = rs.getInt("ScaleID");
                    String scaleName = rs.getString("ScaleName");
                    Scale scale = new Scale(scaleID, scaleName);
                    int projectTypeID = rs.getInt("ProjectTypeID");
                    String projectTypeName = rs.getString("ProjectTypeName");
                    ProjectType projectType = new ProjectType(projectTypeID, projectTypeName);

                    Inquiry inquiryDto = new Inquiry(inquiryID, projectID, userID, statusInquiry, createdAt, updatedAt, description, constructionID, scaleID, priceRangeID, projectTypeID, construction, scale, projectType, priceRange);
                    if (inquiriesList == null) {
                        inquiriesList = new ArrayList<>();
                    }
                    inquiriesList.add(inquiryDto);
                }
            }
        } finally {
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
                ex.printStackTrace();
            }
        }
        return inquiriesList;
    }

    public Inquiry getInquiryByID(int inquiryID)
            throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Inquiry result = null;
        try {
            //1. make connection
            connection = DBUtils.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "SELECT inquiryID, projectID, Inquiry.userID, statusInquiry, createAt, updateAt, description, Inquiry.constructionID, Construction.constructionName, Inquiry.scaleID, Scale.scaleName, Inquiry.priceRangeID, PriceRange.priceRangeName, Inquiry.projectTypeID, ProjectType.projectTypeName FROM Inquiry  INNER JOIN Construction ON Construction.constructionID = Inquiry.constructionID INNER JOIN Scale ON Scale.scaleID = Inquiry.scaleID INNER JOIN PriceRange ON PriceRange.priceRangeID = Inquiry.priceRangeID INNER JOIN ProjectType ON ProjectType.projectTypeID = Inquiry.projectTypeID where  Inquiry.inquiryID = ?";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, inquiryID);
                //4. execute query
                rs = stm.executeQuery(); // do phia tren da nap roi nen ko can truyen them tham so de nap vao bo nho
                //5. process result
                if (rs.next()) {
                    // get recipe DTO info
                    int projectID = rs.getInt("ProjectID");
                    int userID = rs.getInt("UserID");
                    int statusInquiry = rs.getInt("StatusInquiry");
                    Date createdAt = rs.getDate("CreateAt");
                    Date updatedAt = rs.getDate("UpdateAt");
                    String description = rs.getString("Description");
                    int constructionID = rs.getInt("ConstructionID");
                    String constructionName = rs.getString("ConstructionName");
                    Construction construction = new Construction(constructionID, constructionName);
                    int priceRangeID = rs.getInt("PriceRangeID");
                    String priceRangeName = rs.getString("PriceRangeName");
                    PriceRange priceRange = new PriceRange(priceRangeID, priceRangeName);
                    int scaleID = rs.getInt("ScaleID");
                    String scaleName = rs.getString("ScaleName");
                    Scale scale = new Scale(scaleID, scaleName);
                    int projectTypeID = rs.getInt("ProjectTypeID");
                    String projectTypeName = rs.getString("ProjectTypeName");
                    ProjectType projectType = new ProjectType(projectTypeID, projectTypeName);

                    Inquiry inquiryDto = new Inquiry(projectID, userID, statusInquiry, createdAt, updatedAt, description, constructionID, scaleID, priceRangeID, projectTypeID, construction, scale, projectType, priceRange);
                    result = inquiryDto;

                }
            }
        } finally {
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
        return result;
    }

    public int countAllInquirys() {
        int numberOfInquirys = 0;
        String query = "SELECT COUNT(*) AS NumberOfInquirys FROM Inquiry";
        try (Connection con = DBUtils.getConnection();
                PreparedStatement stm = con.prepareStatement(query);
                ResultSet rs = stm.executeQuery()) {

            if (rs.next()) {
                numberOfInquirys = rs.getInt("NumberOfInquirys");
            }

        } catch (SQLException ex) {
            // Improve error logging here
            Logger.getLogger(InquiryDAO.class.getName()).log(Level.SEVERE, "Error counting users", ex);
        }
        return numberOfInquirys;
    }
}
