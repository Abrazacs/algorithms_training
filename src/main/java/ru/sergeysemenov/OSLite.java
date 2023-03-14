package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class OSLite {

    public static void main(String[] args) {
        class OperatingSystem {
            int start;
            int end;
        }
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            int sectorsQty = Integer.parseInt(br.readLine());
            int installationQty = Integer.parseInt(br.readLine());
            List<OperatingSystem> list = new ArrayList<>();
            while (installationQty != 0) {
                OperatingSystem os = new OperatingSystem();
                String[] strings = br.readLine().split(" ");
                os.start = Integer.parseInt(strings[0]);
                os.end = Integer.parseInt(strings[1]);
                List<OperatingSystem> toRemove = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    OperatingSystem operatingSystem = list.get(i);
                    if(operatingSystem.start>=os.start && operatingSystem.start<= os.end){
                        toRemove.add(operatingSystem);
                    }else if(operatingSystem.end>=os.start && operatingSystem.start<= os.end){
                        toRemove.add(operatingSystem);
                    }
                }
                list.removeAll(toRemove);
                list.add(os);
                installationQty--;
            }
            System.out.println(list.size());
        }catch (IOException e){
        }
    }
}
