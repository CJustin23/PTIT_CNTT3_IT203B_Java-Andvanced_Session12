package btvn.bt5.model;
public class Patient {
    private int id;
    private String name;
    private int age;
    private String department;
    private int days;

    public Patient(int id, String name, int age, String department, int days) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.days = days;
    }

    public Patient(String name, int age, String department, int days) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.days = days;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public int getDays() { return days; }
}