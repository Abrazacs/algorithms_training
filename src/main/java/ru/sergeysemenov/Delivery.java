package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class Delivery {

    public static void main(String[] args) throws IOException {
        class Pair{
            String goods;
            long qty;
        }
        HashMap<String, Long> goodsWagons = new HashMap<>();
        Stack<Pair> train = new Stack<>();
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            int operations = Integer.parseInt(br.readLine());
            while (operations> 0){
                String [] str = br.readLine().split(" ");
                if(str[0].equals("add")){
                    long wagons = Integer.parseInt(str[1]);
                    if(goodsWagons.containsKey(str[2])){
                        goodsWagons.put(str[2],goodsWagons.get(str[2])+wagons);
                    }else{
                        goodsWagons.put(str[2],wagons);
                    }
                    Pair pair = new Pair();
                    pair.goods =str[2];
                    pair.qty = wagons;
                    train.push(pair);

                } else if (str[0].equals("delete")) {
                    int qOfWagons = Integer.parseInt(str[1]);
                    while (qOfWagons>0 && !train.isEmpty()){
                        Pair pair = train.pop();
                        if(pair.qty>qOfWagons){
                            pair.qty -=qOfWagons;
                            goodsWagons.put(pair.goods, goodsWagons.get(pair.goods)-qOfWagons);
                            train.push(pair);
                            qOfWagons=0;
                        } else if (pair.qty==qOfWagons) {
                            goodsWagons.put(pair.goods, goodsWagons.get(pair.goods)-qOfWagons);
                            qOfWagons=0;
                        } else {
                            goodsWagons.put(pair.goods, goodsWagons.get(pair.goods)- pair.qty);
                            qOfWagons -= pair.qty;
                        }
                    }
                }else {
                    if(goodsWagons.containsKey(str[1])) System.out.println(goodsWagons.get(str[1]));
                    else System.out.println(0);
                }
                operations--;
            }
        }
    }
}
