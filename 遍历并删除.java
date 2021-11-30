package ArrayList;

import java.util.ArrayList;

public class 遍历并删除 {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(99);
        scores.add(88);
        scores.add(67);
        scores.add(78);
        scores.add(100);
        scores.add(87);
        System.out.println(scores);
        for (int i = scores.size() - 1; i > 0; i--) {
            int score = scores.get(i);
            if(score < 80){
                scores.remove(i);
            }
        }
        System.out.println(scores);

    }
}
