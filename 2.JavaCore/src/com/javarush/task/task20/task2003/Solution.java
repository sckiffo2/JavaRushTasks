package com.javarush.task.task20.task2003;

import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        System.out.println("Enter filename:");
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {}
    
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            load(inputStream);
        } catch (Exception e) {
        
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties myprop = new Properties();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            myprop.setProperty(entry.getKey(), entry.getValue());
        }
        myprop.save(outputStream,"comment");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties myprop = new Properties();
        myprop.load(inputStream);
        properties = new HashMap<String, String>((Map) myprop);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        try (FileOutputStream outputStream = new FileOutputStream("1.properties")) {
            sol.save(outputStream);
        } catch (Exception e) {}
        sol.fillInPropertiesMap();
        
    }
}
