package parameters;

public class Student {
    private int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return studentId;
    }
    public void setId(int studentId) {
        this.studentId = studentId;
    }
    public void set(Student s){
        this.studentId=s.getId();
        this.name=s.getName();
    }
}