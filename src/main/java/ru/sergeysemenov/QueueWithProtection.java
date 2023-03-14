package ru.sergeysemenov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueWithProtection {
    public static void main(String[] args) throws IOException {
        Queue<Long> queue = new LinkedList<>();
        List<String> str = Files.readAllLines(Paths.get("input.txt"));
        first:{
            for (String s:str) {
                String[] strings = s.split(" ");
                switch (strings[0]){
                    case "push":
                        queue.add(Long.parseLong(strings[1]));
                        System.out.println("ok");
                        break;
                    case "pop":
                        if(queue.isEmpty()){
                            System.out.println("error");
                        }else {
                            System.out.println(queue.remove());
                        }
                        break;
                    case "front":
                        if(queue.isEmpty()){
                            System.out.println("error");
                        }else {
                            System.out.println(queue.peek());
                        }
                        break;
                    case "size":
                        System.out.println(queue.size());
                        break;
                    case "clear":
                        queue.clear();
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
