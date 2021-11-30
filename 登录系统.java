package String;

import java.util.Scanner;

public class 登录系统 {
    public static void main(String[] args) {
        String okName = "huiLaoQing";
        String okPassword = "000000";

        for (int i = 1; i <= 3; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String name = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();

            if (name.equals(okName)) {

                if( password.equals(okPassword)){
                    System.out.println("登录成功！");
                }else{
                    System.out.println("密码错误！");
                    System.out.println("还剩" + (3 - i) +"次机会");
                    System.out.println();
                }
            } else {
                System.out.println("用户名错误！");

                System.out.println("还剩" + (3 - i) +"次机会");
                System.out.println();
            }

        }
    }
}
