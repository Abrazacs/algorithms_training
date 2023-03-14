package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BeautifulString {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            int qty = Integer.parseInt(br.readLine());
            char[] characters = br.readLine().toCharArray();
            Set<Character> charSet = new HashSet<>();
            for (char c : characters){
                charSet.add(c);
            }
            int maxChain=0;
            for (Character c: charSet){
                int replacementsQty = qty;
                int leftPointer = 0;
                int rightPointer = 0;
                for (int i = 0; i <characters.length; i++ ) {
                   if(i>0 && characters[i-1]!=c){
                       replacementsQty++;
                   }
                   leftPointer = i;
                   while (characters[rightPointer]==c || replacementsQty>0){
                       if(characters[rightPointer]==c){
                           rightPointer++;
                       }else {
                           if(replacementsQty>0){
                               rightPointer++;
                               replacementsQty--;
                           }
                       }
                       if(rightPointer==characters.length){
                           break;
                       }
                   }
                   int tempQty = rightPointer-leftPointer;
                   if(maxChain<tempQty) maxChain = tempQty;
                   if(rightPointer == characters.length) i = rightPointer;
                }
            }
            System.out.print(maxChain);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
