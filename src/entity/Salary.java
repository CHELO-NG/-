package entity;

public class Salary {
    private Integer courierID;
    private String courierName;
    private Integer count;
    private Integer courierSalary;

    public Salary() {
    }

    public Salary(int courierID, int courierSalary) {
        this.courierID = courierID;
        this.courierSalary = courierSalary;
    }

    public Salary(int courierID, String courierName, int count, int courierSalary) {
        this.courierID = courierID;
        this.courierName = courierName;
        this.count = count;
        this.courierSalary = courierSalary;
    }

    public int getCourierID() {
        return courierID;
    }

    public void setCourierID(int courierID) {
        this.courierID = courierID;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCourierSalary() {
        return courierSalary;
    }

    public void setCourierSalary(int courierSalary) {
        this.courierSalary = courierSalary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "courierID=" + courierID +
                ", courierName='" + courierName + '\'' +
                ", count=" + count +
                ", salary=" + courierSalary +
                '}';
    }
}
