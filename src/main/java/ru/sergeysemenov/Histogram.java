package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Histogram {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            Map<Integer, Integer> map = new TreeMap<>();
            StringBuilder sb = new StringBuilder();
            br.lines().forEach(sb::append);
            int maxValue = 0;
            char[] characters = sb.toString().replaceAll("\\s","").toCharArray();
            for (char c: characters) {
                int ascii = (int) c;
                if (map.containsKey(ascii)) {
                    int qty = map.get(ascii) + 1;
                    map.put(ascii, qty);
                    if (qty > maxValue) maxValue = qty;
                } else {
                    map.put(ascii, 1);
                    if(maxValue<1) maxValue =1;
                }
            }
            Set<Integer> set = map.keySet();
            while (maxValue!=0){
                for (Integer i: set) {
                    if(map.get(i)<maxValue){
                        System.out.print(" ");
                    }else System.out.print("#");
                }
                maxValue--;
                System.out.print("\n");
            }
            for (Integer i: set) {
                int x = i;
                char c = (char)x;
                System.out.print(c);
             }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
