package by.htp.xml.entity;

public class Mother extends Human{
    private String maidenName;


    public Mother(String first_name, String last_name, int age, String maidenName) {
        super(first_name, last_name, age);
        this.maidenName = maidenName;
    }

    public Mother() {
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    @Override
    public String toString() {

        return "Mother [maidenName=" + maidenName + ", first-name=" + first_name + ", last-name=" + last_name + ", age=" + age + "]";
    }
}
