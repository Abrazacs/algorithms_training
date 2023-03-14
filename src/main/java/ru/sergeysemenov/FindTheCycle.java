package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindTheCycle {

    static class Cycle{
        int begin;
        List<Integer> vertexes = new ArrayList<>();
        boolean isFinished = false;

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            int vertexesQty = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] graph = new ArrayList[vertexesQty + 1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            int count = 0;
            while (count!=vertexesQty) {
                String[] str = br.readLine().split(" ");
                for (int i = 0; i < str.length; i++) {
                    int value = Integer.parseInt(str[i]);
                    if(value==1) {
                        graph[count + 1].add(i+1);
                    }
                }
                count++;
            }
            Cycle cycle = new Cycle();
            int[] vertexColor = new int[vertexesQty+1];
            boolean[] visited = new boolean[vertexesQty+1];
            for (int i = 1; i < graph.length; i++) {
                if(!cycle.vertexes.isEmpty()) break;
                if (!visited[i]){
                    dfs(graph,i,visited,vertexColor,cycle,0);
                }
            }
            if(cycle.vertexes.isEmpty()){
                System.out.println("NO");
            }else {
                System.out.println("YES");
                System.out.println(cycle.vertexes.size());
                StringBuilder sb = new StringBuilder();
                cycle.vertexes.forEach(vertex->{
                    sb.append(vertex).append(" ");
                });
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb);
            }
        }
    }

    private static void dfs(ArrayList<Integer>[] graph, int vertex, boolean[] visited, int[] vertexColor,Cycle cycle, int initialVertex) {
        visited[vertex] = true;
        vertexColor[vertex] = 1;
        for (int neighbor:graph[vertex]) {
            if(neighbor!=initialVertex) {
                if (vertexColor[neighbor] == 1) {
                    cycle.begin=neighbor;
                    cycle.vertexes.add(vertex);
                }
                if (!visited[neighbor] && cycle.vertexes.isEmpty()) {
                    dfs(graph, neighbor, visited, vertexColor, cycle, vertex);
                }
            }
            if(!cycle.vertexes.isEmpty()) break;
        }
        vertexColor[vertex]=2;
        if(!cycle.vertexes.isEmpty() && !cycle.isFinished &&cycle.vertexes.get(cycle.vertexes.size()-1)!=vertex) {
            cycle.vertexes.add(vertex);
            if(vertex==cycle.begin)cycle.isFinished=true;
        }
    }
}
