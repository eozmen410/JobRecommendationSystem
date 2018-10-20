import java.util.ArrayList;

public class Job {

    private HR hr;
    private String description;
    private Area area;
    private int monthlyPay;
    private ArrayList<Skills> skills;

    private long ID;
    private static long lastID =0;

    public Job(HR hr, String description, Area area, int monthlyPay) {
        this.hr = hr;
        this.description = description;
        this.monthlyPay = monthlyPay;
        this.area = area;
        skills = new ArrayList<>();
        ID = lastID+1;
        lastID++;
    }

    public Job(long ID, HR hr, String description, Area area, int monthlyPay, ArrayList<Skills> skills) {
        this.hr = hr;
        this.description = description;
        this.area = area;
        this.monthlyPay = monthlyPay;
        this.skills = skills;
        this.ID = ID;
    }

    public void addSkill(Skills skill) {
        skills.add(skill);
    }

    public ArrayList<Skills> getSkills() {
        return skills;
    }

    public HR getHr() {
        return hr;
    }

    public long getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public int getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(int monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    public String toString() {
        return "HR " + hr.getID() +" " + hr.getCompanyName() + "\nArea " + area + "\nDescription " + description;
    }
}
