package com.javarush.task.task31.task3113;



import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.Scanner;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new InputStreamReader(System.in));
        Path rootDir = Paths.get(scan.next());
        if (!Files.isDirectory(rootDir)) {
            System.out.println(rootDir.toAbsolutePath().toString() + " - не папка");
        } else {
            MyFileVisitor fileVisitor = new MyFileVisitor();
            Files.walkFileTree(rootDir, fileVisitor);
            
            System.out.println();
            System.out.println("Всего папок - " + (fileVisitor.getDirs() - 1));
            System.out.println("Всего файлов - " + fileVisitor.getFiles());
            System.out.println("Общий размер - " + fileVisitor.getSize());
        }
    }
    
    
}

