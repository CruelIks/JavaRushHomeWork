package com.javarush.test.level17.lesson10.home09;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution
{
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        String fileName, fileName2, line;
        Scanner sc;

        sc = new Scanner(System.in);
        fileName = sc.nextLine();
        fileName2 = sc.nextLine();
        try
        {
            allLines = getAllLines(fileName);
            forRemoveLines = getAllLines(fileName2);
            new Solution().joinData();
        }

        catch (CorruptedDataException e)
        {
            e.printStackTrace();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        finally
        {

            printList(allLines);
            sc.close();
        }

    }

    public void joinData() throws CorruptedDataException
    {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else{
            allLines.clear();
            throw new CorruptedDataException();
        }

    }

    public static List<String> getAllLines(String file) throws IOException
    {
        List<String> list = new ArrayList<String>();
        String line;
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        while (true)
        {
            line = buffer.readLine();
            if (null == line) break;
            list.add(line);
        }
        buffer.close();
        reader.close();
        return list;

    }

    public static void printList(List<String> list) {

        for (String s : list) {
            System.out.println(s);
        }

    }
}
