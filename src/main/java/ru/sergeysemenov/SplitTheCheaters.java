package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class SplitTheCheaters {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String[] str = br.readLine().split(" ");
            int vertexesQty = Integer.parseInt(str[0]);
            int edgesQty = Integer.parseInt(str[1]);
            ArrayList<Integer>[] graph = new ArrayList[vertexesQty + 1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            int[] vertexColor = new int[vertexesQty+1];
            int count = 0;
            while (count!=edgesQty){
                String[] s = br.readLine().split(" ");
                int vertexA = Integer.parseInt(s[0]);
                int vertexB = Integer.parseInt(s[1]);
                graph[vertexA].add(vertexB);
                graph[vertexB].add(vertexA);
                count++;
            }
            boolean[] visited = new boolean[vertexesQty+1];
            boolean flag = true;
            for (int i = 1; i <graph.length ; i++) {
                flag = dfs(graph,visited,i,vertexColor,flag, 1);
                if(!flag) break;
            }
            System.out.println(flag?"YES":"NO");
        }
    }

    public static boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, int vertex, int[] vertexColor, boolean flag, int color){
        visited[vertex] = true;
        if(vertexColor[vertex]==0){
            vertexColor[vertex] = color;
        }
        for (int neighbor:graph[vertex]) {
            if(vertexColor[neighbor] == vertexColor[vertex] && flag){
                return false;
            }
            if(!visited[neighbor] && flag){
               flag = dfs(graph, visited,neighbor, vertexColor,flag, 3-vertexColor[vertex]);
            }
        }
        return flag;
    }
}
