package entity;

public class Courier {
    private String courierCode;// 派送人员编号
    private String courierName;// 派送人员姓名
    private String courierPhone;// 派送人员电话号码

    public Courier() {
    }

    public Courier(String courierCode, String courierName, String courierPhone) {
        this.courierCode = courierCode;
        this.courierName = courierName;
        this.courierPhone = courierPhone;
    }

    public String getCourierCode() {
        return courierCode;
    }

    public void setCourierCode(String courierCode) {
        this.courierCode = courierCode;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public String getCourierPhone() {
        return courierPhone;
    }

    public void setCourierPhone(String courierPhone) {
        this.courierPhone = courierPhone;
    }
}
