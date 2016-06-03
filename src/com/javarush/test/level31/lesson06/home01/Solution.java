package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String filePath = args[0];
        File myFile = new File(filePath);
        String myFileName = myFile.getName();
        String archivePath = args[1];

        System.out.println(archivePath);
        ZipInputStream in = new ZipInputStream(new FileInputStream(archivePath));
        Map<ZipEntry, ByteArrayOutputStream> map = new HashMap<>();

        ZipEntry entry;
        while((entry = in.getNextEntry())!=null)
        {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] array = new byte[1024];

            int count;
            while ((count = in.read(array)) != -1) {
                baos.write(array, 0, count);
            }
            map.put(entry, baos);

            baos.close();

        }

        in.close();


        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(archivePath));

        for (ZipEntry zipEntry : map.keySet())
        {

            if (zipEntry.getName().equals(myFileName)) continue;

            out.putNextEntry(zipEntry);
            out.write(map.get(zipEntry).toByteArray());
            out.closeEntry();
            
        }



        /*FileInputStream fis = new FileInputStream(filePath);
        byte[] fileArray = new byte[fis.available()];
        fis.read(fileArray);
        fis.close();

        ZipEntry newEntry = new ZipEntry("new/" + myFileName);
        out.putNextEntry(newEntry);
        out.write(fileArray);
        out.closeEntry();*/

        out.close();

    }
}
