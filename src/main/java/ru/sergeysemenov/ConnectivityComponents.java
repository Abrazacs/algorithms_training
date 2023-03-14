package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ConnectivityComponents {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String[] str = br.readLine().split(" ");
            int vertexesQty = Integer.parseInt(str[0]);
            int edgesQty = Integer.parseInt(str[1]);
            ArrayList<Integer>[] graph = new ArrayList[vertexesQty + 1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            Map<Integer, Set<Integer>> mapOfComponents = new HashMap<>();
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
            int comp = 1;
            for (int i = 1; i < graph.length; i++) {
                if(!visited[i]) {
                    dfs(graph, visited, mapOfComponents, i, comp);
                    comp++;
                }
            }
            Set<Integer> setOfComponents = mapOfComponents.keySet();
            System.out.println(setOfComponents.size());
            for (Integer component:setOfComponents) {
                Set<Integer> setOfVertex = mapOfComponents.get(component);
                System.out.println(setOfVertex.size());
                StringBuilder sb = new StringBuilder();
                setOfVertex.forEach(vertex->{
                    sb.append(vertex).append(" ");
                });
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb);
            }
        }
    }

    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, Map<Integer,Set<Integer>> mapOfComponents, int vertex, int comp){
        visited[vertex] = true;
        if(mapOfComponents.containsKey(comp)){
            mapOfComponents.get(comp).add(vertex);
        }else {
            Set<Integer> setOfVertex = new TreeSet<>();
            setOfVertex.add(vertex);
            mapOfComponents.put(comp, setOfVertex);
        }
        for (int neighbor:graph[vertex]) {
            if(!visited[neighbor]){
                dfs(graph, visited, mapOfComponents,neighbor, comp);
            }
        }
    }
}
