package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
		List<String> allFilesPatches = new ArrayList<>();

		ArrayList<File> directories = new ArrayList<>();
		File rootDir = new File(root);
		directories.add(rootDir);

		for (int i = 0; i < directories.size(); i++) {
			File dir = directories.get(i);
			File[] filesInDir = dir.listFiles();

			for (File file : filesInDir) {
				if (file.isFile()) {
					allFilesPatches.add(file.getAbsolutePath());
				} else if (file.isDirectory()) {
					directories.add(file);
				}
			}
		}
        return allFilesPatches;
    }

    public static void main(String[] args) throws IOException{
        List<String> allFiles = getFileTree("./4.JavaCollections/");
		for (String filePath : allFiles) {
			System.out.println(filePath);
		}
    }
}
