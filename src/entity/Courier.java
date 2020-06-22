package entity;

public class Courier {
    private int courierID;// 派送人员编号
    private String courierName;// 派送人员姓名
    private String courierPhone;// 派送人员电话号码
    private String courierArea;// 派送范围
    private String courierSalary;// 派送人员薪水

    public Courier() {
    }

    public Courier(int courierID, String courierName, String courierPhone, String courierArea, String courierSalary) {
        this.courierID = courierID;
        this.courierName = courierName;
        this.courierPhone = courierPhone;
        this.courierArea = courierArea;
        this.courierSalary = courierSalary;
    }

    public int getCourierID() {
        return courierID;
    }

    public void setCourierID(int courierCode) {
        this.courierID = courierCode;
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

    public String getCourierArea() {
        return courierArea;
    }

    public void setCourierArea(String courierArea) {
        this.courierArea = courierArea;
    }

    public String getCourierSalary() {
        return courierSalary;
    }

    public void setCourierSalary(String courierSalary) {
        this.courierSalary = courierSalary;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "courierID='" + courierID + '\'' +
                ", courierName='" + courierName + '\'' +
                ", courierPhone='" + courierPhone + '\'' +
                ", courierArea='" + courierArea + '\'' +
                ", courierSalary='" + courierSalary + '\'' +
                '}';
    }
}
