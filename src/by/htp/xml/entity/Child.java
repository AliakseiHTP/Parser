package by.htp.xml.entity;

public class Child extends Human {
    private String gender;

    public Child(String first_name, String last_name, int age, String gender) {
        super(first_name, last_name, age);
        this.gender=gender;
    }

    public Child() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Child [first-name=" + first_name + ", last-name=" + last_name + ", age=" + age + ", gender=" + gender + "]";
    }
}
