/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class UserDTO implements Serializable {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Date dataOfBirth;
    private String image;
    private String roleId;
    private boolean isActived;
    private Date create_At;

    public UserDTO() {
    }

    public UserDTO(int userId, String firstName, String lastName, String email, String image) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.image= image;
    }
    
    

    public UserDTO(int userId, String firstName, String lastName, String email, String password, String phoneNumber, Date dataOfBirth, String image, String roleId, boolean isActived, Date create_At) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dataOfBirth = dataOfBirth;
        this.image = image;
        this.roleId = roleId;
        this.isActived = isActived;
        this.create_At = create_At;
    }

    public UserDTO(String firstName, String lastName, String email, String password, String phoneNumber, Date dataOfBirth, String image, String roleId, boolean isActived) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dataOfBirth = dataOfBirth;
        this.image = image;
        this.roleId = roleId;
        this.isActived = isActived;
    }

    public UserDTO(String firstName, String lastName, String email, String password, String phoneNumber, Date created_At, boolean isActived) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.create_At = created_At;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActived = isActived;
    }

    public UserDTO(String firstName, String lastName, String email, String password, String phoneNumber, Date dataOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dataOfBirth = dataOfBirth;
    }
    
    
    

    public UserDTO(int userId, String firstName, String lastName, String email, String password, String phoneNumber, Date dataOfBirth, String image, String roleId, boolean isActived) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dataOfBirth = dataOfBirth;
        this.image = image;
        this.roleId = roleId;
        this.isActived = isActived;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(Date dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public boolean isIsActived() {
        return isActived;
    }

    public void setIsActived(boolean isActived) {
        this.isActived = isActived;
    }

}
