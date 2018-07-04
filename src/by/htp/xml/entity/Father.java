package by.htp.xml.entity;

public class Father extends Human {
    private String military;

    public Father(String first_name, String last_name, int age, String military) {
        super(first_name, last_name, age);
        this.military = military;
    }

    public Father() {
    }

    public String getMilitary() {
        return military;
    }

    public void setMilitary(String military) {
        this.military = military;
    }

    @Override
    public String toString() {
        return "Father [military=" + military + ", first-name=" + first_name + ", last-name=" + last_name + ", age=" + age + "]";
    }
}
