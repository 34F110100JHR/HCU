package String;

import java.util.Scanner;

public class 截取 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机号:");
        String tel = sc.next();

        String before = tel.substring(0, 3);
        String after = tel.substring(7);

        System.out.println(before + "****" + after);
    }
}
