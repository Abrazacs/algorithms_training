package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String[] str = br.readLine().split(" ");
            int vertexesQty = Integer.parseInt(str[0]);
            int edgesQty = Integer.parseInt(str[1]);
            ArrayList<Integer>[] graph = new ArrayList[vertexesQty + 1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            int count = 0;
            while (count!=edgesQty){
                String[] s = br.readLine().split(" ");
                int vertexA = Integer.parseInt(s[0]);
                int vertexB = Integer.parseInt(s[1]);
                graph[vertexA].add(vertexB);
                count++;
            }
            boolean cycle = false;
            int[] vertexColor = new int[vertexesQty+1];
            List<Integer> topologicalArr = new ArrayList<>();
            boolean[] visited = new boolean[vertexesQty+1];
            for (int i = 1; i < graph.length ; i++) {
                if(cycle) break;
                if (!visited[i]){
                    cycle = dfs(graph, i, visited, topologicalArr, cycle, vertexColor);
                }
            }
            if(!cycle){
                StringBuilder sb = new StringBuilder();
                for (int i = topologicalArr.size()-1; i >-1 ; i--) {
                    sb.append(topologicalArr.get(i)).append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb);
            }else {
                System.out.println(-1);
            }
        }
    }

    private static boolean dfs(ArrayList<Integer>[] graph, int vertex, boolean[] visited, List<Integer> topologicalArr, boolean cycle, int[] vertexColor) {
        visited[vertex] = true;
        vertexColor[vertex] = 1;
        for (int neighbor:graph[vertex]) {
            if(vertexColor[neighbor]==1) return true;
            if(!visited[neighbor] && !cycle){
                cycle = dfs(graph,neighbor,visited,topologicalArr,cycle,vertexColor);
            }
        }
        vertexColor[vertex]=2;
        topologicalArr.add(vertex);
        return cycle;
    }
}
