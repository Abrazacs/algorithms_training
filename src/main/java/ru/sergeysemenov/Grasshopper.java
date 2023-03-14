package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Grasshopper {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String[] str = br.readLine().split(" ");
            int qty = Integer.parseInt(str[0]);
            int maxJump = Integer.parseInt(str[1]);
            int[] dp = new int[qty];
            dp[0] = 1;
            if (qty > 1) {
                dp[1] = 1;
                int min = Math.min(qty, maxJump);
                for (int i = 2; i < min; i++) {
                    int value = 0;
                    for (int j = 0; j < i; j++) {
                        value += dp[j];
                    }
                    dp[i] = value;
                }
                for (int i = maxJump; i < qty; i++) {
                    int value = 0;
                    for (int j = i - maxJump; j < i; j++) {
                        value += dp[j];
                    }
                    dp[i] = value;
                }
            }
            System.out.println(dp[qty - 1]);
        }
    }
}
