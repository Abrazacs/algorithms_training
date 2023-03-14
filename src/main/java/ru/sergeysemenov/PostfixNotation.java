package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PostfixNotation {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            Set<String> actionsSet = new HashSet<>();
            actionsSet.add("+");
            actionsSet.add("-");
            actionsSet.add("*");
            Stack<Long> stack = new Stack<>();
            String[] str = br.readLine().trim().split(" ");
            for (String s: str) {
                if(!actionsSet.contains(s)){
                    stack.push(Long.parseLong(s));
                }else {
                    Long B = stack.pop();
                    Long A = stack.pop();
                    switch (s){
                        case "+":
                            stack.push(A+B);
                            break;
                        case "-":
                            stack.push(A-B);
                            break;
                        case "*":
                            stack.push(A*B);
                            break;
                    }
                }
            }
            System.out.println(stack.peek());
        }catch (IOException ignored){
        }
    }
}
