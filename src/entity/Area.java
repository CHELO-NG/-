package entity;

public class Area {
    private String courierID;// 派送人员编号
    private String goodsID;// 派送物件编号
    private String goodsSend;// 收件地址

    public Area() {
    }

    public Area(String courierID, String goodsID, String goodsSend) {
        this.courierID = courierID;
        this.goodsID = goodsID;
        this.goodsSend = goodsSend;
    }

    public String getCourierID() {
        return courierID;
    }

    public void setCourierID(String courierID) {
        this.courierID = courierID;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsSend() {
        return goodsSend;
    }

    public void setGoodsSend(String goodsSend) {
        this.goodsSend = goodsSend;
    }
}
