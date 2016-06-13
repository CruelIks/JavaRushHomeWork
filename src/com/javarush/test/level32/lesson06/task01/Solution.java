package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword()
    {

        String numbers = "0123456789";
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String bigs = letters.toUpperCase();
        String pass = "";


        for (int i = 0; i < 5; i++)
        {
            int var = (int)(Math.random() * 3) + 1;


            switch (var){
                case 1: {
                    int position = (int)(Math.random() * numbers.length());
                    pass += numbers.charAt(position);

                    break;
                }
                case 2: {
                    int position = (int)(Math.random() * letters.length());
                    pass += letters.charAt(position);

                    break;
                }
                case 3: {
                    int position = (int)(Math.random() * bigs.length());
                    pass += bigs.charAt(position);

                    break;
                }

            }

        }

        int position = (int)(Math.random() * numbers.length());
        pass += numbers.charAt(position);
        position = (int)(Math.random() * letters.length());
        pass += letters.charAt(position);
        position = (int)(Math.random() * bigs.length());
        pass += bigs.charAt(position);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try
        {
            baos.write(pass.getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        return baos;
    }

}
