package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MinRectangle {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            int qty = Integer.parseInt(br.readLine());
            int[] xCoordinates = new int[qty];
            int[] yCoordinates = new int[qty];
            int x = 0;
            while (x!=qty){
                String[] str = br.readLine().split(" ");
                xCoordinates[x] = Integer.parseInt(str[0]);
                yCoordinates[x] = Integer.parseInt(str[1]);
                x++;
            }
            Arrays.parallelSort(xCoordinates);
            Arrays.parallelSort(yCoordinates);
            System.out.println(xCoordinates[0]+" "+yCoordinates[0]+" "+xCoordinates[x-1]+" "+yCoordinates[x-1]);
        }catch (IOException e){
        }
    }
}
