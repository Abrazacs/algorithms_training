package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Fleas {

    static class Vertex{
        int number;
        boolean visited = false;
        int step;
        public Vertex(int number){
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            Vertex[][] field = new Vertex[n][m];
            int number = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    field[i][j] = new Vertex(number);
                    number++;
                }
            }
            ArrayList<Vertex>[] graph = new ArrayList[n*m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    graph[field[i][j].number] = new ArrayList<>();
                    if(i>1 && j>0 ) graph[field[i][j].number].add(field[i-2][j-1]);
                    if(i>1 && j<m-1) graph[field[i][j].number].add(field[i-2][j+1]);
                    if(i>0 && j<m-2) graph[field[i][j].number].add(field[i-1][j+2]);
                    if(i>0 && j>1) graph[field[i][j].number].add(field[i-1][j-2]);
                    if(i<n-1 && j>1) graph[field[i][j].number].add(field[i+1][j-2]);
                    if(i<n-1 && j<m-2) graph[field[i][j].number].add(field[i+1][j+2]);
                    if(i<n-2 && j>0) graph[field[i][j].number].add(field[i+2][j-1]);
                    if(i<n-2 && j<m-1) graph[field[i][j].number].add(field[i+2][j+1]);
                }
            }
            int startI = Integer.parseInt(str[2])-1;
            int startJ = Integer.parseInt(str[3])-1;
            int qty = Integer.parseInt(str[4]);
            int step = 0;
            field[startI][startJ].visited=true;
            field[startI][startJ].step= step;
            ArrayList<Vertex>[] distance = new ArrayList[n*m];
            distance[0] = new ArrayList<>();
            distance[0].add(field[startI][startJ]);
            for (int i = 0; i < distance.length-1; i++) {
                bfs(graph, distance,step);
                step++;
            }
            int sumDistance = 0;
            while (qty!=0){
                String[] s = br.readLine().split(" ");
                int fleaI = Integer.parseInt(s[0])-1;
                int fleaJ = Integer.parseInt(s[1])-1;
                if(field[fleaI][fleaJ].visited){
                    sumDistance += field[fleaI][fleaJ].step;
                }else {
                    sumDistance = -1;
                    break;
                }
                qty--;
            }
            System.out.println(sumDistance);
        }
    }

    public static void bfs(ArrayList<Vertex>[]graph, ArrayList<Vertex>[] distance, int step){
        distance[step+1] = new ArrayList<>();
        for (Vertex vertex: distance[step]) {
            for (Vertex neighbor: graph[vertex.number]) {
                if(!neighbor.visited){
                    neighbor.visited = true;
                    neighbor.step = step+1;
                    distance[step+1].add(neighbor);
                }
            }
        }
    }
}
