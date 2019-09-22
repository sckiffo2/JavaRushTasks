package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
		File dir = new File(args[0]);
		File[] allFiles = dir.listFiles();
		File resultFileAbsolutePath = new File(args[1]);
		if (FileUtils.isExist(resultFileAbsolutePath)) {
			FileUtils.deleteFile(resultFileAbsolutePath);
		}
		resultFileAbsolutePath.createNewFile();

		String s = resultFileAbsolutePath.getParent();
		File allFilesContent = new File(s + "/" + "allFilesContent.txt");

		if (FileUtils.isExist(allFilesContent)) {
			FileUtils.deleteFile(allFilesContent);
		}
		if (FileUtils.isExist(resultFileAbsolutePath)) {
			FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
		}




		List<File> under50bytes = getFilesList(allFiles);
		sortList(under50bytes);






		writeData(allFilesContent, under50bytes);
	}

	private static ArrayList getFilesList(File[] allFiles) {
		ArrayList<File> under50bytes = new ArrayList<>();

		for (File file : allFiles) {
			if (file.isFile()) {
				if (file.length() <= 50) {
					under50bytes.add(file);

				}
			} else if (file.isDirectory()) {
				File[] subFolderFiles = file.listFiles();
				under50bytes.addAll(getFilesList(subFolderFiles));
			}

		}
		return under50bytes;
	}

	private static void sortList(List<File> list) {
		Collections.sort(list, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				String name1 = o1.getName();
				String name2 = o2.getName();
				return name1.compareTo(name2);
			}
		});

		for (File file : list) {
			System.out.println(file.getName());
		}
	}

	private static void writeData(File allFilesContent, List<File> under50bytes) throws IOException{
		FileOutputStream fos = new FileOutputStream(allFilesContent, true);
		for (File file : under50bytes) {
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[(int)file.length()];
			fis.read(buffer);
			fos.write(buffer);
			fos.write("\n".getBytes());
			fis.close();
		}
		fos.close();
	}
}