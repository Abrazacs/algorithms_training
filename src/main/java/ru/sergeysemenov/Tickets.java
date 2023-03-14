package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tickets {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            int qty = Integer.parseInt(br.readLine());
            int[][] data = new int[qty][3];
            int count = 0;
            while (count != qty){
                String[] str = br.readLine().split(" ");
                for (int i = 0; i < str.length; i++) {
                    data[count][i] = Integer.parseInt(str[i]);
                }
                count++;
            }
            int[] dp = new int[qty];
            dp[0] = data[0][0];
            if(qty==2){
                dp[1] = Math.min(dp[0] + data[1][0], data[0][1]);
            } else if(qty>2) {
                dp[1] = Math.min(dp[0] + data[1][0], data[0][1]);
                int min = Math.min(dp[1] + data[2][0], dp[0] + data[1][1]);
                dp[2] = Math.min(min, data[0][2]);
                for (int i = 3; i < dp.length; i++) {
                    min = dp[i - 1] + data[i][0];
                    min = Math.min(min, dp[i - 2] + data[i - 1][1]);
                    dp[i] = Math.min(min, dp[i - 3] + data[i - 2][2]);
                }
            }
            System.out.println(dp[qty - 1]);
        }
    }
}
