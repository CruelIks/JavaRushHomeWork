package com.javarush.test.level22.lesson13.task02;

import java.io.*;

import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];

        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);

        byte[] array = new byte[in.available()];
        in.read(array);

        Charset utf = Charset.forName("UTF-8");
        String str = new String(array, utf);
        out.write(str.getBytes("Windows-1251"));

        in.close();
        out.close();
    }
}
