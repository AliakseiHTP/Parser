package by.htp.xml.entity;

import java.util.ArrayList;

public class Family {
    private int id;
    private Father father;
    private Mother mother;
    private ArrayList<Child> children;

    public Family() {}

    public Family(Father father, Mother mother, ArrayList<Child> children, int id) {
        this.id = id;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Family [id=" + id + ", father=" + father + ", mother=" + mother + ", children=" + children + "]";
    }
}
