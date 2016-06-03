package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution
{
    public static void main(String[] args)
    {

        String pathFolder = args[0];
        String resultFileAbsolutePath = args[1];
        List<File> list = new ArrayList<>();
        List<File> resultList = new ArrayList<>();

        Comparator<File> comparator = new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                String fileName1 = o1.getName();
                String fileName2 = o2.getName();
                /*return o1.getName().compareTo(o2.getName());*/
                return fileName1.compareTo(fileName2);
            }
        };

        getFiles(pathFolder, list);

        for (File file : list)
        {
            if (file.length() > 50)
            {
                file.delete();
            } else
            {
                resultList.add(file);
            }
        }

        Collections.sort(resultList, comparator);

        File fileResult = new File(resultFileAbsolutePath);
        File newResult = new File(fileResult.getParent() + "/allFilesContent.txt");
        fileResult.renameTo(newResult);

        try
        {

            FileOutputStream out = new FileOutputStream(newResult);

            for (File file : resultList)
            {

                FileInputStream in = new FileInputStream(file);

                byte array[] = new byte[in.available()];
                in.read(array);

                out.write(array);
                out.write('\n');
                in.close();

            }

            out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        clearFolder(pathFolder);

    }

    private static void clearFolder(String pathF)
    {

        File folder = new File(pathF);
        File array[] = folder.listFiles();

        if (array == null) return;

        for (File file : array)
        {

            if (file.isDirectory())
            {
                if (file.length() == 0)
                {
                    file.delete();
                    continue;
                }

                clearFolder(file.getAbsolutePath());
            }

        }
    }

    public static void getFiles(String path, List<File> list)
    {

        File folder = new File(path);
        File array[] = folder.listFiles();

        if (array == null) return;

        for (File file : array)
        {

            if (file.isDirectory())
            {
                getFiles(file.getAbsolutePath(), list);
            } else
            {

                list.add(file);
            }

        }

    }
}
