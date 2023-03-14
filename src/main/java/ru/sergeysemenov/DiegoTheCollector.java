package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class DiegoTheCollector {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            int labelsQty = Integer.parseInt(br.readLine());
            String strOfNum = br.readLine();
            int guestsQty = Integer.parseInt(br.readLine());
            if(labelsQty>0){
                Set<String> setOfStr = new HashSet<>();
                List<Integer> numbers = new ArrayList<>();
                for (String s:strOfNum.split(" ")) {
                   if(!setOfStr.contains(s)){
                       numbers.add(Integer.parseInt(s));
                       setOfStr.add(s);
                   }
                }
                Integer[] numArr = numbers.toArray(new Integer[numbers.size()]);
                Arrays.parallelSort(numArr);
                int [] limits = new int[guestsQty];
                String [] strings = br.readLine().split(" ");
                for (int i = 0; i < guestsQty; i++) {
                    limits[i] = Integer.parseInt(strings[i]);
                }
                for (int limit:limits) {
                    System.out.println(binarySearch(numArr,0,numArr.length-1,limit));
                }
            }else {
                while (guestsQty != 0){
                    System.out.println(0);
                    guestsQty--;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int binarySearch (Integer[] arr, int from, int to, int maxLimit){
        if((to-from) == 1 || to==from){
            if(arr[to]<maxLimit) return to+1;
            else if(arr[from]<maxLimit)return from+1;
            else return 0;
        }
        int idx = (from+to)/2;
        if(arr[idx]>maxLimit){
            return binarySearch(arr,from,idx,maxLimit);
        }else if(arr[idx]==maxLimit){
            return idx;
        }else {
            return binarySearch(arr, idx,to,maxLimit);
        }
    }
}


