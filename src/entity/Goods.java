package entity;

import java.util.Date;

public class Goods {
    private Integer goodsID;// 货单号
    private String goodsName;// 货物名称
    private String goodsStart;// 发货地址
    private String goodsSend;// 收货地址
    private String consigner;// 发货人
    private String consignee;// 收货人
    private String phone;// 收货人电话
    private Integer courierID;// 派送人员编号
    private String courierPhone;// 派送人员电话号码
    private Date date;// 发货时间
    private String goodsState;// 货物状态

    public Goods() {
    }

    public Goods(int goodsID, String goodsName, String goodsStart, String goodsSend, String consigner, String consignee, String phone, int courierID, String courierPhone, Date date, String goodsState) {
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.goodsStart = goodsStart;
        this.goodsSend = goodsSend;
        this.consigner = consigner;
        this.consignee = consignee;
        this.phone = phone;
        this.courierID = courierID;
        this.courierPhone = courierPhone;
        this.date = date;
        this.goodsState = goodsState;
    }

    public int getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(int goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsStart() {
        return goodsStart;
    }

    public void setGoodsStart(String goodsStart) {
        this.goodsStart = goodsStart;
    }

    public String getGoodsSend() {
        return goodsSend;
    }

    public void setGoodsSend(String goodsSend) {
        this.goodsSend = goodsSend;
    }

    public String getConsigner() {
        return consigner;
    }

    public void setConsigner(String consigner) {
        this.consigner = consigner;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCourierID() {
        return courierID;
    }

    public void setCourierID(int courierID) {
        this.courierID = courierID;
    }

    public String getCourierPhone() {
        return courierPhone;
    }

    public void setCourierPhone(String courierPhone) {
        this.courierPhone = courierPhone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsID='" + goodsID + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsStart='" + goodsStart + '\'' +
                ", goodsSend='" + goodsSend + '\'' +
                ", consigner='" + consigner + '\'' +
                ", consignee='" + consignee + '\'' +
                ", phone='" + phone + '\'' +
                ", courierID='" + courierID + '\'' +
                ", courierPhone='" + courierPhone + '\'' +
                ", date=" + date +
                ", goodsState='" + goodsState + '\'' +
                '}';
    }
}
