/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class CommentDAO {
    private List<CommentDTO> commentsList;
    public List<CommentDTO> getCommentsList(){
    return commentsList;
            }
    
    
 public List<CommentDTO> getCommentByRecipeId(int projectID) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Make connection
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "SELECT c.commentID, c.userID, c.projectID, u.firstName, u.image, c.commentDetail, c.createAt, c.updateAt, c.is_actived FROM Comment c INNER JOIN tblUser u ON c.userID = u.userID WHERE c.projectID = ? AND c.is_actived = 1";
                String sql1= "SELECT commentID,Comment.userID,R.projectID,tblUser.firstName,tblUser.image,commentDetail,createAt,updateAt,Comment.is_actived FROM (SELECT projectID FROM Project) AS R INNER JOIN Comment ON R.projectID = Comment.projectID INNER JOIN tblUser ON Comment.userID = tblUser.userID WHERE R.projectID = ? AND Comment.is_actived = 1;";
                //2. Create SQl String
                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, projectID);
                //4. Execute query
                rs = stm.executeQuery();
                //5. Process result     
                while (rs.next()) {
                    //get comment DTO info
                    int commentID = rs.getInt("commentID");
                    int userID = rs.getInt("userID");
                    String firstName = rs.getString("firstName");
                    String image = rs.getString("Image");
                    String commentDetail = rs.getString("commentDetail");
                    Date createdAt = rs.getDate("createAt");
                    Date updateAt = rs.getDate("updateAt");
                    boolean is_actived = rs.getBoolean("is_actived");
                    //create comment DTO
                    CommentDTO comment = new CommentDTO(commentID, userID, projectID, firstName, image, commentDetail, createdAt, updateAt, is_actived);
                    // check recipe dto list not null
                    if (commentsList == null) {
                        commentsList = new ArrayList<>();
                    }//recipesList has existed
                    commentsList.add(comment);
                }//end traverse ResultSet
            }//end check conection is not null
            return commentsList;
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
    } //end getCommentByRecipeId function
            
     public boolean addNewComment(int userID, int projectID, String commentDetail, Date createdAt, Date updateAt, boolean is_actived) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        boolean result = false;

        try {
            //1. Make connection
            connection = DBUtils.makeConnection();
            if (connection != null) {
                //2. Create SQl String
                String sql = "insert into Comment (userID, projectID, commentDetail, createAt, updateAt, is_actived) values (?, ?, ?, ?, ?, ?);";
                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, userID);
                stm.setInt(2, projectID);
                stm.setString(3, commentDetail);
                stm.setDate(4, createdAt);
                stm.setDate(5, updateAt);
                stm.setBoolean(6, is_actived);
                //4. Execute query
                int tmp = stm.executeUpdate();

                //5. Process result
                if (tmp != 0) {
                    result = true;
                }
            }//end check conection is not null            
            return result;
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    } //end addNewComment function

    public boolean deleteCommentByCommentId(int commentID) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            //1. Make connection
            connection = DBUtils.makeConnection();
            if (connection != null) {
                //2. Create SQl String
                String sql = "UPDATE comment SET is_actived = 0 WHERE (commentID = ?)";

                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, commentID);

                //4. Execute query
                int tmp = stm.executeUpdate();

                //5. Process result
                if (tmp != 0) {
                    result = true;
                }
            }//end check conection is not null            
            return result;
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }//end deleteCommentByCommentId function

    public boolean editCommentByCommentId(int comment_id, String comment_detail)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        Date now = Date.valueOf(LocalDate.now());
        try {
            //1. make connection
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "UPDATE Comment SET commentDetail=?, "
                        + "updateAt=? WHERE commentID=?";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, comment_detail);
                stm.setDate(2, now);
                stm.setInt(3, comment_id);
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
    }//end editCommentByCommentId function
    
    
    
}
