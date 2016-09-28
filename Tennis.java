import java.io.*;
import java.util.*;

public class Tennis {
    static int[] score;
    static String[] scoreMap = {"love", "15", "30", "40"};
    static String[] player;

    private static boolean gameOver() {
        return Math.abs(score[0] - score[1]) >= 2
            && Math.max(score[0], score[1]) > 3;
    }

    private static String printScore() {
        if (score[0] >= 3 && score[1] >= 3) {
            if (score[0] == score[1]) {
                return "deuce";
            } else if (score[0] > score[1]) {
                return "advantage " + player[0];
            } else {
                return "advantage " + player[1];
            }
        } else if (score[0] == score[1]) {
            return scoreMap[score[0]] + " all";
        } else {
            String s0 = scoreMap[score[0]];
            String s1 = scoreMap[score[1]];

            return s0 + " " + s1;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while (T-- > 0) {
            score = new int[2];
            player = new String[2];

            int N = scan.nextInt();
            player[0] = scan.next();
            player[1] = scan.next();

            for (int i = 0; i < N; i++) {
                String move = scan.next();
                if (move.equals(player[0])) {
                    score[0] += 1;
                } else {
                    score[1] += 1;
                }

                if (gameOver()) {
                    String winner = score[0] > score[1] ? player[0] : player[1];
                    System.out.println(winner + " won!");
                } else {
                    System.out.println(printScore());
                }
            }
        }
    }
}
