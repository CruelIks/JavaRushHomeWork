package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {

    public static void main(String[] args) throws IOException
    {
        List<String> list = getFileTree("D:/Test/");

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static List<String> getFileTree(String root) throws IOException {

        List<String> fileList = new ArrayList<>();

        PriorityQueue<File> queue = new PriorityQueue<>();
        queue.offer(new File(root));

        while(true)
        {
            File file = queue.poll();
            if (file == null) break;

            File[] array = file.listFiles();
            if (array == null) break;

            for (File currentFile : array){
                if (currentFile.isDirectory()){
                    queue.offer(currentFile);
                }
                else{
                    fileList.add(currentFile.getAbsolutePath());
                }
            }
        }

        return fileList;

    }
}
