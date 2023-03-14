package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TheLongestJointSubSequence {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            int firstLength = Integer.parseInt(br.readLine().trim());
            int[] first = new int[firstLength+1];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 1; i < str.length+1; i++) {
                first[i] = Integer.parseInt(str[i-1]);
            }
            int secondLength = Integer.parseInt(br.readLine().trim());
            int[] second = new int[secondLength+1];
            str = br.readLine().trim().split(" ");
            for (int i = 1; i < str.length+1; i++) {
                second[i] = Integer.parseInt(str[i-1]);
            }
            int[][] dp = new int[firstLength+1][secondLength+1];
            for (int i = 0; i < secondLength+1; i++) {
                dp[0][i] = 0;
            }
            for (int i = 1; i < firstLength+1; i++) {
                dp[i][0] = 0;
            }
            for (int i = 1; i <firstLength+1 ; i++) {
                for (int j = 1; j < secondLength+1; j++) {
                    if(first[i] == second[j]){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            ArrayList<Integer> answer = new ArrayList<>();
            int i = firstLength;
            int j = secondLength;
            if(dp[i][j]!=0) {
                while (i > 0 && j > 0) {
                    if (first[i] == second[j]) {
                        answer.add(first[i]);
                        i--;
                        j--;
                    } else if (dp[i - 1][j] == dp[i][j]) {
                        i--;
                    } else j--;
                }
                for (int k = answer.size()-1; k >-1 ; k--) {
                    if(k>=1) {
                        System.out.print(answer.get(k)+" ");
                    }else System.out.print(answer.get(k));
                }
            }
        }
    }
}
