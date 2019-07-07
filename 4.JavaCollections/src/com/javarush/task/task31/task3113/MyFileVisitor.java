package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private int dirs;
    private int files;
    private long size;
    
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (attrs.isDirectory()) {
            dirs++;
        }

        return super.preVisitDirectory(dir, attrs);
    }
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()) {
            files++;
            size += attrs.size();
        }
        return super.visitFile(file, attrs);
    }
    
    public long getSize() {
        return size;
    }
    
    public int getDirs() {
        return dirs;
    }
    
    public int getFiles() {
        return files;
    }
}


/*
    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        if (attrs.isDirectory()) {
            dirs++;
        }
        if (attrs.isRegularFile()) {
            files++;
            size += attrs.size();
        }
        return super.preVisitDirectory(dir, attrs);
    }
 */