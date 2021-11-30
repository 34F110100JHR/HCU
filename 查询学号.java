package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class 查询学号 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("刘德华", "0604180230", "软件工程  ", 20));
        students.add(new Student("张学友", "0604180231", "物联网工程", 20));
        students.add(new Student("郭富城", "0604180232", "计算机技术", 20));
        students.add(new Student("黎明  ", "0604180233", "通信工程  ", 20));
        System.out.println("姓名" + "\t\t\t" + "学号" + "\t\t\t\t" + "专业" + "\t\t\t\t" + "年龄");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student.getName() + "\t\t" + student.getStudentId() +
                    "\t\t" + student.getClassName() + "\t\t" + student.getAge());

        }
        while (true) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查询学号：");
        String Id = sc.next();

        Student student = getStudentIdByName(students, Id);

            if (student == null) {
                System.out.println("查无此人！");
            } else {
                System.out.println(student.getName() + "\t\t" + student.getStudentId() +
                        "\t\t" + student.getClassName() + "\t\t" + student.getAge());
            }
        }
    }
    public static Student getStudentIdByName(ArrayList<Student> students, String studentId) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}