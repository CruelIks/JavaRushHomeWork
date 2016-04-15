package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution
{
    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner sc)
        {
            scanner = sc;
        }

        @Override
        public Person read() throws IOException
        {
            String line = scanner.nextLine();
            String[] pers = line.split(" ");

            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
            Date bd = null;
            try
            {
                bd = sdf.parse(pers[3] + " " + pers[4] + " " + pers[5]);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }

            Person person = new Person(pers[1], pers[2], pers[0], bd);
            return person;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
