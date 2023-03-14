package ru.sergeysemenov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DequeWithProtection {

    public static void main(String[] args) throws IOException {
        Deque<Long> deque = new ArrayDeque<>();
        List<String> str = Files.readAllLines(Paths.get("input.txt"));
        first:
        {
            for (String s : str) {
                String[] strings = s.split(" ");
                switch (strings[0]) {
                    case "push_front":
                        deque.addFirst(Long.parseLong(strings[1]));
                        System.out.println("ok");
                        break;
                    case "push_back":
                        deque.addLast(Long.parseLong(strings[1]));
                        System.out.println("ok");
                        break;
                    case "pop_front":
                        if (deque.isEmpty()) {
                            System.out.println("error");
                        } else {
                            System.out.println(deque.pollFirst());
                        }
                        break;
                    case "pop_back":
                        if (deque.isEmpty()) {
                            System.out.println("error");
                        } else {
                            System.out.println(deque.pollLast());
                        }
                        break;
                    case "front":
                        if (deque.isEmpty()) {
                            System.out.println("error");
                        } else {
                            System.out.println(deque.peekFirst());
                        }
                        break;
                    case "back":
                        if (deque.isEmpty()) {
                            System.out.println("error");
                        } else {
                            System.out.println(deque.peekLast());
                        }
                        break;
                    case "size":
                        System.out.println(deque.size());
                        break;
                    case "clear":
                        deque.clear();
                        System.out.println("ok");
                        break;
                    case "exit":
                        System.out.println("bye");
                        break first;
                }
            }
        }
    }

}
