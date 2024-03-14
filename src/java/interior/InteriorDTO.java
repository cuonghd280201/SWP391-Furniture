/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interior;

import java.sql.Timestamp;

/**
 *
 * @author cdkhu
 */
public class InteriorDTO {
    private int interiorID;
    private String interiorName;
    private int size;
    private int unit;
    private double mass;
    private double unitPrice;
    private double money;
    private String description;
    private String image;
    private int projectID;
    private Timestamp createAt;
    private Timestamp updateAt;
    private int status;
    private int materialID;

    public InteriorDTO() {
    }

    public InteriorDTO(int interiorID, String interiorName, int size, int unit, double mass, double unitPrice, double money, String description, String image, int projectID, Timestamp createAt, Timestamp updateAt, int status, int materialID) {
        this.interiorID = interiorID;
        this.interiorName = interiorName;
        this.size = size;
        this.unit = unit;
        this.mass = mass;
        this.unitPrice = unitPrice;
        this.money = money;
        this.description = description;
        this.image = image;
        this.projectID = projectID;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
        this.materialID = materialID;
    }

    public int getInteriorID() {
        return interiorID;
    }

    public void setInteriorID(int interiorID) {
        this.interiorID = interiorID;
    }

    public String getInteriorName() {
        return interiorName;
    }

    public void setInteriorName(String interiorName) {
        this.interiorName = interiorName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    

}
