package ru.sergeysemenov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class SimpleNetworkTimeProtocol {

    public static void main(String[] args) {
        BigDecimal day = new BigDecimal(24*3600);
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            BigDecimal secondsA = convertToSeconds(br.readLine());
            BigDecimal secondsB = convertToSeconds(br.readLine());
            BigDecimal secondsC = convertToSeconds(br.readLine());
            BigDecimal answ;
            if(secondsA.min(secondsC).equals(secondsA)){
                answ = secondsC.subtract(secondsA).divide(new BigDecimal(2));
            }else {
                answ = secondsC.add(day).subtract(secondsA).divide(new BigDecimal(2));
            }
            answ = answ.add(secondsB);
            if (!answ.min(day).equals(answ)){
                answ = answ.subtract(day);
            }
            System.out.println(bigDecimalToString(answ));
        }catch (IOException e){

        }
    }
    private static BigDecimal convertToSeconds(String readLine) {
        String [] s = readLine.split(":");
        return new BigDecimal(Integer.parseInt(s[0])*3600+Integer.parseInt(s[1])*60 +Integer.parseInt(s[2]));

    }
    private static String bigDecimalToString(BigDecimal answ){
        int seconds = answ.intValue();
        if(answ.subtract(new BigDecimal(seconds)).compareTo(BigDecimal.valueOf(0.4d))==1){
            seconds++;
        }
        int hours = seconds/3600;
        int min = (seconds-hours*3600)/60;
        int sec = seconds-hours*3600-min*60;
        return intToString(hours)+":"+intToString(min)+":"+intToString(sec);
    }
    private static String intToString(int i){
        if(i<10) return "0"+i;
        return Integer.toString(i);
    }
}
