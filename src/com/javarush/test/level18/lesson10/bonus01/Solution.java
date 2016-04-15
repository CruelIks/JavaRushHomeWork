package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String key, inFile, outFile;
        key = args[0];
        inFile = args[1];
        outFile = args[2];

        FileInputStream in = new FileInputStream(inFile);
        FileOutputStream out = new FileOutputStream(outFile);

        while (in.available() > 0)
        {

            if (key.equals("-e"))
            {
                out.write(in.read() + 5);
            }
            else if (key.equals("-d"))
            {
                out.write(in.read() - 5);
            }
         }

        in.close();
        out.close();

    }

}
