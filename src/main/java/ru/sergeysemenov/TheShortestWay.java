package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TheShortestWay {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            int qty = Integer.parseInt(br.readLine());
            int count = 1;
            ArrayList<Integer>[] graph = new ArrayList[qty+1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            while (count!=qty+1){
                String[] str = br.readLine().split(" ");
                for (int i = 0; i<str.length;i++) {
                    int value = Integer.parseInt(str[i]);
                    if(value==1){
                        graph[count].add(i+1);
                    }
                }
                count++;
            }
            String[] str = br.readLine().split(" ");
            int begin = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            if (begin == end){
                System.out.println(0);
            }else {
                int[] previousVertex = new int[qty+1];
                boolean[] visited = new boolean[qty + 1];
                ArrayList<Integer>[] distance = new ArrayList[qty + 1];
                distance[0] = new ArrayList<>();
                distance[0].add(begin);
                previousVertex[begin] = -1;
                visited[begin] = true;
                int steps = 0;
                for (int i = 0; i < distance.length - 1; i++) {
                    if (bfs(graph, visited, distance, i, end, previousVertex)) {
                        steps=i+1;
                        break;
                    }
                }
                if (steps!=0) {
                    System.out.println(steps);
                    StringBuilder sb = new StringBuilder();
                    while (previousVertex[end]!=-1){
                        sb.append(end).append(" ");
                        end = previousVertex[end];
                    }
                    sb.append(begin);
                    System.out.println(sb.reverse());
                }else {
                    System.out.println(-1);
                }
            }
        }
    }

    public static boolean bfs(ArrayList<Integer>[] graph, boolean[] visited, ArrayList<Integer>[] distance, int step, int end, int[] previousVertex){
        distance[step+1] = new ArrayList<>();
        for (int vertex: distance[step]) {
            for (int neighbor:graph[vertex]) {
                if(!visited[neighbor]){
                    previousVertex[neighbor]=vertex;
                    visited[neighbor] = true;
                    distance[step+1].add(neighbor);
                }if (neighbor == end) return true;
            }
        }
        return false;
    }
}
