package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumInRectangle {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);
            int[][] sums = new int[x][y];
            int counter = 0;
            while (counter!=x){
                String[] line = br.readLine().split(" ");
                for (int i = 0; i < line.length; i++) {
                    if(i==0){
                        sums[counter][i] = Integer.parseInt(line[i]);
                    }else {
                        sums[counter][i] = Integer.parseInt(line[i]) + sums[counter][i-1];
                    }
                }
                counter++;
            }

            while (k!=0){
                String[] s = br.readLine().split(" ");
                int x1 = Integer.parseInt(s[0]);
                int y1 = Integer.parseInt(s[1]);
                int x2 = Integer.parseInt(s[2]);
                int y2 = Integer.parseInt(s[3]);
                int answer=0;
                for (int i = x1-1; i <x2 ; i++) {
                    if(y1-1>0){
                        answer += sums[i][y2-1]-sums[i][y1-2];
                    }else {
                        answer += sums[i][y2-1];
                    }
                }
                System.out.println(answer);
                k--;
            }
        }catch (IOException e){
        }
    }
}
