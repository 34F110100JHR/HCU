package String;

import java.util.Random;

public class 验证码 {
    public static void main(String[] args) {
        String datas = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String code = "";

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int index = r.nextInt(datas.length());
            char c = datas.charAt(index);
            code += c;
        }
        System.out.println(code);
    }
}
