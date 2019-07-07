package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String path = null;
        try {
            path = consoleReader.readLine();
            //path = "C:\1\1.txt";
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        File file = null;
        FileWriter fileWriter = null;
        BufferedWriter writer = null;
        
        try {
            file = new File(path);
            file.createNewFile();
            fileWriter = new FileWriter(file);
            writer = new BufferedWriter(fileWriter);
            while (true) {
                String str = consoleReader.readLine();
                writer.write(str);
                writer.write("\n\r");
                if (str.equals("exit")) {
                    writer.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    
    }
}
