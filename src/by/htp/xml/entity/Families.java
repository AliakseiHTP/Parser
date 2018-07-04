package by.htp.xml.entity;

import java.util.ArrayList;

public class Families {
    private ArrayList<Family> families = new ArrayList<>();

    public Families() {}

    public Families(ArrayList<Family> families) {
        this.families = families;
    }

    public ArrayList<Family> getFamilies() {
        return families;
    }

    public void setFamilies(ArrayList<Family> families) {
        this.families = families;
    }

    public void addFamily(Family family) {
        families.add(family);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Family family : families) {
            text.append(family).append("\n");
        }
        return "Families: \n" + text;
    }
}
