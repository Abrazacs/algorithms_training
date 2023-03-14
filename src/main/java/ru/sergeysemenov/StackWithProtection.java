package ru.sergeysemenov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class StackWithProtection {

    public static void main(String[] args) throws IOException {
        Stack<Long> stack = new Stack<>();
        List<String> str = Files.readAllLines(Paths.get("input.txt"));
        first:
        {
            for (String s : str) {
                String[] strings = s.split(" ");
                switch (strings[0]) {
                    case "push":
                        stack.push(Long.parseLong(strings[1]));
                        System.out.println("ok");
                        break;
                    case "pop":
                        if (stack.empty()) {
                            System.out.println("error");
                        } else {
                            System.out.println(stack.pop());
                        }
                        break;
                    case "back":
                        if (stack.empty()) {
                            System.out.println("error");
                        } else {
                            System.out.println(stack.peek());
                        }
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "clear":
                        stack.clear();
                        System.out.println("ok");
                        break;
                    case "exit":
                        System.out.println("bye");
                        break first;
                    default:
                        System.out.println(1);
                }
                if (strings[0].equals("exit")) break;
            }
        }
    }
}
