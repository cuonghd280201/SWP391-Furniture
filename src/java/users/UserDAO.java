/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class UserDAO {

    public UserDTO checkLogin(String email, String password) throws SQLException {
        UserDTO user = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select * from tblUser where email = ? and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String userId = rs.getString("userId");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String phoneNumber = rs.getString("phoneNumber");
                    String dataOfBirth = rs.getString("dataOfBirth");
                    String image = rs.getString("image");
                    String roleId = rs.getString("roleId");
                    user = new UserDTO(userId, firstName, lastName, email, password, phoneNumber, dataOfBirth, image, roleId);
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return user;
    }

    PreparedStatement ps = null;
    ResultSet rs = null;

    public UserDTO checkLogin1(String email, String pass) {
        try {
            String query = "select * from tblUser where email = ? and password = ?";
            Connection con = DBUtils.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserDTO u = new UserDTO(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateUser(UserDTO user) {
        boolean result = true;
        String query = "UPDATE tblUSERS SET FullName= ?, AddressUser= ?, PhoneUser= ?, BirthDay= ? where UserName= ?";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, user.getFirstName());
            stm.setString(2, user.getLastName());
            stm.setString(3, user.getImage());
            stm.setString(4, user.getDataOfBirth());
            stm.setString(5, user.getPassword());
            int count = stm.executeUpdate();
            if (count == 0) {
                result = false;
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

    public UserDTO checkAccountExist(String user) {
        try {
            String query = "select * from tblUser where email = ?";
            Connection con = DBUtils.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new UserDTO(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
            }
            con.close();
        } catch (Exception e) {

        }
        return null;
    }

    public boolean signUp(UserDTO u) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("insert into tblUser values(?, '', '', ?, ?,'','','','','1','1')");
            stm.setString(1, u.getUserId());
            stm.setString(2, u.getEmail());
            stm.setString(3, u.getPassword());
            int count = stm.executeUpdate();
            if (count == 0) {
                result = false;
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

    public UserDTO detailUserById(String id) {
        UserDTO user = null;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("select * from tblUser where userID = ?");
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                user = new UserDTO();
                user.setUserId(rs.getString("UserId").trim());
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setDataOfBirth(rs.getString("DataOfBirth"));
                user.setImage(rs.getString("Image"));
                user.setRoleId(rs.getString("RoleId"));
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public List<UserDTO> selectAllUsers() {
        List<UserDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tblUser JOIN role ON tblUser.roleID = role.roleID WHERE role.roleID = 1";
        try (Connection con = DBUtils.getConnection();
                PreparedStatement stm = con.prepareStatement(query);
                ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getString("UserId").trim());
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setDataOfBirth(rs.getString("DataOfBirth"));
                user.setImage(rs.getString("Image"));
                user.setRoleId(rs.getString("RoleId"));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<UserDTO> selectAllStaffs() {
        List<UserDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tblUser JOIN role ON tblUser.roleID = role.roleID WHERE role.roleID = 2";
        try (Connection con = DBUtils.getConnection();
                PreparedStatement stm = con.prepareStatement(query);
                ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getString("UserId").trim());
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setDataOfBirth(rs.getString("DataOfBirth"));
                user.setImage(rs.getString("Image"));
                user.setRoleId(rs.getString("RoleId"));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int countAllUsers() {
        int numberOfUsers = 0;
        String query = "SELECT COUNT(*) AS NumberOfUsers FROM tblUser";
        try (Connection con = DBUtils.getConnection();
                PreparedStatement stm = con.prepareStatement(query);
                ResultSet rs = stm.executeQuery()) {

            if (rs.next()) {
                numberOfUsers = rs.getInt("NumberOfUsers");
            }

        } catch (SQLException ex) {
            // Improve error logging here
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Error counting users", ex);
        }
        return numberOfUsers;
    }

    public boolean addUser(UserDTO u) {
        String query = "insert into tblUser (firstName, lastName, email, password, phoneNumber, dataOfBirth) values (?,?,?,?,?,?)";
        try (Connection con = DBUtils.getConnection();
                PreparedStatement stm = con.prepareStatement(query)) {

            stm.setString(1, u.getFirstName());
            stm.setString(2, u.getLastName());
            stm.setString(3, u.getEmail());
            stm.setString(4, u.getPassword());
            stm.setString(5, u.getPhoneNumber());
            stm.setString(6, u.getDataOfBirth());

            int affectedRows = stm.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;  // Return false if there's an exception.
        }
    }

}
