package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
        }
    
        try (FileReader reader = new FileReader(fileName)) {
            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                int x = reader.read();
                if ((char)x == '\r') {
                    continue;
                }
                if ((char)x == '\n') {
                    System.out.println(sb.reverse().toString());
                    sb.setLength(0);
                }
                sb.append((char) x);
            }
            System.out.println(sb.reverse().toString());
        } catch (IOException e) {
        }
    }
}


/*

C:/1/1.txt

 */