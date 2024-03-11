/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDetail;

/**
 *
 * @author Admin
 */
public class OrderDetailDTO {
    
     private int orderDetailID;
    private int interiorID;
    private int projectID;
    private int paymentID;
    private int interiorQuantity;
    private double interiorMoney;
    private int status;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderDetailID, int interiorID, int projectID, int paymentID, int interiorQuantity, double interiorMoney, int status) {
        this.orderDetailID = orderDetailID;
        this.interiorID = interiorID;
        this.projectID = projectID;
        this.paymentID = paymentID;
        this.interiorQuantity = interiorQuantity;
        this.interiorMoney = interiorMoney;
        this.status = status;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getInteriorID() {
        return interiorID;
    }

    public void setInteriorID(int interiorID) {
        this.interiorID = interiorID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getInteriorQuantity() {
        return interiorQuantity;
    }

    public void setInteriorQuantity(int interiorQuantity) {
        this.interiorQuantity = interiorQuantity;
    }

    public double getInteriorMoney() {
        return interiorMoney;
    }

    public void setInteriorMoney(double interiorMoney) {
        this.interiorMoney = interiorMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}
