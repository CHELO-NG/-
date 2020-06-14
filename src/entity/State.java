package entity;

public class State {
    private String goodsID;// 派送物件编号
    private String goodsState;// 货物状态

    public State() {
    }

    public State(String goodsID, String goodsState) {
        this.goodsID = goodsID;
        this.goodsState = goodsState;
    }


    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
    }
}
