package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class GreatLinelandRelocation {

    public static void main(String[] args) throws IOException {
        class City{
            int index;
            int cost;
            public City(int index, int cost){
                this.index = index;
                this.cost = cost;
            }
        }
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            int qty = Integer.parseInt(br.readLine());
            int i = 0;
            int[] result = new int[qty];
            Stack<City> cities = new Stack<>();
            for (String s:br.readLine().split(" ")) {
                City city = new City(i, Integer.parseInt(s));
                while (!cities.isEmpty() && cities.peek().cost>city.cost){
                    City res = cities.pop();
                    result[res.index] = i;
                }
                cities.push(city);
                i++;
            }
            while (!cities.isEmpty()){
                City city = cities.pop();
                result[city.index] = -1;
            }
            for (int j = 0; j < qty; j++) {
                if(j!=qty-1){
                    System.out.print(result[j]+" ");
                }else System.out.print(result[j]);
            }
        }
    }
}
