package ArrayList;

public class Student {
    private String name;
    private String studentId;
    private String className;
    private int age;

    public Student() {
    }

    public Student(String name, String studentId, String className, int age) {
        this.name = name;
        this.studentId = studentId;
        this.className = className;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
