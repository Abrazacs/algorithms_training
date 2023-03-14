package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Calculator {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            int number = Integer.parseInt(br.readLine());
            int[] dp = new int[number+1];
            int[] operations = new int[number+1];
            dp[1] = 0;
            int min;
            for(int i=2; i<number+1; i++){
                min=dp[i-1]+1;
                operations[i-1] = 1;
                if(i%2==0 && dp[i/2]+1<min) {
                    min=dp[i/2]+1;
                    operations[i-1] = 2;
                }
                if(i%3==0 && dp[i/3]+1<min) {
                    min = dp[i/3]+1;
                    operations[i-1] = 3;
                }
                dp[i] = min;
            }
            System.out.println(dp[number]+"\n");
            int[] answer = new int[dp[number]+1];
            int l = answer.length-1;
            answer[l] = number;
            answer[0] = 1;
            while (l > 0){
                l--;
                switch (operations[number-1]){
                    case 1:
                        number --;
                        break;
                    case 2:
                        number = number/2;
                        break;
                    case 3:
                        number = number/3;
                        break;
                }
                answer[l]=number;
            }
            for (int i = 0; i < answer.length; i++) {
                if(i<answer.length-1){
                    System.out.print(answer[i]+" ");
                }else System.out.print(answer[i]);
            }
        }
    }
}
