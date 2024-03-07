/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import utils.DBUtils;
import users.UserDTO;

/**
 *
 * @author Admin
 */
public class UserDAO {

    public boolean createStaff(UserDTO userDTO)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;

        try {
            //1.  make connection
            con = DBUtils.makeConnection();
            Date now = Date.valueOf(LocalDate.now());

            if (con != null) {
                //2. create sql string
                String sql = "INSERT INTO tblUser (firstName , lastName, email, password, phoneNumber, dataOfBirth, create_At, roleID, is_actived) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, userDTO.getFirstName());
                stm.setString(2, userDTO.getLastName());
                stm.setString(3, userDTO.getEmail());
                stm.setString(4, userDTO.getPassword());
                stm.setString(5, userDTO.getPhoneNumber());
                stm.setDate(6, userDTO.getDataOfBirth());
                stm.setDate(7, now);
                stm.setInt(8, 2);
                stm.setInt(9, 0);
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

    public UserDTO displayUserProfile(int loginValue)
            throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UserDTO result = null;
        try {
            //1. Make connection
            connection = DBUtils.makeConnection();
            if (connection != null) {
                //2. Create SQL String
                String sql = "select firstName, lastName, email, password, phoneNumber, dataOfBirth, image, status, roleID, notificationID, is_actived \n"
                        + " from tblUser \n"
                        + " where tblUser.userID = ?";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setInt(1, loginValue);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result 
                if (rs.next()) {
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String phoneNumber = rs.getString("phoneNumber");
                    Date dataOfBirth = rs.getDate("dataOfBirth");
                    String imageUrl = rs.getString("image");
                    String status = rs.getString("status");
                    String roleID = rs.getString("roleID");
                    Boolean isActived = rs.getBoolean("is_actived");
                    result = new UserDTO(firstName, lastName, email, password, phoneNumber, dataOfBirth, imageUrl, roleID, isActived);

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

    public boolean checkEmailIsActive(String email) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBUtils.makeConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select is_actived from tblUser where email=? and is_actived=1 ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, email);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }

    public boolean verifyEmail(int userID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. make connection
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "update tblUser set is_actived=1 where userID=?";
                //3. create statement obj
                stm = con.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, userID);
                //4. execute query
                int affactedRows = stm.executeUpdate();
                //5 process result
                if (affactedRows > 0) {
                    result = true;
                }
            }
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

    public int checkUserIdWithEmail(String email) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            //1. make connection
            connection = DBUtils.makeConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select userID from tblUser where email=? ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, email);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    result = rs.getInt("userID");
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

    public boolean checkEmail(String email) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBUtils.makeConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select email from tblUser where email like ? ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, email);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }

    public UserDTO checkLogin(String email, String password) throws SQLException {
        UserDTO user = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select * from tblUser where email = ? and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int userId = rs.getInt("userId");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String phoneNumber = rs.getString("phoneNumber");
                    Date dataOfBirth = rs.getDate("dataOfBirth");
                    String image = rs.getString("image");
                    String roleId = rs.getString("roleId");
                    Boolean isActived = rs.getBoolean("is_actived");

                    user = new UserDTO(userId, firstName, lastName, email, password, phoneNumber, dataOfBirth, image, roleId, isActived);
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
            Connection con = DBUtils.makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserDTO u = new UserDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getBoolean(10));
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
        Connection con = DBUtils.makeConnection();
        try {
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, user.getFirstName());
            stm.setString(2, user.getLastName());
            stm.setString(3, user.getImage());
            stm.setDate(4, user.getDataOfBirth());
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
            Connection con = DBUtils.makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new UserDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getBoolean(10));
            }
            con.close();
        } catch (Exception e) {

        }
        return null;
    }

    public boolean signUp(UserDTO u) {
        boolean result = true;
        Connection con = DBUtils.makeConnection();
        try {
            PreparedStatement stm = con.prepareStatement("insert into tblUser values(?, '', '', ?, ?,'','','','','1','1')");
            stm.setInt(1, u.getUserId());
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
        Connection con = DBUtils.makeConnection();
        try {
            PreparedStatement stm = con.prepareStatement("select * from tblUser where userID = ?");
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                user = new UserDTO();
                user.setUserId(rs.getInt("UserId"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setDataOfBirth(rs.getDate("DataOfBirth"));
                user.setImage(rs.getString("Image"));
                user.setRoleId(rs.getString("RoleId"));
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public List<UserDTO> selectAllUsersAdmin() {
        List<UserDTO> list = new ArrayList<>();
        String query = "SELECT TOP 5 * FROM tblUser JOIN role ON tblUser.roleID = role.roleID WHERE role.roleID = 1 ORDER BY tblUser.create_At DESC;";
        try (Connection con = DBUtils.makeConnection();
                PreparedStatement stm = con.prepareStatement(query);
                ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getInt("UserId"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setDataOfBirth(rs.getDate("DataOfBirth"));
                user.setImage(rs.getString("Image"));
                user.setRoleId(rs.getString("RoleId"));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<UserDTO> selectAllUsers() {
        List<UserDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tblUser JOIN role ON tblUser.roleID = role.roleID WHERE role.roleID = 1";
        try (Connection con = DBUtils.makeConnection();
                PreparedStatement stm = con.prepareStatement(query);
                ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getInt("UserId"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setDataOfBirth(rs.getDate("DataOfBirth"));
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
        try (Connection con = DBUtils.makeConnection();
                PreparedStatement stm = con.prepareStatement(query);
                ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getInt("UserId"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setDataOfBirth(rs.getDate("DataOfBirth"));
                user.setImage(rs.getString("Image"));
                user.setRoleId(rs.getString("RoleId"));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean CreateUser() throws SQLException {
        boolean set = false;
        Connection con = null;
        Date now = Date.valueOf(LocalDate.now());
        try {
            con = DBUtils.makeConnection();
            //Insert register data to database
            String query = " insert into tblUser (created_At) values(?)";

            PreparedStatement pt = con.prepareStatement(query);
            //pt.setInt(1, user.getUserId());            
            pt.setDate(1, now);
            pt.executeUpdate();
            set = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return set;
    }

    public int getCurrentUserId() throws SQLException {
        //User_tblDTO usr = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int userId = 0;
        try {
            con = DBUtils.makeConnection();
            String query = "SELECT TOP 1 userID AS current_identity FROM tblUser ORDER BY userID DESC";
            Statement pst = con.createStatement();
            //pst.setString(1, query);            

            rs = pst.executeQuery(query);

            if (rs.next()) {
//                usr = new Account_tblDTO();
////                usr.setAccountId(rs.getInt("id"));
////                usr.setUsername(rs.getString("name"));
//                usr.setUsername(rs.getString("UserName"));
//                usr.setPassword(rs.getString("Password"));
//                usr = new User_tblDTO();
//                usr.setUserId(rs.getInt("id"));                   
                userId = rs.getInt("current_identity");

            }

        } catch (Exception e) {
            e.printStackTrace();
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
        return userId;
    }

    public boolean saveUser(UserDTO acc) throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        boolean set = false;
        Date now = Date.valueOf(LocalDate.now());
        try {
            con = DBUtils.makeConnection();
            //Insert register data to database
            String query = "INSERT INTO tblUser (firstName, lastName, password, email, phoneNumber, create_At, is_actived,  roleID)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, 0, 1);";
            PreparedStatement pt = con.prepareStatement(query);
            pt.setString(1, acc.getFirstName());
            pt.setString(2, acc.getLastName());
            pt.setString(3, acc.getPassword());
            pt.setString(4, acc.getEmail());
            pt.setString(5, acc.getPhoneNumber());
            pt.setDate(6, now);

            pt.executeUpdate();
            set = true;
        } catch (Exception e) {
            e.printStackTrace();
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
        return set;
    }

    public boolean checkPhonenumber(String phonenumber) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBUtils.makeConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select phoneNumber from tblUser where phoneNumber like ? ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, phonenumber);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }

    public int countAllUsers() {
        int numberOfUsers = 0;
        String query = "SELECT COUNT(*) AS NumberOfUsers FROM tblUser";
        try (Connection con = DBUtils.makeConnection();
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

    public int countAllCustomers() {
        int numberOfCustomers = 0;
        String query = "SELECT COUNT(*) AS NumberOfCustomers FROM tblUser where roleID = 1";
        try (Connection con = DBUtils.makeConnection();
                PreparedStatement stm = con.prepareStatement(query);
                ResultSet rs = stm.executeQuery()) {

            if (rs.next()) {
                numberOfCustomers = rs.getInt("NumberOfCustomers");
            }

        } catch (SQLException ex) {
            // Improve error logging here
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Error counting users", ex);
        }
        return numberOfCustomers;
    }

    public int countAllStaffs() {
        int numberOfStaffs = 0;
        String query = "SELECT COUNT(*) AS NumberOfStaffs FROM tblUser WHERE roleID = 2";
        try (Connection con = DBUtils.makeConnection();
                PreparedStatement stm = con.prepareStatement(query);
                ResultSet rs = stm.executeQuery()) {

            if (rs.next()) {
                numberOfStaffs = rs.getInt("NumberOfStaffs");
            }

        } catch (SQLException ex) {
            // Improve error logging here
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Error counting users", ex);
        }
        return numberOfStaffs;
    }

    public int updateAccount(int usupid, boolean usupstt) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        int affectedRows = 0;
        try {
            //1. make connection
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "UPDATE tblUser \n"
                        + "SET is_actived = ? \n"
                        + "WHERE (userID = ?)";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, usupstt);
                stm.setInt(2, usupid);
                //4. execute query
                affectedRows = stm.executeUpdate();
                //5 process result

            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return affectedRows;
    }

    public boolean addUser(UserDTO u) {
        String query = "insert into tblUser (firstName, lastName, email, password, phoneNumber, dataOfBirth) values (?,?,?,?,?,?)";
        try (Connection con = DBUtils.makeConnection();
                PreparedStatement stm = con.prepareStatement(query)) {

            stm.setString(1, u.getFirstName());
            stm.setString(2, u.getLastName());
            stm.setString(3, u.getEmail());
            stm.setString(4, u.getPassword());
            stm.setString(5, u.getPhoneNumber());
            stm.setDate(6, u.getDataOfBirth());

            int affectedRows = stm.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;  // Return false if there's an exception.
        }
    }

}
