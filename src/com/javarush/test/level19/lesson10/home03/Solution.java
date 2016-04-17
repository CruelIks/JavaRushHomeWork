package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

        String fileName = args[0];

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while (reader.ready())
            {

                String line = reader.readLine();

                String name = "";
                String birth = "";

                Pattern pattern = Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(line);
                matcher.find();
                int start = matcher.start();

                name = line.substring(0, start).trim();
                birth = line.substring(start).trim().replaceAll(" ", "/");

                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
                Date birthday = sdf.parse(birth);

                PEOPLE.add(new Person(name, birthday));


            }

            reader.close();
        }
        catch(IOException e) {e.printStackTrace();}
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        /*for (Person person : PEOPLE)
        {
            System.out.println(person.getName() + " " + person.getBirthday());
        }*/

    }

}
