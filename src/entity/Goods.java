package entity;

import java.util.Date;

public class Goods {
    private String goodsID;// 货单号
    private String goodsName;// 货物名称
    private String goodsStart;// 发货地址
    private String goodsSend;// 收货地址
    private String consigner;// 发货人
    private String consignee;// 收货人
    private String phone;// 收货人电话
    private String courierID;// 派送人员编号
    private Date date;// 发货时间

    public Goods() {
    }

    public Goods(String goodsID, String goodsName, String goodsStart, String goodsSend, String consigner, String consignee, String phone, String courierID, Date date) {
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.goodsStart = goodsStart;
        this.goodsSend = goodsSend;
        this.consigner = consigner;
        this.consignee = consignee;
        this.phone = phone;
        this.courierID = courierID;
        this.date = date;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
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

    public String getCourierID() {
        return courierID;
    }

    public void setCourierID(String courierID) {
        this.courierID = courierID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
