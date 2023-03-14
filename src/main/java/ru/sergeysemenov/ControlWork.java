package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControlWork {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            int studentsQty = Integer.parseInt(br.readLine());
            int variantsQty = Integer.parseInt(br.readLine());
            int index = Integer.parseInt(br.readLine());
            int colon = Integer.parseInt(br.readLine());
            int maxIndex = 0;
            if(studentsQty%2==0){
                maxIndex = studentsQty/2;
            }else {
                maxIndex = studentsQty/2+1;
            }
            solution(maxIndex,studentsQty,index,colon,variantsQty);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solution(int maxIndex, int studentsQty, int index, int colon, int variantsQty){
        int bestOption;
        int worstOption;
        if(variantsQty%2==0){
            bestOption = index+variantsQty/2;
            worstOption = index-variantsQty/2;
            if(bestOption<maxIndex){
                System.out.println(bestOption+" "+colon);
            }else if(bestOption==maxIndex && studentsQty%2==0){
                System.out.println(bestOption+" "+colon);
            } else if (bestOption==maxIndex && studentsQty%2==1 && colon==1) {
                System.out.println(bestOption+" "+colon);
            } else if (worstOption>0) {
                System.out.println(worstOption+" "+colon);
            } else System.out.println(-1);
        }else {
            if(colon==1){
                bestOption = index+variantsQty/2;
                worstOption = index-variantsQty/2-1;
                if(bestOption<maxIndex){
                    System.out.println(bestOption+" "+(colon+1));
                } else if (bestOption == maxIndex && studentsQty%2==0) {
                    System.out.println(bestOption+" "+(colon+1));
                } else if (worstOption>0){
                    System.out.println(worstOption+" "+(colon+1));
                } else {
                    System.out.println(-1);
                }
            } else {
                bestOption = index-variantsQty/2;
                worstOption = index+variantsQty/2+1;
                if(bestOption>0) System.out.println(bestOption+" "+(colon-1));
                else if (worstOption<=maxIndex) {
                    System.out.println(worstOption+" "+(colon-1));
                } else System.out.println(-1);
            }
        }
    }
}
