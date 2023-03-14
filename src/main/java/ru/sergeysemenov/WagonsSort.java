package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
public class WagonsSort {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            int qty = Integer.parseInt(br.readLine());
            String[] numbers = br.readLine().split(" ");
            int[] firstWay = new int[qty];
            for (int i = 0; i < qty; i++) {
                firstWay[i] = Integer.parseInt(numbers[i]);
            }
            int i = 0;
            int temp = 0;
            while (i!=qty){
                if(!stack.isEmpty() && stack.peek()>firstWay[i]){
                    stack.push(firstWay[i]);
                } else if(stack.isEmpty()){
                    stack.push(firstWay[i]);
                } else {
                    break;
                }
                while (!stack.isEmpty() && stack.peek() == temp+1){
                    stack.pop();
                    temp++;
                }

                i++;
            }
            System.out.println(stack.isEmpty()? "YES":"NO");
        }
    }
}
