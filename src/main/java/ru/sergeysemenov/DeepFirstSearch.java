package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class DeepFirstSearch {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            String[]str = br.readLine().split(" ");
            int vertexesQty = Integer.parseInt(str[0]);
            int edgesQty = Integer.parseInt(str[1]);
            ArrayList<Integer>[] graph = new ArrayList[vertexesQty+1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            int count = 1;
            while (count!=edgesQty+1){
                String[] s = br.readLine().split(" ");
                int vertexA = Integer.parseInt(s[0]);
                int vertexB = Integer.parseInt(s[1]);
                graph[vertexA].add(vertexB);
                graph[vertexB].add(vertexA);
                count++;
            }
            boolean[] visited = new boolean[vertexesQty+1];
            Set<Integer> firstComponent = new TreeSet<>();
            int comp = 1;
            for (int i = 1; i < graph.length ; i++) {
                dfs(graph,visited,firstComponent,i,comp);
                comp++;
            }
            StringBuilder sb = new StringBuilder();
            firstComponent.forEach(vertex->{
                sb.append(vertex+" ");
            });
            sb.deleteCharAt(sb.length()-1);
            System.out.println(firstComponent.size());
            System.out.println(sb);
        }
    }

    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, Set<Integer> firstComponent, int vertex, int comp){
        visited[vertex] = true;
        if(comp==1) {
            firstComponent.add(vertex);
        }
        for (int neighbor:graph[vertex]) {
            if(!visited[neighbor]){
                dfs(graph, visited, firstComponent,neighbor, comp);
            }
        }
    }
}
