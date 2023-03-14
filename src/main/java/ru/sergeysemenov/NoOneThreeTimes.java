package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class NoOneThreeTimes {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            int length = Integer.parseInt(br.readLine());
            List<Integer> dp = new ArrayList<>();
            dp.add(2);
            dp.add(4);
            dp.add(7);
            for (int i = 3; i <length; i++) {
                dp.add(dp.get(i-3)+dp.get(i-2)+dp.get(i-1));
            }
            System.out.println(dp.get(length-1));
        }
    }
}
