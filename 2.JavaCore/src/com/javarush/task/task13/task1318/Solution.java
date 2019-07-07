package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader consoleIn = null;
        InputStream input = null;
        
        
        consoleIn = new BufferedReader(new InputStreamReader(System.in));
        //String path = consoleIn.readLine();
        String path = "C:\\AiOLog.txt";
        
        input = new FileInputStream(path);
        BufferedInputStream buffer = new BufferedInputStream(input);
        
        while (buffer.available() > 0) {
            System.out.print((char)buffer.read());
            
        }
        
        consoleIn.close();
        input.close();
    
    
        //  C:\AiOLog.txt
    }
}