package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GoodString {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            int lettersQty = Integer.parseInt(br.readLine());
            int x = 0;
            Map<Integer, Integer> map = new HashMap<>();
            do{
                x++;
                map.put(x, Integer.parseInt(br.readLine()));
            }while (x!=lettersQty);
            Set<Integer> alphabet = map.keySet();
            long goodness = 0;
            long prev = map.get(1);
            for (int i = 1; i <alphabet.size(); i++) {
                long current = map.get(i+1);
                goodness = current>prev? goodness+prev : goodness+current;
                prev = current;
            }
            System.out.println(goodness);
        }catch (IOException e){

        }
    }
}
