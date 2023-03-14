package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Rummy {
    public static void main(String[] args) throws IOException {
        class Card implements Comparable<Card>{
            int value;
           public Card(int value){
               this.value = value;
           }

            @Override
            public int compareTo(Card o) {
                if(value==0 && o.value == 9) return 1;
                else if (value == 9 && o.value == 0) {
                   return -1;
                }else return Integer.compare(value,o.value);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            Queue<Card> firstPlayer = new LinkedList<>();
            Queue<Card> secondPlayer = new LinkedList<>();
            for (String s : br.readLine().split(" ")) {
                firstPlayer.add(new Card(Integer.parseInt(s)));
            }
            for (String s : br.readLine().split(" ")) {
                secondPlayer.add(new Card(Integer.parseInt(s)));
            }
            int round = 0;
            while (firstPlayer.size()>0 && secondPlayer.size()>0) {
                Card first = firstPlayer.remove();
                Card second = secondPlayer.remove();
                if(first.compareTo(second) > 0){
                    firstPlayer.add(first);
                    firstPlayer.add(second);
                }else {
                    secondPlayer.add(first);
                    secondPlayer.add(second);
                }
                round++;
                if(round == 1000000){
                    System.out.println("botva");
                    break;
                }
            }
            String winner = firstPlayer.isEmpty()? "second":"first";
            System.out.println(winner+" "+round);
        }
    }
}

