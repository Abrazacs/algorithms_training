package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HeapSort {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            int qty = Integer.parseInt(br.readLine());
            String [] str = br.readLine().split(" ");
            int[] arr = new int[qty];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            heapSort(arr);
            for (int i = 0; i < arr.length; i++) {
                if(i!=arr.length-1){
                    System.out.print(arr[i]+" ");
                }else  System.out.print(arr[i]);
            }

        }
    }
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i=n-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
}
