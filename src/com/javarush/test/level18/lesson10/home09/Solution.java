package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        boolean stopProgram = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!stopProgram)
        {

            try
            {
                String fileName = reader.readLine();
                FileInputStream in = null;
                try
                {
                    in = new FileInputStream(fileName);


                }
                catch (FileNotFoundException e)
                {
                    System.out.println(fileName);
                    stopProgram = true;

                }
                try
                {
                    if (in != null) in.close();
                }
                catch(IOException e) {e.printStackTrace();}

            }
            catch (IOException e) {e.printStackTrace();}
        }

        try
        {
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
