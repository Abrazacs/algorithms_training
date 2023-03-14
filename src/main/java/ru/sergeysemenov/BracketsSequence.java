package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BracketsSequence {
    public static void main(String[] args)  {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            Map<Character, Character> bracketsMap = new HashMap<>();
            bracketsMap.put('(',')');
            bracketsMap.put('{','}');
            bracketsMap.put('[',']');
            Set<Character> openBracket = bracketsMap.keySet();
            char[] brackets = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char bracket : brackets) {
                if (openBracket.contains(bracket)) stack.push(bracket);
                else if (!stack.isEmpty() && bracketsMap.get(stack.peek()) == bracket) {
                    stack.pop();
                } else {
                    stack.push(bracket);
                    break;
                }
            }
            String str = stack.isEmpty() ? "yes":"no";
            System.out.println(str);
        }catch (IOException ignored){
        }
    }
}
