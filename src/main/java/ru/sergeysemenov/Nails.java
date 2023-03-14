package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Nails {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            int qty = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] arr = new int[qty];
            for (int i = 0; i < qty; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(arr);
            if(qty==2){
                System.out.println(arr[1]-arr[0]);
            }else {
                int[] dp = new int[qty-1];
                dp[0] = arr[1] - arr[0];
                dp[1] = arr[2] - arr[1] + dp[0];
                for (int i = 2; i < dp.length; i++) {
                    dp[i] = Math.min(dp[i-2], dp[i-1])+arr[i+1]-arr[i];
                }
                System.out.println(dp[qty-2]);
            }
        }
    }
}
