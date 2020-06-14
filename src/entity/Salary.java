package entity;

public class Salary {
    private String courierID;// 派送人员编号
    private String courierSalary;// 派送人员薪水

    public Salary() {
    }

    public Salary(String courierID, String courierSalary) {
        this.courierID = courierID;
        this.courierSalary = courierSalary;
    }

    public String getCourierID() {
        return courierID;
    }

    public void setCourierID(String courierID) {
        this.courierID = courierID;
    }

    public String getCourierSalary() {
        return courierSalary;
    }

    public void setCourierSalary(String courierSalary) {
        this.courierSalary = courierSalary;
    }
}
