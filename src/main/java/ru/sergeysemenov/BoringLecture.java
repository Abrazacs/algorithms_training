package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BoringLecture {
    public static void main(String[] args) {
        try(BufferedReader br= new BufferedReader(new FileReader("input.txt"))){
            char[] chars = br.readLine().toCharArray();
            Map<Character, Long> charQty = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                long qty = (long) (i + 1) *(chars.length-i);
                if(!charQty.containsKey(chars[i])){
                    charQty.put(chars[i], qty);
                }else {
                    qty+=charQty.get(chars[i]);
                    charQty.put(chars[i],qty);
                }
            }
            List<Character> arrayList = new ArrayList<>(charQty.keySet());
            arrayList.sort(Character::compareTo);
            for (Character c : arrayList) {
                System.out.println(c + ": " + charQty.get(c));
            }
        }catch (IOException e){
        }
    }
}
